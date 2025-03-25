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
                items[i].decreaseQuality();
            } else {
                if (items[i].isQualityLessThanFifty()) {
                    items[i].increementQuality();

                    if (items[i].isBackstagePasses()) {
                        items[i].increementQualityForBackstagePassess();
                    }
                }
            }

            items[i].decreaseSellIn();

            if (items[i].isSellInLessThan(0)) {
                if (!items[i].isAgedBrie()) {
                    if (!items[i].isBackstagePasses()) {
                        items[i].decreaseQuality();
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
