package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new AgedBrieItem(2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new HammerItem(15), //
                new HammerItem(0),
                new BackstagePassItem(15, 20),
                new BackstagePassItem(10, 35),
                new BackstagePassItem(5, 25),
                // this conjured item does not work properly yet
                new ConjuredItem("Conjured Mana Cake", 1, 6) };

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
