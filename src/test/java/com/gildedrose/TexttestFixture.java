package com.gildedrose;

import com.gildedrose.items.AgedBrieItem;
import com.gildedrose.items.BackstagePassItem;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.Item;
import com.gildedrose.items.LegendaryItem;
import com.gildedrose.items.RegularItem;

public class TexttestFixture {
    public static void main(String[] args) {

        Item[] items = new Item[]{
                new RegularItem("+5 Dexterity Vest", 10, 20),
                new AgedBrieItem("Aged Brie", 2, 0),
                new RegularItem("Elixir of the Mongoose", 5, 7),
                new LegendaryItem("Sulfuras, Hand of Ragnaros", 15, 80),
                new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80),
                new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 10, 35),
                new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 25),
                new ConjuredItem("Conjured Mana Cake", 2, 20)
        };

        GildedRose app = new GildedRose(items);

        int days = 4;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
