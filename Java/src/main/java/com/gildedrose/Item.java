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

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isQualityGreaterThanZero() {
        return quality > 0;
    }

    private void decreementQuality() {
        quality = quality - 1;
    }

    protected boolean isQualityLessThanFifty() {
        return quality < 50;
    }

    protected void increementQuality() {
        quality = quality + 1;
    }

    protected boolean isSellInLessThan(int value) {
        return sellIn < value;
    }

    private void decreementSellIn() {
        sellIn = sellIn - 1;
    }

    protected void reduceQualityToZero() {
        quality = 0;
    }

    public boolean isQualityEqualTo(int value) {
        return quality == value;
    }


    public boolean isSellInEqualTo(int value) {
        return sellIn == value;
    }

    protected void decreaseQuality() {
        if (isQualityGreaterThanZero() && !isSulfuras()) {
            decreementQuality();
        }
    }

    protected void decreaseSellIn() {
        if (!isSulfuras()) {
            decreementSellIn();
        }
    }

    public void updateQuality() {
        decreaseQuality();
        decreaseSellIn();

        if (isSellInLessThan(0)) {
            decreaseQuality();
        }
    }
}
