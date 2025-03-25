package com.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

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

    public boolean isSellInLessThan(int value) {
        return sellIn < value;
    }

    public void decreementSellIn() {
        sellIn = sellIn - 1;
    }

    public void reduceQualityToZero() {
        quality = 0;
    }

    public boolean isQualityEqualTo(int value) {
        return quality == value;
    }

    public void increementQualityForBackstagePassess() {
        if (isSellInLessThan(11) && isQualityLessThanFifty()) {
            increementQuality();
        }

        if (isSellInLessThan(6) && isQualityLessThanFifty()) {
            increementQuality();
        }
    }

    public boolean isSellInEqualTo(int value) {
        return sellIn == value;
    }

    public void decreaseQuality() {
        if (isQualityGreaterThanZero()) {
            if (!isSulfuras()) {
                decreementQuality();
            }
        }
    }

    public void decreaseSellIn() {
        if (!isSulfuras()) {
            decreementSellIn();
        }
    }
}
