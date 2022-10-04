package com.gildedrose.items;

public class LegendaryItem extends Item {

    private static final int LEGENDARY_ITEM_QUALITY = 80;

    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        decrementSellIn();
    }

    @Override
    protected int validateQuality(int quality) {
        return LEGENDARY_ITEM_QUALITY;
    }
}
