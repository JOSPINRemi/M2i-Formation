package entity;

import org.example.entity.Product;
import org.example.exception.MaximumQualityException;
import org.example.exception.NegativeQualityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    private Product product;

    @BeforeEach
    void initProduct() {
        product = new Product();
        product.setSellIn(1);
        product.setQuality(5);
        product.setName("");
        product.setCategory("");
    }

    @Test
    void givenProductWithSellInGTZeroWhenUpdateThenQualityDecreasesByOne() {
        product.update();
        int result = product.getQuality();
        Assertions.assertEquals(4, result);
    }

    @Test
    void givenProductWithSellInEqualToZeroWhenUpdateThenQualityDecreasesByTwo() {
        product.setSellIn(0);
        product.update();
        int result = product.getQuality();
        Assertions.assertEquals(3, result);
    }

    @Test
    void givenProductWithQualityEqualToZeroWhenUpdateThenQualityNotNegative() {
        product.setQuality(0);
        Assertions.assertThrowsExactly(NegativeQualityException.class, () -> product.update());
    }

    @Test
    void givenProductWithQualityGT50WhenSetQualityThenQualityNotGT50() {
        Assertions.assertThrowsExactly(MaximumQualityException.class, () -> product.setQuality(51));
    }

    @Test
    void givenProductCalledBrieVieilliWhenUpdateThenQualityGrows(){
        product.setName("Brie Vieilli");
        product.update();
        int result = product.getQuality();
        Assertions.assertEquals(6, result);
    }

    @Test
    void givenDiaryProductWhenUpdateThenQualityDecreaseTwiceFast(){
        product.setCategory("diary");
        product.update();
        int result = product.getQuality();
        Assertions.assertEquals(3, result);
    }
}
