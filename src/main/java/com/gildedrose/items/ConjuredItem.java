package com.gildedrose.items;

public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (sellByDateHasPassed(getSellIn())) {
            decreaseQuality();
        }
        decreaseQuality();
        decrementSellIn();
    }

    @Override
    public void decreaseQuality() {
        for (int i = 0; i < 2; i++) {
            if (getQuality() > MIN_QUALITY) {
                decrementQuality();
            }
        }
    }
}
