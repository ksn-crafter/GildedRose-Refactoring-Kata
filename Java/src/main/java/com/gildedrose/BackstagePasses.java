package com.gildedrose;

public class BackstagePasses extends Item {

    public static final int INCREASE_QUALITY_BY_TWO_FOR_SELLIN_LIMIT = 11;
    public static final int INCREASE_QUALITY_BY_THREE_FOR_SELLIN_LIMIT = 6;

    public BackstagePasses(String eventName, int sellIn, int quality) {
        super(String.format("Backstage passes to a %s", eventName), sellIn, quality);
    }

    @Override
    public void increementQuality(){
        super.increementQuality();

        if (isSellInLessThan(INCREASE_QUALITY_BY_TWO_FOR_SELLIN_LIMIT) && isQualityLessThanMaxPermissibleQuality()) {
            super.increementQuality();
        }

        if (isSellInLessThan(INCREASE_QUALITY_BY_THREE_FOR_SELLIN_LIMIT) && isQualityLessThanMaxPermissibleQuality()) {
            super.increementQuality();
        }
    }

    @Override
    public void updateQuality() {
        if (isQualityLessThanMaxPermissibleQuality()) {
            increementQuality();
        }

        decreaseSellIn();

        if (isSellInLessThan(0)) {
            reduceQualityToZero();
        }
    }
}
