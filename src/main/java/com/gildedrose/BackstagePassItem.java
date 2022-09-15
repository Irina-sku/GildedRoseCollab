package com.gildedrose;

public class BackstagePassItem extends Item {

    public BackstagePassItem(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellByDateHasPassed()) {
            qualityDropsToZero();
        } else {
            increaseQuality();
        }
        decreaseSellByDate();
    }

    @Override
    protected void increaseQuality() {
        if (concertInTenDays()) {
            super.increaseQuality();
        }
        if (concertInFiveDays()) {
            super.increaseQuality();
        }
        super.increaseQuality();
    }


    private void qualityDropsToZero() {
        setQuality(0);
    }

    private boolean concertInTenDays() {
        return getSellIn() <=10;
    }

    private boolean concertInFiveDays() {
        return getSellIn() <= 5;
    }
}
