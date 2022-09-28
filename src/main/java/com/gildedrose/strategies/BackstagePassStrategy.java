package com.gildedrose.strategies;

import com.gildedrose.items.Item;
import com.gildedrose.validatequality.IncreaseableQuality;

public class BackstagePassStrategy implements UpdateQualityStrategy, IncreaseableQuality {
    public void updateQuality(Item item) {
        if (sellByDateHasPassed(item.getSellIn())) {
            item.setQualityToZero();
        } else {
            handleQualityChange(item);
        }
        item.decrementSellIn();
    }

    private void handleQualityChange(Item item) {
        if (concertInTenDays(item.getSellIn())) {
            increaseQuality(item);
        }
        if (concertInFiveDays(item.getSellIn())) {
            increaseQuality(item);
        }
        increaseQuality(item);
    }

    private boolean concertInTenDays(int sellIn) {
        return sellIn <= 10;
    }

    private boolean concertInFiveDays(int sellIn) {
        return sellIn <= 5;
    }

}
