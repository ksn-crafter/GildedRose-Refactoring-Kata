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
                        if (isSellInLessThan(i,11)) {
                            if (items[i].isQualityLessThanFifty()) {
                                items[i].increementQuality();
                            }
                        }

                        if (isSellInLessThan(i,6)) {
                            if (items[i].isQualityLessThanFifty()) {
                                items[i].increementQuality();
                            }
                        }
                    }
                }
            }

            if (!items[i].isSulfuras()) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (isSellInLessThan(i,0)) {
                if (!items[i].isAgedBrie()) {
                    if (!items[i].isBackstagePasses()) {
                        if (items[i].isQualityGreaterThanZero()) {
                            if (!items[i].isSulfuras()) {
                                items[i].decreementQuality();
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].isQualityLessThanFifty()) {
                        items[i].increementQuality();
                    }
                }
            }
        }
    }

    private boolean isSellInLessThan(int i,int value) {
        return items[i].sellIn < value;
    }

}
