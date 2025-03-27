package com.gildedrose;

public class BackstagePasses extends Item {

    public static final int SELLIN_LIMIT_FOR_INCREASING_QUALITY_BY_TWO = 11;
    public static final int SELLIN_LIMIT_FOR_INCREASING_QUALITY_BY_THREE = 6;

    public BackstagePasses(String eventName, int sellIn, int quality) {
        super(String.format("Backstage passes to a %s", eventName), sellIn, quality);
    }


    private void increaseQuality() {
        super.increementQuality();

        if (isSellInLessThan(SELLIN_LIMIT_FOR_INCREASING_QUALITY_BY_TWO) && isQualityLessThanMaxPermissibleQuality()) {
            super.increementQuality();
        }

        if (isSellInLessThan(SELLIN_LIMIT_FOR_INCREASING_QUALITY_BY_THREE) && isQualityLessThanMaxPermissibleQuality()) {
            super.increementQuality();
        }
    }

    @Override
    public void updateQuality() {
        if (isQualityLessThanMaxPermissibleQuality()) {
            increaseQuality();
        }

        decreaseSellIn();

        if (isSellInLessThan(0)) {
            reduceQualityToZero();
        }
    }
}
