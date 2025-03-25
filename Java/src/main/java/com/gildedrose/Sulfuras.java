package com.gildedrose;

public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        //We should neither decrease quality nor decrease the sellin date for sulfuras
        //So do nothing here, and leave the implementation empty for updateQuality()
    }
}
