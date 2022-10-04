package com.gildedrose.items;

public abstract class Item {

    protected static final int MAX_QUALITY = 50;
    protected static final int MIN_QUALITY = 0;
    private static final int EXPIRED = 0;

    private final String name;
    private int sellIn;
    private int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = validateQuality(quality);
    }

    public abstract void updateQuality();

    protected boolean sellByDateHasPassed(int sellIn) {
        return sellIn <= EXPIRED;
    }

    protected int validateQuality(int quality) {
        if (quality <= MIN_QUALITY) {
            return MIN_QUALITY;
        }
        return Math.min(quality, MAX_QUALITY);
    }

    public void increaseQuality() {
        if (quality < MAX_QUALITY) {
            incrementQuality();
        }
    }

    public void decreaseQuality() {
        if (quality > MIN_QUALITY) {
            decrementQuality();
        }
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
