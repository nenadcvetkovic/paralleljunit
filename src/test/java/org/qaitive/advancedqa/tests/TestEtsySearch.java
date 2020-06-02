package org.qaitive.advancedqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.qaitive.advancedqa.pages.EtsyHomePage;

@Execution(ExecutionMode.CONCURRENT)
public class TestEtsySearch extends BaseTest {

    @Test
    public void testSearch() {
        Assertions.assertThat(new EtsyHomePage(driver)
                .search("dirk nowitzki")
                .getSearchResults().size())
                .isEqualTo(60);
    }

    @Test
    public void testSearchFilter() {
        Assertions.assertThat(new EtsyHomePage(driver)
                .search("dirk nowitzki")
                .chooseCategory("Home & Living")
                .getSearchResults().size())
                .isEqualTo(20);

    }
}
