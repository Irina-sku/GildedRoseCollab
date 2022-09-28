package com.gildedrose.validatequality;

import com.gildedrose.items.Item;

public interface DecreaseableQuality {
    int MIN_QUALITY = 0;

    default void decreaseQuality(Item item) {
        if (item.getQuality() > MIN_QUALITY) {
            item.decrementQuality();
        }
    }
}
