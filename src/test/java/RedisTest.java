import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by wzhjdls on 2016/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_db.xml")
public class RedisTest {
    private static Logger log = Logger.getLogger(PropertisConfTest.class);

    @Autowired
    JedisPool jedisPool;

    //²éÑ¯ÓÐËùkey
    @Test
    public void getKeyTest() {
        Jedis jedis = jedisPool.getResource();
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            log.info("key : " + key);
        }
        jedisPool.getResource();
        jedis.close();
    }
}
