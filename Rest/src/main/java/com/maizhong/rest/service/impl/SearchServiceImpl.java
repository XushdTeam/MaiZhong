package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageInfo;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.pojo.TbCarExample;
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
 */
@Service
public class SearchServiceImpl implements SearchService {


    @Resource
    private SolrServer solrServer;

    @Resource
    private TbCarMapperExt tbCarMapperExt;



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

    /****
     * 查询结果返回
     * @param param
     * @return
     */
    @Override
    public JsonResult searchDoc(PageSearchParam param) {


        try {
            String query;

            //提取查询字段
            String q = param.getFiled("queryString");

            if (StringUtils.isBlank(q)) {
                query = "*:*";
            }else{
                query=q+":car_keywords";
            }
            SolrQuery solrQuery = new SolrQuery(query);

            Integer page = param.getPageIndex();
            solrQuery.setStart((page-1)*20);
            Integer rows = param.getPageSize();
            solrQuery.setRows(rows);

            if (StringUtils.isNotBlank(q)) {
                solrQuery.setHighlight(true);

                solrQuery.addHighlightField("car_name");
                solrQuery.setHighlightSimplePre("<font style='color:red'>");
                solrQuery.setHighlightSimplePost("</font>");

            }

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

            PageInfo<TbCarVo> info = new PageInfo<>();

            long numFound = documents.getNumFound();

            info.setList(tbCarVos);
            info.setTotal(numFound);
            info.setPageNum(page);
            info.setPageSize(rows);
            info.setPages(Integer.parseInt((numFound%rows>0?numFound/rows+1:numFound/rows)+""));


            return JsonResult.OK(info);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return JsonResult.Error("系统错误，请检查网络");
    }
}
