package com.gildedrose;

import com.gildedrose.items.Item;
import com.gildedrose.items.RegularItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegularItemTest {

    @Test
    @DisplayName("Each day a regular item degrades in quality and the 'sell in' value is decremented.")
    void regularItem() {
        Item[] items = new Item[] { new RegularItem("food", 1, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("food", app.items[0].getName());
        assertEquals(0, app.items[0].getSellIn());
        assertEquals(4, app.items[0].getQuality());
    }

    @Test
    @DisplayName("The quality of an item can never drop below zero.")
    void regularItemWithZeroQuality() {
        Item[] items = new Item[] { new RegularItem(    "food", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("food", app.items[0].getName());
        assertEquals(4, app.items[0].getSellIn());
        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    @DisplayName("Once the sell by date has passed, quality degrades twice as fast")
    void regularItemWithPassedSellInDate() {
        Item[] items = new Item[] { new RegularItem("food", -2, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("food", app.items[0].getName());
        assertEquals(-3, app.items[0].getSellIn());
        assertEquals(3, app.items[0].getQuality());
    }

}
