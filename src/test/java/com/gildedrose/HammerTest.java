package com.gildedrose;

import com.gildedrose.items.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HammerTest {

    @ParameterizedTest
    @ValueSource (ints = {10, 0, -10})
    @DisplayName("\"Sulfuras\", never has to be sold or decreases in Quality")
    void sulfuras(int sellIn) {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].getName());
        assertEquals(sellIn-1, app.items[0].getSellIn());
        assertEquals(80, app.items[0].getQuality());
    }
}
