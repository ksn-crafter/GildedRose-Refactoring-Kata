package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void qualityShouldIncreaseFromZeroToOneForAgedBrieAfterADay(){
        Item[] items = new Item[] {
            new AgedBrie(2, 0)
        };
        int days = 1;
        GildedRose app = new GildedRose(new Items(items));
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(1));
    }

    @Test
    void qualityShouldDecreaseFromOneToZeroForNormalItemAfterADay(){
        Item[] items = new Item[]{  new Item("+5 Dexterity Vest", 10, 1)};
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(0));
    }

    @Test
    void qualityShouldNotBeNegativeForNormalItemWithQualityZeroAfterADay(){
        Item[] items = new Item[]{  new Item("+5 Dexterity Vest", 10, 0)};
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(0));
    }

    @Test
    void qualityShouldDegradeFromTwoToZeroForANormalItemPastItsSellByDate(){
        Item[] items = new Item[]{  new Item("+5 Dexterity Vest", 0, 2) };
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(0));
    }

    @Test
    void qualityShouldNotIncreaseForAnyItemOverFifty(){
        Item[] items = new Item[]{  new AgedBrie(10, 50)};
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(50));
    }

    @Test
    void qualityIncreasesByTwoForBackstagePassesWithLessThanTenSellinDays(){
        Item[] items = new Item[]{   new BackstagePasses("TAFKAL80ETC concert", 9, 20),};
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(22));
    }

    @Test
    void qualityIncreasesByThreeForBackstagePassesWithLessThanFiveSellinDays(){
        Item[] items = new Item[]{   new BackstagePasses("TAFKAL80ETC concert", 4, 20),};
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(23));
    }

    @Test
    void qualityDropToZeroForBackstagePassesAfterSellinDays(){
        Item[] items = new Item[]{   new BackstagePasses("TAFKAL80ETC concert", 0, 20),};
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(0));
    }

    @Test
    void qualityDoesNotDecreaseForSulfurasItemAfterADay(){
        Item[] items = new Item[]{
            new Sulfuras( 0, 80), //
        };
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isQualityEqualTo(80));
    }

    @Test
    void sellInDoesNotDecreaseForSulfurasItemAfterADay(){
        Item[] items = new Item[]{
            new Sulfuras(2, 80), //
        };
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isSellInEqualTo(2));
    }

    @Test
    void sellInDecreasesForNonSulfurasItemAfterADay(){
        Item[] items = new Item[]{   new BackstagePasses("TAFKAL80ETC concert", 4, 20),};
        GildedRose app = new GildedRose(new Items(items));

        int days = 1;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertTrue(app.firstItem().isSellInEqualTo(3));
    }
}
