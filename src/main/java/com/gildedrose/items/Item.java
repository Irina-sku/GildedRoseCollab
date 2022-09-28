package com.gildedrose.items;

public class Item {

    private final String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void setQualityToZero() {
        quality = 0;
    }

    public void incrementQuality() {
        ++quality;
    }

    public void decrementQuality() {
        --quality;
    }

    public void decrementSellIn() {
        --sellIn;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
