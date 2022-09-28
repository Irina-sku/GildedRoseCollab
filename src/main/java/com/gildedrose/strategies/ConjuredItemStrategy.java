package com.gildedrose.strategies;

import com.gildedrose.items.Item;
import com.gildedrose.validatequality.DecreaseableQuality;

public class ConjuredItemStrategy implements UpdateQualityStrategy, DecreaseableQuality {

    public void updateQuality(Item item) {
        if (sellByDateHasPassed(item.getSellIn())) {
            decreaseQuality(item);
        }
        decreaseQuality(item);
        item.decrementSellIn();
    }

    public void decreaseQuality(Item item) {
        for (int i = 0; i < 2; i++) {
            if (item.getQuality() > MIN_QUALITY) {
                item.decrementQuality();
            }
        }
    }
}
