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
                        decreementQuality(items[i]);
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].isBackstagePasses()) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].isSulfuras()) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].isAgedBrie()) {
                    if (!items[i].isBackstagePasses()) {
                        if (items[i].isQualityGreaterThanZero()) {
                            if (!items[i].isSulfuras()) {
                                decreementQuality(items[i]);
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private static void decreementQuality(Item item) {
        item.quality = item.quality - 1;
    }

}
