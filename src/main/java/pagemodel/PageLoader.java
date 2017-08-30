package pagemodel;

import selenium.DriverWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for loading all page objects.
 *
 */
public class PageLoader {
    private static final String CDP = "CHOOSE_DOMAIN_PAGE";
    private static final String CPP = "CHOOSE_PLAN_PAGE";
    private static final String CRP = "COMPLETE_REGISTRATION_PAGE";

    private final Map<String, AbstractPage> pages = new HashMap<String, AbstractPage>();

    public PageLoader() {
        DriverWrapper dw = new DriverWrapper();
        pages.put(CDP, new ChooseDomainPage(dw));
        pages.put(CPP, new ChoosePlanPage(dw));
        pages.put(CRP, new CompleteRegistrationPage(dw));
    }

    public ChooseDomainPage cdp() {
        return (ChooseDomainPage) pages.get(CDP);
    }

    public ChoosePlanPage cpp() {
        return (ChoosePlanPage) pages.get(CPP);
    }

    public CompleteRegistrationPage crp() {
        return (CompleteRegistrationPage) pages.get(CRP);
    }
}
