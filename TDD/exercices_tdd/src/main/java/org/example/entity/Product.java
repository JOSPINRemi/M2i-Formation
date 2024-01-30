package org.example.entity;

import org.example.exception.MaximumQualityException;
import org.example.exception.NegativeQualityException;

public class Product {
    private int sellIn;
    private int quality;
    private String name;
    private String category;

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void update() {
        int qualityChange;
        if (category.equals("diary") && sellIn == 0) {
            qualityChange = -4;
        } else if (category.equals("diary")) {
            qualityChange = -2;
        } else if (name.equals("Brie Vieilli")) {
            qualityChange = 1;
        } else if (sellIn == 0) {
            qualityChange = -2;
        } else {
            qualityChange = -1;
        }
        setQuality(quality + qualityChange);
        sellIn = -1;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        if (quality < 0) {
            throw new NegativeQualityException();
        }
        if (quality > 50) {
            throw new MaximumQualityException();
        }
        this.quality = quality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
