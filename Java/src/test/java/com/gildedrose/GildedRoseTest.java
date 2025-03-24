package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void qualityShouldIncreaseFromZeroToOneForAgedBrieAfterADay(){
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 0)
        };
        int days = 1;
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(1,items[0].quality);
    }

    @Test
    void qualityShouldDecreaseFromOneToZeroForNormalItemAfterADay(){
        Item[] items = new Item[]{  new Item("+5 Dexterity Vest", 10, 1)};
        GildedRose app = new GildedRose(items);

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(0,items[0].quality);
    }

    @Test
    void qualityShouldNotBeNegativeForNormalItemWithQualityZeroAfterADay(){
        Item[] items = new Item[]{  new Item("+5 Dexterity Vest", 10, 0)};
        GildedRose app = new GildedRose(items);

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(0,items[0].quality);
    }

    @Test
    void qualityShouldDegradeFromTwoToZeroForANormalItemPastItsSellByDate(){
        Item[] items = new Item[]{  new Item("+5 Dexterity Vest", 0, 2) };
        GildedRose app = new GildedRose(items);

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(0,items[0].quality);
    }

    @Test
    void qualityShouldNotIncreaseForAnyItemOverFifty(){
        Item[] items = new Item[]{  new Item("Aged Brie", 10, 50)};
        GildedRose app = new GildedRose(items);

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(50,items[0].quality);
    }

    @Test
    void qualityIncreasesByTwoForBackstagePassesWithLessThanTenSellinDays(){
        Item[] items = new Item[]{   new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20),};
        GildedRose app = new GildedRose(items);

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(22,items[0].quality);
    }

    @Test
    void qualityIncreasesByThreeForBackstagePassesWithLessThanFiveSellinDays(){
        Item[] items = new Item[]{   new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),};
        GildedRose app = new GildedRose(items);

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(23,items[0].quality);
    }

    @Test
    void qualityDropToZeroForBackstagePassesAfterSellinDays(){
        Item[] items = new Item[]{   new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),};
        GildedRose app = new GildedRose(items);

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(0,items[0].quality);
    }

    @Test
    void qualityDoesNotDecreaseForSulfurasItemAfterADay(){
        Item[] items = new Item[]{
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        };
        GildedRose app = new GildedRose(items);

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(80,items[0].quality);
    }

}
