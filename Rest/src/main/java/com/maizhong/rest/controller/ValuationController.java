package com.maizhong.rest.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.rest.service.ValuationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YangF on 2017/3/31.
 */
@Controller
public class ValuationController {


    @Resource
    private ValuationService valuationService;

    /**
     * 精确估值
     *      参数
     *          date  yyyy-MM
      */
    @RequestMapping("/test/test/{baseId}/{date}")
    @ResponseBody
    public JsonResult test(@PathVariable Long baseId,@PathVariable String date) throws IllegalAccessException {

        Double[] prices = valuationService.valuation(baseId, date, 12.0);

        baseId = baseId;

        Double[] well  = new Double[3];
        Double[] normal  = new Double[3];
        Double[] bad = new Double[3];

        if (prices!=null&&prices.length==3){
            well[0] = prices[0];
            well[1] = prices[0]*(0.92-(baseId%5)*0.01);
            well[2] = prices[0]*(0.83-(baseId%4)*0.01);

            normal[0] = prices[1];
            normal[1] = prices[1]*(0.92-(baseId%5)*0.01);
            normal[2] = prices[1]*(0.83-(baseId%4)*0.01);

            bad[0] = prices[2];
            bad[1] = prices[2]*(0.92-(baseId%5)*0.01);
            bad[2] = prices[2]*(0.83-(baseId%4)*0.01);
        }


        Map<String, Object> result = new HashMap<>();

        result.put("well",well);
        result.put("normal",normal);
        result.put("bad",bad);

        return JsonResult.OK(result);
    }


    /**
     * 精确估值
     *      参数
     *
     */
    @RequestMapping("/valuation")
    @ResponseBody
    public String valuation() throws IllegalAccessException {
        valuationService.valuation(3400L,"2014-12",12.0);
        return "";
    }


}
