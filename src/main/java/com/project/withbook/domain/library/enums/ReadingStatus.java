package com.project.withbook.domain.library.enums;

public enum ReadingStatus {
    WISHLIST("찜"),
    READING("읽는 중"),
    COMPLETED("완독");

    private final String label;

    ReadingStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}