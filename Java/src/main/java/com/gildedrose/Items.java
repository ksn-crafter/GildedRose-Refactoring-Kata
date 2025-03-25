package com.gildedrose;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Items {
    private final Item[] items;

    public Items(Item[] items) {
        this.items = items;
    }

    public void forEach(Consumer<? super Item> action) {
        Objects.requireNonNull(action);
        for (Item t : items) {
            action.accept(t);
        }
    }
}
