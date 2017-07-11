import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarAcutionDTO;
import com.maizhong.common.utils.ObjectUtil;
import com.maizhong.common.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by Xushd on 2017/7/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class TTutils {

    @Autowired
    private JedisClient jedisClient;

    @Test
    public void test(){

    }
}
