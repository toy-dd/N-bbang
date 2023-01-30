package com.toydd.nbbang.payment;

import lombok.Getter;

import java.util.*;

@Getter
public enum Category {
    ETC(0, "기타"),
    FOOD(1, "음식"),
    CAFE(2, "카페"),
    BAR(3, "술집"),
    TRANS_FEE(4,"교통비");

    int code;
    String categoryName;

    private final static Map<Integer, String> map = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(c -> map.put(c.getCode(), c.name()));
    }

    Category(int code, String category) {
        this.code = code;
        this.categoryName = category;
    }

    public static Category ofCategoryCode(int categoryCode) {
        Optional<Category> category = Optional.of(Category.valueOf(map.get(categoryCode)));
        return category.orElseThrow(NoSuchElementException::new);
    }
}
