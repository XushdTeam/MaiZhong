package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.mapper.TbCarBrandLineMapper;
import com.maizhong.mapper.TbCarBrandMapper;
import com.maizhong.mapper.TbDictionaryMapper;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.pojo.*;
import com.maizhong.pojo.vo.TbCarVo;
import com.maizhong.rest.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
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
    private TbCarMapperExt tbCarMapperExt;

    @Resource
    private TbDictionaryMapper tbDictionaryMapper;

    @Resource
    private TbCarBrandMapper tbCarBrandMapper;

    @Resource
    private TbCarBrandLineMapper tbCarBrandLineMapper;



    @Override
    public JsonResult syncIndex() {
        try {
            //数据准备
            TbCarExample example = new TbCarExample();
            List<TbCarVo> vos = tbCarMapperExt.findList(example);

            //数据转换
            List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();

            SolrInputDocument document;
            for (TbCarVo vo:vos) {
                document = new SolrInputDocument();

                document.addField("id",vo.getId());
                document.addField("car_number",vo.getNumber());
                document.addField("car_name",vo.getName());
                document.addField("car_brand",vo.getCarBrand());
                document.addField("car_type",vo.getCarType());
                document.addField("car_yearSku",vo.getYearSku());
                document.addField("car_color",vo.getColor());
                //字符串处理
                String capacity = vo.getCapacity().replaceAll("[^0-9\\.]","");
                document.addField("car_capacity",capacity);

                document.addField("car_gearbox",vo.getGearbox());
                document.addField("car_asname",vo.getAsname());
                document.addField("car_sellpoint",vo.getSellpoint());
                document.addField("car_sellPrice",vo.getSellPrice());
                document.addField("car_reservePrice",vo.getReservePrice());
                document.addField("car_shopPrice",vo.getShopPrice());
                document.addField("car_createTime",vo.getCreateTime());
                document.addField("car_updateTime",vo.getUpdateTime());
                document.addField("car_image",vo.getImage());
                document.addField("car_details",vo.getDetails());

                //权值调整
                //未理解   暂时放弃
    //            document.setDocumentBoost(Short.parseShort(vo.getWeight()));


                docs.add(document);
            }

            solrServer.add(docs);
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.Error("索引添加失败");
        }
        return JsonResult.OK("添加成功");
    }

    /**
     * 查询结果返回
     * @param param
     * @return
     */
    @Override
    public JsonResult searchDoc(PageSearchParam param) {


        //初始化查询字段
        StringBuffer querysb = new StringBuffer("");
        Boolean highTiken = false;



        //判断查询字段 分布  拼装
        if (param!=null&&param.getSearchFileds()!=null){
            //如果存在queryString  按照参数进行查询
            if (param.getFiled("queryString")!=null){
                querysb.append("car_keywords:"+param.getFiled("queryString"));
                highTiken = true;
            }else{
                //如果查询string为空   遍历条件  添加条件
                Boolean bo = true;

                //判断条件    车型和车系为父子关系
                if (param.getFiled("car_brand")!=null){
                    //如果车系存在  使用车系进行搜索
                    if (param.getFiled("car_brand_line")!=null){
                        querysb.append("car_brand_line:").append(param.getFiled("car_brand_line"));
                        //反之  使用车型搜索
                    }else{
                        querysb.append("car_brand:").append(param.getFiled("car_brand"));
                    }
                    bo = false;
                }

                //颜色
                if (param.getFiled("car_color")!=null){
                    querysb.append(bo?"  ":" AND  ").append("car_color:").append(param.getFiled("car_color"));
                    bo = false;
                }

                //变速箱
                if (param.getFiled("car_gearbox")!=null){
                    querysb.append(bo?"  ":" AND  ").append("car_gearbox:").append(param.getFiled("car_gearbox"));
                    bo = false;
                }
                //类型
                if (param.getFiled("car_type")!=null){
                    querysb.append(bo?"  ":" AND  ").append("car_type:").append(param.getFiled("car_type"));
                    bo = false;
                }


                //售价
                if (param.getFiled("car_sellPrice")!=null){
                    String[] split =param.getFiled("car_sellPrice").replaceAll("[^0-9\\-\\.]", "").split("-");
                    if (split.length==2){
                        querysb.append(bo?"  ":" AND  ").append("car_sellPrice:")
                                .append("[").append(split[0]==""?"*":split[0]).append(" TO ").append(split[1]==""?"*":split[1]).append("]");
                    }
                    bo = false;
                }

                //排量
                if (param.getFiled("car_capacity")!=null){
                    String[] split =param.getFiled("car_capacity").replaceAll("[^0-9\\-\\.]", "").split("-");
                    if (split.length==2){
                        querysb.append(bo?"  ":" AND  ").append("car_capacity:")
                                .append("[").append(split[0]==""?"*":split[0]).append(" TO ").append(split[1]==""?"*":split[1]).append("]");
                    }
                    bo = false;
                }
            }
        }

        //如果没有查询条件   代表出错或者无查询条件  返回全部结果集
        if (querysb.length()==0){
            querysb.append("*:*");
        }

        SolrQuery solrQuery = new SolrQuery(querysb.toString());


        //添加分页信息
        Integer page = param.getPageIndex();
        solrQuery.setStart((page-1)*20);
        Integer rows = param.getPageSize();
        solrQuery.setRows(rows);

        //高亮开启
        if (highTiken){
            solrQuery.setHighlight(true);

            solrQuery.addHighlightField("car_name");
            solrQuery.setHighlightSimplePre("<font style='color:red'>");
            solrQuery.setHighlightSimplePost("</font>");
        }

        try {
            //solr库连接  返回查询条件
            QueryResponse response = solrServer.query(solrQuery);

            SolrDocumentList documents = response.getResults();
            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

            List<TbCarVo> tbCarVos = new ArrayList();
            TbCarVo tbCarVo = null;
            for (SolrDocument solrDocument : documents) {
                tbCarVo = new TbCarVo();
                tbCarVo.setId(solrDocument.get("id").toString());
                // 高亮处理
                if (highlighting!=null) {
                    List<String> names = highlighting.get(solrDocument.get("id")).get("car_name");
                    if (names != null && names.size() > 0) {
                        tbCarVo.setName(names.get(0));
                    }
                }else {
                    tbCarVo.setName(solrDocument.get("car_name").toString());
                }

                try {

                    //数据填充
                    tbCarVo.setNumber(solrDocument.get("car_number").toString());
                    tbCarVo.setYearSku(solrDocument.get("car_yearSku").toString());
                    tbCarVo.setSellpoint(solrDocument.get("car_sellpoint").toString());
                    tbCarVo.setSellPrice(solrDocument.get("car_sellPrice").toString());
                    tbCarVo.setImage(solrDocument.get("car_image").toString());
                    tbCarVo.setReservePrice(solrDocument.get("car_reservePrice").toString());

                    tbCarVos.add(tbCarVo);

                }catch (NullPointerException e){
                    continue;
                }
            }

            //结果处理
            //封装

            Map<String, Object> result = new HashMap<>();
            long numFound = documents.getNumFound();

            result.put("rows",tbCarVos);
            result.put("total",numFound);
            result.put("pageNum",page);
            result.put("pageSize",rows);
            result.put("pages",Integer.parseInt((numFound%rows>0?numFound/rows+1:numFound/rows)+""));

            return JsonResult.OK(result);

        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return JsonResult.Error("系统错误，请检查网络");
    }


    /***
     * 根据词典类型 返回List
     *
     * @param typeId
     * @return
     */
    @Override
    public JsonResult searchDicList(Long typeId) {
        if (typeId==null){
            return JsonResult.Error("数据错误");
        }
        TbDictionaryExample example = new TbDictionaryExample();
        example.createCriteria().andParentEqualTo(typeId);
        List<TbDictionary> list = tbDictionaryMapper.selectByExample(example);
        return list==null?JsonResult.Error("数据错误"):JsonResult.OK(list);
    }

    /**
     * 返回所有汽车品牌
     * */
    @Override
    public JsonResult searchCarBrandList() {
        List<TbCarBrand> list = tbCarBrandMapper.selectByExample(null);
        return  JsonResult.OK(list);
    }


    /***
     * 根据汽车品牌返回车系
     *         参数品牌Id为空返回TOP10
     * @return
     */
    @Override
    public JsonResult searchBrandLineList(Long brandId) {
        TbCarBrandLineExample example = new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = example.createCriteria();
        List<TbCarBrandLine> list = new ArrayList();
        if (brandId==null){
            //假装分页  希望缓存能撑住 = =
            //              应该用不到。。。。
            list.addAll(tbCarBrandLineMapper.selectByExample(null).subList(0,10));
        }else{
            criteria.andBrandIdEqualTo(brandId);
            list = tbCarBrandLineMapper.selectByExample(example);
        }

        return  JsonResult.OK(list);
    }

}
