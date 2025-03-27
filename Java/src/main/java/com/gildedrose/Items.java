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

    //TODO: this only works because in test cases we are using first item for testing
    //had there been a much more comprehensive test suite, we would have to expose
    //an iterator that returns a deep copy of the object
    public Item firstItem(){
        return items[0].clone();
    }
}
