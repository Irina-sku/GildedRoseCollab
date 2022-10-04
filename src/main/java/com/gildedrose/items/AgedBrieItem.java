package com.gildedrose.items;


public class AgedBrieItem extends Item {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (sellByDateHasPassed(getSellIn())) {
            increaseQuality();
        }
        increaseQuality();
        decrementSellIn();
    }
}
