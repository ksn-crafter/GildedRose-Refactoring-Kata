package com.gildedrose;
//Data class
public class Item {

    //inappropriate intimacy
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public boolean isBackstagePasses() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isQualityGreaterThanZero() {
        return quality > 0;
    }

    public void decreementQuality() {
        quality = quality - 1;
    }

    public boolean isQualityLessThanFifty() {
        return quality < 50;
    }

    public void increementQuality() {
        quality = quality + 1;
    }
}
