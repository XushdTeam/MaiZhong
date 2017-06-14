package redis;

import com.maizhong.auction.dto.PriceDto;
import com.maizhong.auction.service.AuctionService;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.auction.dao.JedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xushd on 2017/6/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class queue {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private JedisClient jedisClient;

    @Test
    public void redisTest(){

//        byte[] redisKey = "key".getBytes();
//
//        RedisMessage msg1 = new RedisMessage(1,"msg1",new Date());
//        jedisClient.lpush(redisKey,ObjectUtil.serializer(msg1));
//
//        RedisMessage msg2 = new RedisMessage(1,"msg2",new Date());
//        jedisClient.lpush(redisKey,ObjectUtil.serializer(msg2));
//
//        RedisMessage msg3 = new RedisMessage(1,"msg3",new Date());
//        jedisClient.lpush(redisKey,ObjectUtil.serializer(msg3));
//
//        long llen = jedisClient.llen(redisKey);
//        System.out.println(llen);
//
//        byte[] rpop = jedisClient.rpop(redisKey);
//        RedisMessage deserializer = ObjectUtil.deserializer(rpop, RedisMessage.class);
//        System.out.println(JsonUtils.objectToJson(deserializer));
//
//        llen = jedisClient.llen(redisKey);
//        System.out.println(llen);

    }

    @Test
    public void redisThreadTest() throws InterruptedException {

        PriceDto dto = new PriceDto(1000L,"system",new Date());
        jedisClient.hset("CHANNEL","CH1",JsonUtils.objectToJson(dto));

        for (int i = 1; i <= 10; i++) {
            int price = (int)(1+Math.random()*(10-1+1));
            price = 1000+10*price;
            System.out.println("Thread:"+"T"+i+"Price:"+price);
            Thread mThread = new Thread(new ThreadChanle((long) price,"T"+i),"T"+i);
            mThread.start();
        }
        TimeUnit.SECONDS.sleep(3);

    }
    /**
     * 内部类线程类
     */
    class ThreadChanle implements Runnable {
        public ThreadChanle(Long price,String ch) {
            this.ch = ch;
            this.price = price;
        }
        private String ch;
        private Long price;
        public void run() {
            PriceDto priceDto = new PriceDto(price,ch,new Date());

            boolean is = auctionService.auction(priceDto);
            if(is){
                System.out.println("Thread:"+ch+"Price:"+price+"SUCCESS:OK");
            }else{
                System.out.println("Thread:"+ch+"Price:"+price+"SUCCESS:ERROR");
            }

        }
    }
}
