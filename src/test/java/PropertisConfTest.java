import com.cmcc.omp.omee.acs.northaccess.util.Configuration;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wzhjdls on 2016/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_db.xml")
public class PropertisConfTest {
    private static Logger log = Logger.getLogger(PropertisConfTest.class);

    @Test
    public void propertiesTest() {
        String rabbitAddr = (String) Configuration.getContextProperty("RabbitmqAddr");
        String performTest = (String) Configuration.getContextProperty("PerformTest");
        Assert.assertEquals(rabbitAddr, "192.168.16.176");
        Assert.assertEquals(performTest, "0");
        log.info("rabbitAddr:" + rabbitAddr);
        log.info("performTest:" + performTest);

    }
}
