package com.gildedrose.strategies;

import com.gildedrose.items.Item;
import com.gildedrose.validatequality.DecreaseableQuality;

public class DefaultUpdateQualityStrategy implements UpdateQualityStrategy, DecreaseableQuality {

    public void updateQuality(Item item) {
        if (sellByDateHasPassed(item.getSellIn())) {
            decreaseQuality(item);
        }
        decreaseQuality(item);
        item.decrementSellIn();
    }
}
