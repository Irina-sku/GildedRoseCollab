package com.gildedrose.strategies;

import com.gildedrose.items.Item;

public interface UpdateQualityStrategy {

    int EXPIRED = 0;

    void updateQuality(Item item);

    default boolean sellByDateHasPassed(int sellIn) {
        return sellIn <= EXPIRED;
    }
}
