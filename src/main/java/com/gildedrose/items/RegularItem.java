package com.gildedrose.items;

public class RegularItem extends Item {

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (sellByDateHasPassed(getSellIn())) {
            decreaseQuality();
        }
        decreaseQuality();
        decrementSellIn();
    }
}
