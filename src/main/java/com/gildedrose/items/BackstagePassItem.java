package com.gildedrose.items;

public class BackstagePassItem extends Item {
    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (sellByDateHasPassed(getSellIn())) {
            setQualityToZero();
        } else {
            handleQualityChange();
        }
        decrementSellIn();
    }

    private void handleQualityChange() {
        if (concertInTenDays(getSellIn())) {
            increaseQuality();
        }
        if (concertInFiveDays(getSellIn())) {
            increaseQuality();
        }
        increaseQuality();
    }

    private boolean concertInTenDays(int sellIn) {
        return sellIn <= 10;
    }

    private boolean concertInFiveDays(int sellIn) {
        return sellIn <= 5;
    }

}
