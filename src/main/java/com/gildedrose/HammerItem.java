package com.gildedrose;

public class HammerItem extends Item {
    public HammerItem(int sellIn) {
        super("Sulfuras, Hand of Ragnaros", sellIn, 80);
    }

    @Override
    public void updateQuality() {
       decreaseSellByDate();
    }

    @Override
    public int validateQuality(int quality) {
        return quality;
    }
}
