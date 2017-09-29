package redis;

import com.maizhong.auction.dao.ActiveMqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created by Xushd on 2017/8/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class QueueTest {

    @Autowired
    private Destination socketSendMsgQueue;

    @Autowired
    private ActiveMqProducer activeMqProducer;

    @Test
    public void testMq(){
        activeMqProducer.sendMessage(socketSendMsgQueue,"Hello World!");
    }
}
