package com.gildedrose.strategies;

import com.gildedrose.items.Item;

public class HammerStrategy implements UpdateQualityStrategy {

    public void updateQuality(Item item) {
        item.decrementSellIn();
    }

}
