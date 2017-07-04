package redis;

import com.maizhong.auction.dao.JedisClient;
import com.maizhong.auction.mapper.TpShopMapper;
import com.maizhong.common.utils.ObjectUtil;
import com.maizhong.common.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by Xushd on 2017/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class testUtil {

    @Autowired
    private TpShopMapper tpShopMapper;

    @Autowired
    private JedisClient jedisClient;

    @Test
    public void getShop(){



//        String arae = "西城";
//        String citycode = "110102";
//        int page = 1;
//        for(int i=1;i<=page;i++){
//            String url = "http://dealer.autohome.com.cn/beijing?countyId="+citycode+"&&brandId=0&seriesId=0&factoryId=0&pageIndex="+i+"&kindId=0&orderType=0#pvareaid=2113385";
//
//            String html = HttpClientUtil.doGet(url);
//            Document doc = Jsoup.parse(html);
//            Elements ListDiv = doc.getElementsByAttributeValue("class","info-wrap");
//            for (Element element : ListDiv) {
//
//                TpShop tpShop = new TpShop();
//                String name = element.getElementsByClass("link").first().text();
//                tpShop.setName(name);
//                System.out.println(name);
//                String brand = element.getElementsByTag("em").text();
//                tpShop.setBrand(brand);
//                System.out.println(brand);
//                //地址
//                String address = element.getElementsByClass("info-addr").text();
//                System.out.println(address);
//                tpShop.setAddress(address);
//                tpShop.setArea(arae);
//
//                tpShopMapper.insert(tpShop);
//            }
//        }

    }


}
