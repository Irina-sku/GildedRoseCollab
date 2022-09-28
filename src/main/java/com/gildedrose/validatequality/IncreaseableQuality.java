package com.gildedrose.validatequality;

import com.gildedrose.items.Item;

public interface IncreaseableQuality {
    int MAX_QUALITY = 50;

    default void increaseQuality(Item item) {
        if (item.getQuality() < MAX_QUALITY) {
            item.incrementQuality();
        }
    }
}
