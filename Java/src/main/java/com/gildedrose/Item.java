package com.gildedrose;

public class Item {

    public static final int MAX_PERMISSIBLE_QUALITY = 50;
    public static final int MIN_PERMISSIBLE_QUALITY = 0;
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

    private boolean isQualityGreaterThanZero() {
        return quality > MIN_PERMISSIBLE_QUALITY;
    }

    private void decreementQuality() {
        quality = quality - 1;
    }

    protected boolean isQualityLessThanMaxPermissibleQuality() {
        return quality < MAX_PERMISSIBLE_QUALITY;
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

    private void decreaseQuality() {
        if (isQualityGreaterThanZero()) {
            decreementQuality();
        }
    }

    protected void decreaseSellIn() {
        decreementSellIn();
    }

    public void updateQuality() {
        decreaseQuality();
        decreaseSellIn();

        if (isSellInLessThan(0)) {
            decreaseQuality();
        }
    }
}
