package com.gildedrose;

import com.gildedrose.items.BackstagePassItem;
import com.gildedrose.items.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 7, 6})
    @DisplayName("When the 'sell in' value is <= 10 && > 5, \"Backstage passes\" increase in quality by 2.")
    void backstagePass(int sellIn) {
        Item[] items = new Item[]{new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", sellIn, 5)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].getName());
        assertEquals(7, app.items[0].getQuality());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 1})
    @DisplayName("When the 'sell in' value is <= 5 && > 0, \"Backstage passes\" increase in quality by 3.")
    void lastMinuteBackstagePass(int sellIn) {
        Item[] items = new Item[]{new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", sellIn, 5)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].getName());
        assertEquals(8, app.items[0].getQuality());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("When the 'sell in' value is 0 or less, \"Backstage passes\" drop to 0 quality.")
    void expiredBackstagePass(int sellIn) {
        Item[] items = new Item[]{new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", sellIn, 5)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].getName());
        assertEquals(0, app.items[0].getQuality());
    }
}
