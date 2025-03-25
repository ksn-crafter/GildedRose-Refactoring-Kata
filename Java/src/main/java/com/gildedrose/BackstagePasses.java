package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(String eventName, int sellIn, int quality) {
        super(String.format("Backstage passes to a %s", eventName), sellIn, quality);
    }

    @Override
    public void increementQuality(){
        super.increementQuality();

        if (isSellInLessThan(11) && isQualityLessThanFifty()) {
            super.increementQuality();
        }

        if (isSellInLessThan(6) && isQualityLessThanFifty()) {
            super.increementQuality();
        }
    }

    @Override
    public void updateQuality() {
        if (isQualityLessThanFifty()) {
            increementQuality();
        }

        decreaseSellIn();

        if (isSellInLessThan(0)) {
            reduceQualityToZero();
        }
    }
}
