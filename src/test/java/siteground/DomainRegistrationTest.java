package siteground;

import org.junit.Test;
import utils.Domains;
import utils.Plans;

/**
 * Domain registration tests.
 */
public class DomainRegistrationTest extends AbstractTest {
    private static final String DOMAIN = "mydomainfortesting";

    @Test
    public void domainRegistration() {
        Plans plan = Plans.GROW_BIG;
        Domains domainExtension = Domains.ORG;

        cpp.selectPlan(plan);

        cdp.checkDomainRegistrationPrice();
        cdp.pickDomainName(DOMAIN, domainExtension);

        crp.checkCorrectDomainInMessage(DOMAIN.concat(domainExtension.getExtension()));
        crp.checkCorrectDomainPlanSelected(plan);
    }
}
