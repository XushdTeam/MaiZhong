package com.maizhong.rest.service.impl;

import com.maizhong.mapper.TbMessageMapper;
import com.maizhong.mapper.ext.TbCarMapperExt;
import com.maizhong.pojo.TbCarExample;
import com.maizhong.pojo.TbMessage;
import com.maizhong.pojo.vo.TbCarVo;
import com.maizhong.rest.service.DataSyncService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 数据同步方法
 *      获取消息表中所有的数据
 *      遍历数据  成功后删除
 *                  失败后事务回滚
 *                  返回成功失败数量
 *
 *
 *
 * Created by yangF on 2017/3/30.
 */
@Service
public class DataSyncServiceImpl implements DataSyncService {

    @Resource
    private TbMessageMapper tbMessageMapper;


    /**
     *  * 数据同步方法
     *      获取消息表中所有的数据
     *      遍历数据  成功后删除
     *                  失败后事务回滚
     *                  返回成功失败数量
     *
     * @param messages
     * @return
     */
    //TODO 事务配置与控制
    @Override
    public String syncCar(List<TbMessage> messages) throws Exception {

        //判断出类型片段
        ArrayList<Long> delCarIds = new ArrayList<>();
        ArrayList<Long> addCarIds = new ArrayList<>();
        for (TbMessage message:messages) {
            switch (message.getMessageInfo()){
                case "car" :
                    switch (message.getMessageType()){
                        case "delete":
                            delCarIds.add(Long.valueOf(message.getOtherInfo()));
                            break;
                        case "modify":
                            //添加不需要删除文档
                            delCarIds.add(Long.valueOf(message.getOtherInfo()));
                        case "insert":
                            //无论添加修改 都需要进行文档添加 所以使用穿透
                            addCarIds.add(Long.valueOf(message.getOtherInfo()));
                            break;
                    }
                    break;
            }
        }

        List<TbCarVo> vos = this.findVosByIds(addCarIds);
        this.addSolrDocUseVo(vos);


        return null;
    }






    /**
     * 查询所有需要添加的汽车信息
     * @param ids
     * @return
     */
    private List<TbCarVo>  findVosByIds(List<Long> ids){

        if (ids==null||ids.size()>0){
            return null;
        }

        TbCarExample example = new TbCarExample();
        for (Long id:ids) {
            TbCarExample.Criteria or = example.or();
            or.andIdEqualTo(id);
        }
        List<TbCarVo> list = tbCarMapperExt.findListNotContainsDesc(example);
        return list;
    }

    /**
     *
     */


    @Resource
    private SolrServer solrServer;

    @Resource
    private TbCarMapperExt tbCarMapperExt;




    /**
     * 查询库中数据  然后添加到缓存中
     * @param vos
     */
    @Override
    public void addSolrDocUseVo(List<TbCarVo> vos) throws Exception{

        if (vos==null||vos.size()==0){
            return;
        }

        //数据转换
        List<SolrInputDocument> docs = new ArrayList<>();

        SolrInputDocument document;
        for (TbCarVo vo:vos) {
            document = new SolrInputDocument();
            //字符串处理
            String capacity = vo.getCapacity();
            if (StringUtils.isNotBlank(capacity)) {
                if (capacity.contains("T")||capacity.contains("L")){
                    document.addField("car_capacity",capacity.replaceAll("[^0-9\\.]",""));
                }else{
                    document.addField("car_capacity",0.0);
                }
            }
            String shopPrice = vo.getShopPrice();
            if (StringUtils.isNotBlank(shopPrice)) {
                String[] split = shopPrice.split("~");
                if (split.length>0){
                   document.addField("car_shopPrice",(split.length==2?split[1]:shopPrice).replaceAll("[^0-9\\.]", ""));
                }

            }

            //正常数据录入
            document.addField("id",vo.getId());
            document.addField("car_number",vo.getNumber());
            document.addField("car_name",vo.getName());
            document.addField("car_brand",vo.getCarBrand());
            document.addField("car_brandLine",vo.getCarBrandLine());
            document.addField("car_type",vo.getCarType());
            document.addField("car_year",vo.getCarYear());
            document.addField("car_color",vo.getCarColor());
            document.addField("car_gearbox",vo.getGearbox());
            document.addField("car_sellpoint",vo.getSellpoint());
            document.addField("car_sellPrice",vo.getSellPrice());
            document.addField("car_reservePrice",vo.getReservePrice());
            document.addField("car_createTime",vo.getCreateTime());
            document.addField("car_updateTime",vo.getUpdateTime());
            document.addField("car_image",vo.getImage());
            document.addField("car_smImage",vo.getSmimage());
            document.addField("car_details",vo.getDetails());
            document.addField("car_sellNum",vo.getSellNum());


            //copy  solr域同时存放 品牌id和 品牌名称  类似的数据
            //id 用于分类搜索  名称用于 中文搜索
            document.addField("car_brand_copy",vo.getCarBrandCopy());
            document.addField("car_brandLine_copy",vo.getCarBrandLineCopy());
            document.addField("car_type_copy",vo.getCarTypeCopy());
            //权值调整
            //未理解   放弃 在添加索引方面进行权重操作  改为搜索时计算公式
//                document.setDocumentBoost(Short.parseShort(vo.getWeight()));
            document.addField("weight",vo.getWeight());
            docs.add(document);


            solrServer.add(docs);
            solrServer.commit();
        }
    }



    private void addSingleSolrDoc(List<Long> ids){
        TbCarExample example = new TbCarExample();
//        example.createCriteria().andIdEqualTo();
        List<TbCarVo> list = tbCarMapperExt.findDocsForSolrStore(example);
        if (list==null&&list.size()==0){
            return;
        }
        TbCarVo vo  = list.get(0);
    }


}
