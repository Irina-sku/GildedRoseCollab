package com.gildedrose.strategies;

import com.gildedrose.items.Item;
import com.gildedrose.validatequality.IncreaseableQuality;

public class AgedBrieStrategy implements UpdateQualityStrategy, IncreaseableQuality {

    public void updateQuality(Item item) {
        if (sellByDateHasPassed(item.getSellIn())) {
            increaseQuality(item);
        }
        increaseQuality(item);
        item.decrementSellIn();
    }
}
