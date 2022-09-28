package com.gildedrose.strategies;


import com.gildedrose.items.Item;

public class StrategyContext {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "conjured";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    private UpdateQualityStrategy updateQualityStrategy;

    public StrategyContext(String name) {
        switch (name) {
            case AGED_BRIE:
                updateQualityStrategy = new AgedBrieStrategy();
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                updateQualityStrategy = new HammerStrategy();
                break;
            case BACKSTAGE_PASS:
                updateQualityStrategy = new BackstagePassStrategy();
                break;
            default:
                updateQualityStrategy = new DefaultUpdateQualityStrategy();
                if (isConjured(name)) {
                    updateQualityStrategy = new ConjuredItemStrategy();
                }
        }
    }

    private static boolean isConjured(String name) {
        return name.toLowerCase().contains(CONJURED);
    }

    public void updateQuality(Item item) {
        updateQualityStrategy.updateQuality(item);
    }
}
