package com.gildedrose;

import com.gildedrose.items.Item;
import com.gildedrose.items.LegendaryItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegendaryItemTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 0, -10})
    @DisplayName("\"Sulfuras\", never has to be sold or decreases in Quality")
    void sulfuras(int sellIn) {
        Item[] items = new Item[]{new LegendaryItem("Sulfuras, Hand of Ragnaros", sellIn, 80)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].getName());
        assertEquals(sellIn - 1, app.items[0].getSellIn());
        assertEquals(80, app.items[0].getQuality());
    }

    @ParameterizedTest
    @ValueSource(ints = {80, 0})
    @DisplayName("\"Sulfuras\", is a legendary item and its Quality is 80 and it never alters")
    void sulfurasQuality(int quality) {
        Item[] items = new Item[]{new LegendaryItem("Sulfuras, Hand of Ragnaros", 10, quality)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].getName());
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(80, app.items[0].getQuality());
    }
}
