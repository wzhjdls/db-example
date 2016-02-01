import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wzhjdls on 2016/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_db.xml")
public class RabbitMQTest {
    private static Logger log = Logger.getLogger(RabbitMQTest.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void insertDataMQTest() {
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("test_queue_key1", "test01");
        }
    }

    @Test
    public void getDataMQTest() {
        String s = (String) amqpTemplate.receiveAndConvert("test_queue_key");
        log.info(s);
    }
}
