package com.gildedrose;

import com.gildedrose.items.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieTest {

    @Test
    @DisplayName("Each day \"Aged Brie\" increases in quality.")
    void agedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 3, 5)};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(6, app.items[0].getQuality());
    }

    @Test
    @DisplayName("Once the sell by date has passed, quality of \"Aged Brie\" increases twice as fast")
    void agedBrieNotSold() {
        Item[] items = new Item[]{new Item("Aged Brie", -3, 5)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(7, app.items[0].getQuality());
    }

    @Test
    @DisplayName("The Quality of an \"Aged Brie\" is never more than 50.")
    void agedBrieWithQualityFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", -3, 50)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(50, app.items[0].getQuality());
    }

}
