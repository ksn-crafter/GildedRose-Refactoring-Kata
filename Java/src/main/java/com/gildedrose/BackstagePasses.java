package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(String eventName, int sellIn, int quality) {
        super(String.format("Backstage passes to a %s", eventName), sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (isQualityLessThanFifty()) {
            increementQuality();
            increementQualityForBackstagePassess();
        }

        decreaseSellIn();

        if (isSellInLessThan(0)) {
            reduceQualityToZero();
        }
    }
}
