import com.baran.java8.samples.drools.config.DroolsBeanFactory;
import com.baran.java8.samples.drools.model.Customer;
import com.baran.java8.samples.drools.model.Offer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import static org.junit.Assert.assertEquals;

@Slf4j
public class DiscountExcelIntegrationTest {
    private KieSession kieSession;

    @Before
    public void setup(){
        String ruleFilePath = "com.baran.java8.samples.drools/DroolsDiscount.xlsx";
        Resource resource = ResourceFactory
                .newClassPathResource(ruleFilePath,getClass());
        kieSession = new DroolsBeanFactory().getKieSession(resource);
      //log.info(new DroolsBeanFactory().getDrlFromExcel(ruleFilePath));
    }

    @Test
    public void giveIndvidualLongStanding_whenFireRule_thenCorrectDiscount() throws Exception {
        // Add a Customer with its personal data and needs, used for the LHS Decision
        log.info("Inside giveIndvidualLongStanding_whenFireRule_thenCorrectDiscount");
        Customer customer = new Customer();
        customer.setLifeStage(Customer.CustomerLifeStage.CAREERFOCUSED);
        customer.setAssets(Customer.CustomerAssets.FROM150KTO300K);
        customer.addNeed(Customer.CustomerNeed.LIFEINSURANCE);
        customer.addNeed(Customer.CustomerNeed.SAVINGACCOUNT);
        customer.addNeed(Customer.CustomerNeed.MORTAGE);
        kieSession.insert(customer);
        Offer offer = new Offer();
        kieSession.setGlobal("offer", offer);
        kieSession.fireAllRules();
        assertEquals(offer.getDiscount(), 10);
        assertEquals(offer.getFinancialPackage(), Offer.ProductPackage.CAREERFOCUSED_PACKAGE);
        assertEquals(offer.getProducts().size(),2);
    }
}
