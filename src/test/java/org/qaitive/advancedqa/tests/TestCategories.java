package org.qaitive.advancedqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.qaitive.advancedqa.pages.EtsyHomePage;

@Execution(ExecutionMode.CONCURRENT)
public class TestCategories extends BaseTest {


    @Test
    public void testCategoriesPresent() {
        Assertions.assertThat(
                new EtsyHomePage(this.driver)
                        .clickMenuCategory("Home & Living")
                        .getVisibleCategories()
                        .size()
        ).isEqualTo(9);
    }

    @Test
    public void testToyCategories() {
        Assertions.assertThat(
                new EtsyHomePage(this.driver)
                        .clickMenuCategory("Toys & Entertainment")
                        .getVisibleCategories()
                        .size()
        ).isEqualTo(3);
    }
}
