package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
        }
    }

    private static void updateQuality(Item item) {
        if (!item.isAgedBrie()
                && !item.isBackstagePasses()) {
            item.decreaseQuality();
        } else {
            if (item.isQualityLessThanFifty()) {
                item.increementQuality();

                if (item.isBackstagePasses()) {
                    item.increementQualityForBackstagePassess();
                }
            }
        }

        item.decreaseSellIn();

        if (item.isSellInLessThan(0)) {
            if (!item.isAgedBrie()) {
                if (!item.isBackstagePasses()) {
                    item.decreaseQuality();
                } else {
                    item.reduceQualityToZero();
                }
            } else {
                if (item.isQualityLessThanFifty()) {
                    item.increementQuality();
                }
            }
        }
    }

}
