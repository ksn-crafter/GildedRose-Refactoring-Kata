package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (isQualityLessThanFifty()) {
            increementQuality();
        }

        decreaseSellIn();

        if (isSellInLessThan(0) && isQualityLessThanFifty()) {
            increementQuality();
        }
    }
}
