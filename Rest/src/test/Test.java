import com.maizhong.common.utils.JsonUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangF on 2017/4/1.
 */
public class Test{

    private static String carBrand = "/car/brand";
    private static String carList = "/car/carlist";
    private static String detail = "/car/detail";

    private static  String[] codes = new String[]{"6a5b71ba16644a96aaf1dc454d4aa011","1442a91b1fbc4989abdfc0dc4e12d038","2f97596ac9364b67bb2d06d42fcbe782","d752a06e4fc94317ab9b59a18af9f9e0","7b946323ee0e424ebfac03024cf3537d","488150d27d3f4d3c988cd78bb6b4f306"};


    private static  String code = "";
    private static Integer codeIndex  = 0;


    /**
     * 将就着看吧就
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("程序运行");
//        crawlerCarBrand();
//        crawlerCarType();
//        shouldData();
//        sync2016();
        syncCarBefore2016();
//        shouldData();
    }

    //http请求
    public static List<Map<String, Object>>  http(String url,Map<String, String> param) {
        String path = "http://jisucxdq.market.alicloudapi.com"+url;
        String appcode = "6a5b71ba16644a96aaf1dc454d4aa011";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);

        try {
            String json = doGet(path, headers, param);
            //获取response的body
            JsonResult result = JsonUtils.jsonToPojo(json, JsonResult.class);
            List<Map<String, Object>> list = result.getResult();
            return list;
//            FileWriter writer = new FileWriter(new File("C:\\Users\\Administrator\\Downloads\\carBrand.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    //http请求
    public static Object  httpGetMap(String url,Map<String, String> param) {
        String path = "http://jisucxdq.market.alicloudapi.com"+url;
        String appcode = code;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);

        try {
            String json = doGet(path, headers, param);
            //获取response的body
            JsonResultExt result = JsonUtils.jsonToPojo(json, JsonResultExt.class);

            return result.getResult();
//            FileWriter writer = new FileWriter(new File("C:\\Users\\Administrator\\Downloads\\carBrand.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }






    /***
     * 全部品牌 获取
     */
    public  static  void crawlerCarBrand() {
        Map<String, String> querys = new HashMap<String, String>();

        try {
            //获取response的body
            List<Map<String, Object>> list = http(carBrand,querys);

            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Downloads\\carBrand.txt"),false));
            for (Map<String, Object>  map:list) {
                writer.write(JsonUtils.objectToJson(map));
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 全部车系 获取
     */
    public  static  void crawlerCarType() throws IOException, InterruptedException {
        FileReader reader = new FileReader(new File("C:\\Users\\Administrator\\Downloads\\carBrand.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Downloads\\carSeries2.txt"), true));
        BufferedReader br = new BufferedReader(reader);

        HashMap<String, String> param = new HashMap<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            line = line.trim();
            Map map  = null;
            try {
                map = JsonUtils.jsonToPojo(line, Map.class);
            }catch (Exception e){
                map = new HashMap();
            }

            if (map==null||map.size()==0){
                System.out.println("brandMiss:   ");
                continue;
            }

            String id = get(map, "id");

            if (id!=null){
                System.out.println(id+"  数据获取中");
            }else{
                System.out.println("SeriesMiss:   "+line);
            }

            //清空参数
            param.remove("parentid");
            param.put("parentid",id);
//            int i = 100;
//            System.out.println("等待"+i);
//
//            Thread.sleep(i);

            //异常原因  字符串无法转换为list
            List<Map<String, Object>> list = http(carList, param);


            if (list==null){
                System.out.println(id);
                continue;
            }
            w.write(JsonUtils.objectToJson(list));

            w.newLine();
            w.flush();
        }

        w.close();
        br.close();

    }


    /***
     * 车系数据分析   获取  非 2016||1017的数据
     * @return
     */
    public static void shouldData() throws IOException, InterruptedException {

        FileReader reader = new FileReader(new File("C:\\Users\\Administrator\\Downloads\\carSeries2.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Downloads\\carSeriesBefore2016.txt"), true));
        BufferedReader br = new BufferedReader(reader);

        StringBuffer sb = new StringBuffer();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            line = line.trim();
            sb.append(line);
            if (!line.endsWith(",\"depth\":\"2\"}]")){
                continue;
            }
            String dataJson = sb.toString();
            sb = new StringBuffer();
            List<Map> maps = JsonUtils.jsonToList(dataJson, Map.class);

            int count = 0;

            //Json 数据为字符串拼接的
            for (Map map:maps) {
                Object o2 = map.get("carlist");
                if (o2!=null && o2 instanceof List){
                    for (Object obj:(List)o2) {
                        Object o3 = ((Map) obj).get("list");
                        if (o3!=null ) {//&& 03 instanceof List
                            for (Object obj2 : (List) o3) {
                                Map carType = ((Map)obj2);

                                //只获取最新车系的id
                                if (!get(carType,"yeartype").contains("2016")&&!get(carType,"yeartype").contains("2017")){
                                    StringBuffer info = new StringBuffer();
//                                    info.append("id:").append(get(carType,"id"))
//                                            .append("-").append("name:").append(get(carType,"name"))
//                                            .append("-").append("yeartype:").append(get(carType,"yeartype"));
                                    info.append(get(carType,"id"));
                                    w.write(info.toString());
                                    w.newLine();
                                    w.flush();
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
        w.close();
        br.close();

    }


    /**
     *
     * TODO  数据获取入口
     *
     * 获取2016||1017的车辆信息数据
     */
    public static void syncCarBefore2016() throws Exception {
        FileReader reader = new FileReader(new File("C:\\Users\\Administrator\\Downloads\\carSeriesBefore2016.txt"));
        File file = new File("C:\\Users\\Administrator\\Downloads\\before2016Car000.txt");
        BufferedWriter w = new BufferedWriter(new FileWriter(file, true));
        BufferedReader br = new BufferedReader(reader);

        HashMap<String, String> param = new HashMap<>();

        int count = 0;
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            line = line.trim();

            if (line!=null){
                System.out.println(line+"  数据获取中");
            }else{
                System.out.println("SeriesMiss:   "+line);
                continue;
            }
            //清空参数
            param.remove("carid");
            param.put("carid",line);
//            int i = 100;
//            System.out.println("等待"+i);
//
//            Thread.sleep(i);
            //阿里限制  跑满950条停止
            count++;
            if (count>960*(codeIndex+1) || "".equals(code)){


                /////////////////////
                //
                //  TODO 第一次失败
                //
                ////////////////////
//                codeIndex++;
//                count+=960;

                if(codes[5].equals(code)){
                    System.err.println("任务结束");
                    w.close();
                    br.close();
                    break;
                }
                code = codes[codeIndex];
                codeIndex++;
                System.err.println("提示  第"+codeIndex+"次数据更换");

                w.close();

                //更换文件
                w = new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Downloads\\"+"before2016Car00"+codeIndex+".txt"), true));
            }

            //异常原因  字符串无法转换为list
            Object obj = httpGetMap(detail, param);


            if (obj==null){
                System.err.println(obj);
                continue;
            }

            w.write(JsonUtils.objectToJson(obj));
            w.newLine();
            w.flush();

            System.out.println(count+"次抓取");
        }

        w.close();
        br.close();
    }






    private static  String get(Map map ,String key ){
        Object o = map.get(key);
        return o==null?"":o.toString();
    }


    public static String doGet(String url,Map<String, String> headers, Map<String, String> param) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));

                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);


            for (Map.Entry<String, String> e : headers.entrySet()) {
                httpGet.addHeader(e.getKey(), e.getValue());
            }

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
}


class JsonResult{

    private Long id;
    private String msg;
    private List<Map<String,Object>> result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Map<String, Object>> getResult() {
        return result;
    }

    public void setResult(List<Map<String, Object>> result) {
        this.result = result;
    }
}


class JsonResultExt {

    private Long id;
    private String msg;
    private Object result;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

class CarInfo{
    //TODO 數據JSON實體轉換
    private Map<String,String> body;
    private Map<String,String> wheel;
    private Map<String,String> seat;

    private Map<String,String> drivingauxiliary;
    private Map<String,String> chassisbrake;
    private Map<String,String> actualtest;
    private Map<String,String> light;
    private Map<String,String> safe;
    private Map<String,String> engine;
    private Map<String,String> doormirror;
    private Map<String,String> gearbox;
    private Map<String,String> entcom;
    private Map<String,String> aircondrefrigerator;
    private Map<String,String> internalconfig;

    private String yeartype;
    private String parentid;
    private String id;
    private String initial;
    private Base basic;

    private String productionstate;
    private String name;
    private String logo;
    private String depth;
    private String sizetype;
    private String price;
    private String salestate;


    public void setChassisbrake(Map<String, String> chassisbrake) {
        this.chassisbrake = chassisbrake;
    }

    public String getInitial() {
        return initial;
    }

    public Map<String, String> getBody() {
        return body;
    }

    public void setBody(Map<String, String> body) {
        this.body = body;
    }

    public Map<String, String> getWheel() {
        return wheel;
    }

    public void setWheel(Map<String, String> wheel) {
        this.wheel = wheel;
    }

    public Map<String, String> getSeat() {
        return seat;
    }

    public void setSeat(Map<String, String> seat) {
        this.seat = seat;
    }


    public void setInitial(String initial) {
        this.initial = initial;
    }

    public Base getBasic() {
        return basic;
    }

    public void setBasic(Base basic) {
        this.basic = basic;
    }

    public String getProductionstate() {
        return productionstate;
    }

    public void setProductionstate(String productionstate) {
        this.productionstate = productionstate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getSizetype() {
        return sizetype;
    }

    public void setSizetype(String sizetype) {
        this.sizetype = sizetype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalestate() {
        return salestate;
    }

    public void setSalestate(String salestate) {
        this.salestate = salestate;
    }


    public Map<String, String> getDrivingauxiliary() {
        return drivingauxiliary;
    }

    public void setDrivingauxiliary(Map<String, String> drivingauxiliary) {
        this.drivingauxiliary = drivingauxiliary;
    }

    public Map<String, String> getChassisbrake() {
        return chassisbrake;
    }


    public Map<String, String> getLight() {
        return light;
    }

    public void setLight(Map<String, String> light) {
        this.light = light;
    }

    public Map<String, String> getSafe() {
        return safe;
    }

    public void setSafe(Map<String, String> safe) {
        this.safe = safe;
    }

    public Map<String, String> getEngine() {
        return engine;
    }

    public void setEngine(Map<String, String> engine) {
        this.engine = engine;
    }

    public Map<String, String> getDoormirror() {
        return doormirror;
    }

    public void setDoormirror(Map<String, String> doormirror) {
        this.doormirror = doormirror;
    }

    public Map<String, String> getGearbox() {
        return gearbox;
    }

    public void setGearbox(Map<String, String> gearbox) {
        this.gearbox = gearbox;
    }

    public Map<String, String> getEntcom() {
        return entcom;
    }

    public void setEntcom(Map<String, String> entcom) {
        this.entcom = entcom;
    }

    public Map<String, String> getAircondrefrigerator() {
        return aircondrefrigerator;
    }

    public void setAircondrefrigerator(Map<String, String> aircondrefrigerator) {
        this.aircondrefrigerator = aircondrefrigerator;
    }

    public Map<String, String> getInternalconfig() {
        return internalconfig;
    }

    public void setInternalconfig(Map<String, String> internalconfig) {
        this.internalconfig = internalconfig;
    }

    public String getYeartype() {
        return yeartype;
    }

    public void setYeartype(String yeartype) {
        this.yeartype = yeartype;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getActualtest() {
        return actualtest;
    }

    public void setActualtest(Map<String, String> actualtest) {
        this.actualtest = actualtest;
    }
}

class Base{

    //基礎數據轉換
    private String seatnum;
    private String warrantypolicy;
    private String userfuelconsumption;
    private String saleprice;
    private String price;
    private String testaccelerationtime100;
    private String displacement;
    private String vechiletax;
    private String gearbox;
    private String comfuelconsumption;
    private String officialaccelerationtime100;
    private String maxspeed;

    public String getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(String seatnum) {
        this.seatnum = seatnum;
    }

    public String getWarrantypolicy() {
        return warrantypolicy;
    }

    public void setWarrantypolicy(String warrantypolicy) {
        this.warrantypolicy = warrantypolicy;
    }

    public String getUserfuelconsumption() {
        return userfuelconsumption;
    }

    public void setUserfuelconsumption(String userfuelconsumption) {
        this.userfuelconsumption = userfuelconsumption;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTestaccelerationtime100() {
        return testaccelerationtime100;
    }

    public void setTestaccelerationtime100(String testaccelerationtime100) {
        this.testaccelerationtime100 = testaccelerationtime100;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getVechiletax() {
        return vechiletax;
    }

    public void setVechiletax(String vechiletax) {
        this.vechiletax = vechiletax;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getComfuelconsumption() {
        return comfuelconsumption;
    }

    public void setComfuelconsumption(String comfuelconsumption) {
        this.comfuelconsumption = comfuelconsumption;
    }

    public String getOfficialaccelerationtime100() {
        return officialaccelerationtime100;
    }

    public void setOfficialaccelerationtime100(String officialaccelerationtime100) {
        this.officialaccelerationtime100 = officialaccelerationtime100;
    }

    public String getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(String maxspeed) {
        this.maxspeed = maxspeed;
    }
}
