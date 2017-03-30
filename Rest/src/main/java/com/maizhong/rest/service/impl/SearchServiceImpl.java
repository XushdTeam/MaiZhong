package com.maizhong.rest.service.impl;

import com.maizhong.common.dto.*;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbCarBrandMapper;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.pojo.*;
import com.maizhong.pojo.vo.SearchResult;
import com.maizhong.pojo.vo.TbCarVo;
import com.maizhong.rest.service.DataSyncService;
import com.maizhong.rest.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 索引同步
 *      搜索方法
 *          solr定时器（不确定）
 *
 * Created by yangF on 2017/3/14.
 *
 * 根据前台页面完善查询条件
 *      update  yangF 2017/3/16
 *
 */
@Service
public class SearchServiceImpl implements SearchService {


    @Resource
    private SolrServer solrServer;

    @Resource
    private JedisClient jedisClient;

    @Resource
    private TbCarMapperExt tbCarMapperExt;


    @Resource
    private TbCarBrandMapper tbCarBrandMapper;


    @Resource
    private DataSyncService dataSyncService;

    @Value("${CAR_BRAND}")
    private String CAR_BRAND;

    @Value("${CAR_BRAND_HOT}")
    private String CAR_BRAND_HOT;

    @Value("${CAR_SERIES}")
    private String CAR_SERIES;


    @Value("${CAR_SERIES_HOT}")
    private String CAR_SERIES_HOT;


    @Value("${CAR_BRAND_GROUP}")
    private String CAR_BRAND_GROUP;


    @Value("${CAR_BRAND_ID}")
    private String CAR_BRAND_ID;

    @Value("${CAR_SERIES_ID}")
    private String CAR_SERIES_ID;

    @Value("${PAGESIZE}")
    public Integer PAGESIZE ;


    /**
     * solr索引同步
     *
     *
     *
     * @return
     */
    @Override
    public JsonResult syncIndex() {
        try {
            UpdateResponse response = solrServer.deleteByQuery("*:*");
            solrServer.commit();
            //数据准备与调用
            List<TbCarVo> vos = tbCarMapperExt.findDocsForSolrStore(null);
            dataSyncService.addSolrDocUseVo(vos);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error("索引添加失败");
        }
        return JsonResult.OK("添加成功");
    }

