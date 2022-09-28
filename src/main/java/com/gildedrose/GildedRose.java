package com.gildedrose;

import com.gildedrose.items.Item;
import com.gildedrose.strategies.StrategyContext;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            StrategyContext strategyContext = new StrategyContext(item.getName());
            strategyContext.updateQuality(item);
        }
    }
}
