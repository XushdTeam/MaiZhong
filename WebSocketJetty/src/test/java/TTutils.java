import com.alibaba.fastjson.JSONObject;
import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.dto.CarAcutionDTO;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.ObjectUtil;
import com.maizhong.common.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
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
        String key = "AuctionQueue:CH9";
        byte[] bytes = key.getBytes();
        List<byte[]> lrange = jedisClient.lrange(bytes);
        for (byte[] bytes1 : lrange) {
            CarAcutionDTO deserializer = ObjectUtil.deserializer(bytes1, CarAcutionDTO.class);
            System.out.println(JsonUtils.objectToJson(deserializer));
        }
    }
}
