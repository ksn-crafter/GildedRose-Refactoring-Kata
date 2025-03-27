package com.gildedrose;

import java.util.Arrays;
import java.util.function.Consumer;

class Items {
    private final Item[] items;

    public Items(Item[] items) {
        this.items = Arrays.stream(items).map(Item::clone).toArray(Item[]::new);
    }

    public void forEach(Consumer<? super Item> action) {
        if(items == null) return;
        for (Item t : items) {
            action.accept(t);
        }
    }

    public Item firstItem(){
        return items[0].clone();
    }
}
