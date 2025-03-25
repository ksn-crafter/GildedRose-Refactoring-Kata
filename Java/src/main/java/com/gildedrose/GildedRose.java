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
                decreaseQuality(items[i]);
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
                        decreaseQuality(items[i]);
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

    private static void decreaseQuality(Item item) {
        if (item.isQualityGreaterThanZero()) {
            if (!item.isSulfuras()) {
                item.decreementQuality();
            }
        }
    }

}
