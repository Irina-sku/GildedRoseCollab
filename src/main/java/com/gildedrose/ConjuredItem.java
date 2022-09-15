package com.gildedrose;

public class ConjuredItem extends Item {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        type = ItemType.CONJURED;
    }

    @Override
    protected void decreaseQuality() {
        setQuality(validateQuality(getQuality() - 2));
    }
}