    /**
     * 查询结果返回
     * @param queryString,sortString,pageIndex,highTiken
     * @return
     */
    @Override
    public Map<String,Object> searchDoc(String queryString, String[] sortString,Integer pageIndex,String highTiken) {

        SolrQuery solrQuery = new SolrQuery(queryString);


        //添加分页信息
        if (pageIndex==null||pageIndex<1){
            pageIndex = 1;
        }
        solrQuery.setStart((pageIndex-1)*PAGESIZE);
        solrQuery.setRows(PAGESIZE);



        //排序
        if (sortString!=null&&sortString.length==2){
            solrQuery.addSort(sortString[0],
                    "asc".equalsIgnoreCase(sortString[1]) ? SolrQuery.ORDER.asc : SolrQuery.ORDER.desc);
            //时间排序  需要加上 创建时间以保证新车次序
            if (sortString[0].equals("car_year")){
                solrQuery.addSort("car_createTime",SolrQuery.ORDER.desc);
            }
        }


        //高亮开启
        if (StringUtils.isNotBlank(highTiken)){
            solrQuery.setHighlight(true);

            solrQuery.addHighlightField("car_name");
            solrQuery.setHighlightSimplePre("<font style='color:red;weight:bold;'>");
            solrQuery.setHighlightSimplePost("</font>");
        }

        try {
            //solr库连接  返回查询条件
            QueryResponse response = solrServer.query(solrQuery);

            SolrDocumentList documents = response.getResults();
            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

            List<TbCarDTO> tbCarVos = new ArrayList();

            //TBCarDto
            TbCarDTO tbCarDTO = null;
            for (SolrDocument solrDocument : documents) {
                tbCarDTO = new TbCarDTO();
                tbCarDTO.setId(solrDocument.get("id").toString());
                // 高亮处理
                if (highlighting!=null) {
                    List<String> names = highlighting.get(solrDocument.get("id")).get("car_name");
                    if (names != null && names.size() > 0) {
                        tbCarDTO.setName(names.get(0));
                    }
                }else {
                    tbCarDTO.setName(solrDocument.get("car_name").toString());
                }

//                    BeanUtils.copyProperties(solrDocument,tbCarDTO);


                //数据填充
                tbCarDTO.setNumber(getValue(solrDocument,"car_number"));
//                    tbCarDTO.setName(solrDocument.get("car_name").toString());
                tbCarDTO.setSellpoint(getValue(solrDocument,"car_sellpoint"));
                String car_shopPrice = getValue(solrDocument, "car_shopPrice");
                if (!"".equals(car_shopPrice+"")){
                    tbCarDTO.setShopPrice(Double.parseDouble(car_shopPrice));
                }
                tbCarDTO.setImage(getValue(solrDocument,"car_image"));
                tbCarDTO.setReservePrice(Double.parseDouble(getValue(solrDocument,"car_reservePrice")));
                String car_sellPrice = getValue(solrDocument, "car_sellPrice");
                if (!"".equals(car_sellPrice+"")){

                    tbCarDTO.setSellPrice(Double.parseDouble(car_sellPrice));
                }
//                    tbCarDTO.setSellPrice(Double.parseDouble(getValue(solrDocument,"car_sellPrice")));

                tbCarVos.add(tbCarDTO);
            }

            //结果处理
            //封装
            //      返回SearchResult

            SearchResult searchResult = new SearchResult();
            Map<String, Object> result = new HashMap<>();
            Long numFound = documents.getNumFound();

            result.put("rows",tbCarVos);
            result.put("currentPage",pageIndex);
            result.put("totalCount",numFound.intValue());
            result.put("totalPage",Integer.parseInt((numFound%PAGESIZE>0?numFound/PAGESIZE+1:numFound/PAGESIZE)+""));
            result.put("pageSize",PAGESIZE);
//            searchResult.setRows(tbCarVos);
//            searchResult.setCurrentPage(pageIndex);
//            searchResult.setTotal(numFound.intValue());
//            searchResult.setPageNum(Integer.parseInt((numFound%PAGESIZE>0?numFound/PAGESIZE+1:numFound/PAGESIZE)+""));
//            searchResult.setPageSize(PAGESIZE);


            return  result;

        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 从solrDocument中获取数据  避免toString时候的空指针  pojo字段名字起错了我好方。。
     * @param map
     * @param key
     * @return
     */
    private String  getValue(Map<String,Object> map,String key){
        Object o =  map.get(key);
        return o==null?"":o.toString();
    }

    /***
     * 查询入口
     *      SearchDoc 数据准备页面
     *
     * @param queryString
     * @param sortString
     * @param carBrand
     * @param carSeries
     * @param price
     * @param capacity
     * @param carYear
     * @param pageIndex
     * @return
     */
    @Override
    public JsonResult getSearchResult(String queryString, String sortString, String carBrand, String carSeries, String price, String capacity, String carYear, String pageIndex) {



        //初始化查询字段
        StringBuffer querysb = new StringBuffer("");
        Boolean highTiken = false;

        //排序字段  避免null指针 所以放在这里
        String[] sortArray = null;


        if (StringUtils.isNotBlank(queryString)){
            querysb.append("car_keywords:"+queryString);
            highTiken = true;
        }else{
            //如果查询string为空   遍历条件  添加条件
            Boolean bo = true;

            //判断条件    车型和车系为父子关系
            //      注意  页面返回数据为 id   所以使用car_brand搜索
            //如果车系存在  使用车系进行搜索  页面返回数据同样为 id
            if (StringUtils.isNotBlank(carSeries)){
                querysb.append("car_brandLine:").append(carSeries);
                bo = false;
                //反之  使用车型搜索
            }else if (StringUtils.isNotBlank(carBrand)){
                querysb.append("car_brand:").append(carBrand);
                bo = false;
            }


            //售价   目前使用数据  市场指导价格  非售价
            if (StringUtils.isNotBlank(price)){
                String[] split =price.replaceAll("[^0-9\\-\\.]", "").split("-");
                if (split.length==1||split.length==2){
                    querysb.append(bo?"  ":" AND  ").append("car_sellPrice:")
                            .append("[").append("".equals(split[0])?"*":split[0]).append(" TO ").append(split.length==2?("".equals(split[1])?"*":split[1]):"*").append("]");
                }
                bo = false;
            }

            //排量
            if (StringUtils.isNotBlank(capacity)){
                String[] split =capacity.replaceAll("[^0-9\\-\\.]", "").split("-");
                if (split.length==1||split.length==2){
                    querysb.append(bo?"  ":" AND  ").append("car_capacity:")
                            .append("[").append("".equals(split[0])?"*":split[0]).append(" TO ").append(split.length==2?("".equals(split[1])?"*":split[1]):"*").append("]");
                }
                bo = false;
            }
        }

        if (StringUtils.isNotBlank(sortString)){
            String[] split = sortString.split("-");
            if (split!=null&&split.length==2){
                sortArray = split;
            }
        }

        //如果没有查询条件   代表出错或者无查询条件  返回全部结果集
        if (querysb.length()==0){
            querysb.append("*:*");
        }

        Integer i;

        try {
            i = Integer.parseInt(pageIndex);
        }catch (Exception e){
            i = 1;
        }


        Map<String,Object> map = searchDoc(querysb.toString(),sortArray,i,highTiken?queryString:"");
        if (map==null||map.size()==0){
            map = searchDoc("*:*",null,1,"");
        }


        return JsonResult.OK(map);
    }



    /***
     *  搜索页面独有方法
     *      搜索页面显示车系
     *      当carbrand为空时 返回hot
     *       carbrand不为空时 根据carbrandId查询
     *       逻辑处理  当seriesId不为空并且有值的时候  将被选中的对应的seies放到队列第一位
     * @param brandId
     * @return
     */
    @Override
    public List<Object> getCarSeriesList(String brandId,String seriesId){
        String s = null;
        //如果 车型存在值  返回车型下的车系
        if (brandId!=null&&!"0".equals(brandId)){
            s = jedisClient.hget(CAR_SERIES,brandId);
        }
        List<TbCarBrandLine> lines = null;
        if (StringUtils.isNotBlank(s)){
            lines = JsonUtils.jsonToList(s,TbCarBrandLine.class);
        }else{
            //如果没有搜索到值  返回热门车系
            lines = JsonUtils.jsonToList(jedisClient.get(CAR_SERIES_HOT),TbCarBrandLine.class);
        }
//        //数据转换
        List<Object> result = new ArrayList<>();
        for (TbCarBrandLine line:lines) {
            //如果车系被选中  放置到首位
            if (seriesId!=null&&seriesId.equals(line.getId()+"")){
                result.add(0,line);
                continue;
            }
            result.add(line);
        }
//        for (TbCarBrandLine line:lines) {
//            result.add(new KeyValue(line.getId()+"",line.getLineName()));
//        }
        return result;
    }





    /***
     *  数据填充
     *      rest接口方法
     *          填充数据
     *              list hotcarBrand 热门汽车品牌
     *              list hotcarSeries   车系
     * @param brandId
     * @return
     */
    @Override
    public JsonResult getSearchBase(String brandId, String seriesId) {

        SearchBaseDTO searchBaseDTO = new SearchBaseDTO();

        //数据填充
        //      热门品牌
        searchBaseDTO.setCarSeriesAll(this.getCarSeriesList(brandId,seriesId));

        //热门品牌
        List<CarBrandDTO>  hotCarBrand= this.getCarBrandHot();
        List<KeyValue> hotCarBrandList = new ArrayList<>();
        for (CarBrandDTO carBrandDto:hotCarBrand) {
            if (carBrandDto.getId().toString().equals(brandId)){
                searchBaseDTO.setBrandHot(true);
                searchBaseDTO.setBrandName(carBrandDto.getName());
            }
            hotCarBrandList.add(new KeyValue(carBrandDto.getId().toString(),carBrandDto.getName()));
        }
        searchBaseDTO.setCarBrandhot(hotCarBrandList);

        //全部全部
        searchBaseDTO.setCarBrandAll(this.getCarBrandGroupByInitial());


        //品牌  名称
        if (brandId!=null&&!"0".equals(brandId)&&!searchBaseDTO.getBrandHot()){
//            TbCarBrand brand = JsonUtils.jsonToPojo(jedisClient.hget(CAR_BRAND_ID, brandId), TbCarBrand.class);
            searchBaseDTO.setBrandName(jedisClient.hget(CAR_BRAND_ID,brandId));
//            List<TbCarBrand> carBrands = JsonUtils.jsonToList(s,KeyValue.class);
//            for (TbCarBrand brand:carBrands) {
//                if (brandId.equals(brand.getId().toString())){
//                    searchBaseDTO.setBrandName(brand.getBrandName());
//                    break;
//                }
//            }
        }

        //车系  名称
        if (seriesId!=null&&!"0".equals(seriesId)){
            //TODO
            searchBaseDTO.setSeriesName(jedisClient.hget(CAR_SERIES_ID,seriesId));
//            String s = jedisClient.hget(CAR_SERIES, brandId);
//            List<TbCarBrandLine> list = JsonUtils.jsonToList(s, TbCarBrandLine.class);
//            for (TbCarBrandLine tbCarSeries:list) {
//                if (seriesId.equals(tbCarSeries.getId().toString())){
//                    searchBaseDTO.setSeriesName(seriesId);
//                    break;
//                }
//            }
        }

        //热门车系

        return JsonResult.OK(searchBaseDTO);
    }


    /**
     *  缓存查询
     *        数据  热门品牌
     *
     * @return
     */
    @Override
    public List<CarBrandDTO> getCarBrandHot() {
        String json = jedisClient.get(CAR_BRAND_HOT);
        List<CarBrandDTO> list = JsonUtils.jsonToList(json, CarBrandDTO.class);
        return list;
    }


    /***
     *  汽车品牌按照首字母：list 格式放入缓存
     */
    @Override
    public List<KeyObject> syncCarBrandGroup(){
        List<TbCarBrand> carBrands = tbCarBrandMapper.selectByExample(null);

        if (carBrands==null||carBrands.size()==0){
            jedisClient.set(CAR_BRAND_GROUP,"");
        }

        Map<String, List<KeyValue>> map = new HashMap<>();

        List<KeyValue> list = null;
        for (TbCarBrand carBrand:carBrands) {
            list = map.get(carBrand.getInitial());
            if (list==null){
                list = new ArrayList<>();
            }
            list.add(new KeyValue(carBrand.getId()+"",carBrand.getBrandName()));
            map.put(carBrand.getInitial(),list);
        }

        List<KeyObject> result = new ArrayList<>();

        for(char i='A';i<='Z';i++){
            if (map.get(i+"")==null){
                continue;
            }
            result.add(new KeyObject(i+"",map.get(i+"")));
        }
//
//        for (Map.Entry<String,List<KeyValue>> entry:map.entrySet()) {
//            result.add(new KeyObject(entry.getKey(),entry.getValue()));
//        }
        jedisClient.set(CAR_BRAND_GROUP,JsonUtils.objectToJson(result));

        return result;
    }

    /***
     * 缓存查询
     *      数据  根据首字母分组的品牌
     * @return
     */
    @Override
    public List<KeyObject> getCarBrandGroupByInitial(){

        String s = jedisClient.get(CAR_BRAND_GROUP);
        List<KeyObject> car_brand_group =null;
        if (s!=null){
            car_brand_group = JsonUtils.jsonToList(s, KeyObject.class);
        }else{
            car_brand_group = syncCarBrandGroup();
        }
        return car_brand_group;
    }

}
