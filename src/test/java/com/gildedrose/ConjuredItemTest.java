package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredItemTest {

    @Test
    @DisplayName("Conjured Items should decrease in quality at twice the usual rate.")
    void conjuredItem() {
        Item[] items = new Item[] { new ConjuredItem("Conjured Food", 1, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].getSellIn());
        assertEquals(3, app.items[0].getQuality());
    }

    @Test
    @DisplayName("Conjured Items should decrease in quality at twice the usual rate, also when they are past the sellIn date.")
    void conjuredItemWithPassedSellInDate() {
        Item[] items = new Item[] { new ConjuredItem("Conjured Food", 0, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(1, app.items[0].getQuality());
    }
}
