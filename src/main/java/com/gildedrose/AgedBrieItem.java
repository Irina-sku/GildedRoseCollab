package com.gildedrose;

public class AgedBrieItem extends Item{

    public AgedBrieItem(final int sellIn, final int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellByDateHasPassed()) {
            increaseQuality();
        }
        increaseQuality();
        decreaseSellByDate();
    }
}
