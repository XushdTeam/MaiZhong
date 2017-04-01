package com.maizhong.rest.service.impl;


import com.maizhong.common.utils.TimeUtils;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.rest.service.ValuationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by YangF on 2017/3/31.
 */
@Service
public class ValuationServiceImpl implements ValuationService {


    @Resource
    private TbCarMapperExt tbCarMapperExt;

    /**
     * 二手车估价公式
     *
     *      param: baseId  基础库Id
     *              userDate  上牌日期   格式  yyyy-MM
     *              journey 公里数
     *
     */
    @Override
    public Double[] valuation(Long baseId, String useDate, Double journey) throws IllegalAccessException {
        //P=B*C*K
//        式中，P——被评估车辆的评估值；
        Double[] P = new Double[3];
//        B——重置成本；
        Double B = 0.00;
//        重置成本=全新车价+购置税
        //库中最新车价
        List<Map<String, Object>> list = tbCarMapperExt.findByBasePropToCount(baseId);
        String storePrice = "";
        Double displacement = 0.00;
        //找到库中同款式最新的车价
        if (list != null || list.size() > 0) {
            Map<String, Object> base = list.get(0);
            String name = get(base, "name");
            String type = "";
            if (name.contains("型") || name.contains("版")) {
                String[] split = name.split(" ");
                for (String splieName : split) {
                    if (splieName.contains("型") || splieName.contains("版")) {
                        type = splieName;
                        break;
                    }
                }
            }
            if (StringUtils.isBlank(type)) {
                storePrice = get(base, "shopPrice");
            } else {
                String factory = get(base, "factory");
                String gearbox = get(base, "gearbox");
                String series = get(base, "seriesName");
                storePrice = tbCarMapperExt.findPriceByTypeToCount(type, factory, gearbox,series);
            }
            //排量
            String dis = get(base, "displacement").replaceAll("[^0-9\\.]", "");
            if (StringUtils.isNotBlank(dis)) {
                displacement = Double.parseDouble(dis);
            }
        }
        if (StringUtils.isBlank(storePrice)) {
            return null;
            //仓库中数据包含汉字万与价格区间
        } else {
            String[] prices = storePrice.replaceAll("[^0-9\\-\\.]", "").split("-");
            prices[0] = prices[0].replaceAll("[^0-9\\.]", "");
            if (prices.length == 2) {
                prices[1] = prices[1].replaceAll("[^0-9\\.]", "");
                storePrice = mul(Double.parseDouble(prices[0]), Double.parseDouble(prices[1])) + "";
            } else {
                storePrice = prices[0];
            }
        }
        Double newPrice = Double.parseDouble(storePrice);

//                if (排量>1.6)Double tax = 0.06;   else   tax = 0.1;
        Double tax = displacement < 1.6 ? 0.06 : 0.1;
        B = mul(newPrice, add(tax, 1));
//        C——成新率； 1-(Y/G)*100%  Y已使用月份   G 规定使用月份一般为15年  180月
        Integer currentMonth = Integer.valueOf(TimeUtils.getYear()) * 12 + Integer.valueOf(TimeUtils.getMonth());
        String[] split = useDate.split("-");
        Integer useMonth = Integer.valueOf(split[0]) * 12 + Integer.valueOf(split[1]);
        Integer Y = currentMonth > useMonth ? currentMonth - useMonth : 0;

        //折旧法
         Y = ((Long)Math.round(div(Y,12,0))).intValue();
        Double C ;
        if (Y<=3){
            C = Math.pow(0.85,Y);
        }else if(Y<=5&&Y>3){
            C = Math.pow(0.9,Y-2)*Math.pow(0.85,3);
        }else {
            C = Math.pow(0.95,Y-5)*Math.pow(0/9,2)*Math.pow(0.85,3);
        }

        //重置成本法
//        Double C = sub(1.0, div(Y, 180.0,4));


//        K——综合调整系数。
        //模拟？那还能咋办。。。

        Double K = 1.0;

        Double div = div(journey, div(Y, 12, 3), 2);

        if (div<0.8){
            K = 0.95;
        }else if (div>=0.8&&div<1.5){
            K = 0.935;
        }else if(div>=1.5&&div<2.2){
            K = 0.912;
        }else if(div>=2.2&&div<3){
            K = 0.888;
        }else if(div>=3&&div<5.5){
            K = 0.830;
        }else {
            K = 0.75;
        }


        P[0] = mul(mul(B,C),K);
        P[1] = mul(mul(B,C),sub(K,0.035));
        P[2] = mul(mul(B,C),sub(K,0.065));
        return P;
    }




    public String get(Map<String,Object> map , String key){
        Object value = map.get(key);
        return value==null?"":value.toString();
    }


    /**
     * 提供精确加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确减法运算的sub方法
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mul(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的除法运算方法div
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static double div(double value1,double value2,int scale) throws IllegalAccessException{
        //如果精确范围小于0，抛出异常信息
        if(scale<0){
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
}
