package com.gildedrose;

public class Item implements UpdatableQualityItemInterface, ValidatableQualityItemInterface {

    private final String name;

    private int sellIn;

    private int quality;

    protected ItemType type;

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = validateQuality(quality);
    }

    @Override
    public void updateQuality() {
        if (sellByDateHasPassed()) {
            decreaseQuality();
        }
        decreaseQuality();
        decreaseSellByDate();
    }

    protected void decreaseQuality() {
        quality = validateQuality(quality - 1);
    }

    protected void increaseQuality() {
        quality = validateQuality(quality + 1);
    }

    protected void decreaseSellByDate() {
        --sellIn;
    }

    protected boolean sellByDateHasPassed() {
        return sellIn <= 0;
    }

    @Override
    public int validateQuality(int quality) {
        if (quality <= MIN_QUALITY) {
            return MIN_QUALITY;
        }
        return Math.min(quality, MAX_QUALITY);
    }

    public void setQuality(int quality) {
        this.quality = validateQuality(quality);
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
