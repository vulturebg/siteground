package siteground;

import org.junit.After;
import org.junit.Before;
import pagemodel.ChooseDomainPage;
import pagemodel.ChoosePlanPage;
import pagemodel.CompleteRegistrationPage;
import pagemodel.PageLoader;

/**
 * Created by Branimir on 8/30/2017.
 */
public class AbstractTest {
    private static final PageLoader PAGE_LOADER = new PageLoader();

    protected ChooseDomainPage cdp = PAGE_LOADER.cdp();
    protected ChoosePlanPage cpp = PAGE_LOADER.cpp();
    protected CompleteRegistrationPage crp = PAGE_LOADER.crp();

    @Before
    public void setUp() {
        cdp.load();
    }

    @After
    public void tearDown() {
        cdp.close();
    }
}
