package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].isAgedBrie()
                    && !items[i].isBackstagePasses()) {
                if (items[i].isQualityGreaterThanZero()) {
                    if (!items[i].isSulfuras()) {
                        items[i].decreementQuality();
                    }
                }
            } else {
                if (items[i].isQualityLessThanFifty()) {
                    items[i].increementQuality();

                    if (items[i].isBackstagePasses()) {
                        items[i].increementQualityForBackstagePassess();
                    }
                }
            }

            if (!items[i].isSulfuras()) {
                items[i].decreementSellIn();
            }

            if (items[i].isSellInLessThan(0)) {
                if (!items[i].isAgedBrie()) {
                    if (!items[i].isBackstagePasses()) {
                        if (items[i].isQualityGreaterThanZero()) {
                            if (!items[i].isSulfuras()) {
                                items[i].decreementQuality();
                            }
                        }
                    } else {
                        items[i].reduceQualityToZero();
                    }
                } else {
                    if (items[i].isQualityLessThanFifty()) {
                        items[i].increementQuality();
                    }
                }
            }
        }
    }

}
