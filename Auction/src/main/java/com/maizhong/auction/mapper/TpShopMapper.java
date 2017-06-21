package com.maizhong.auction.mapper;

import com.maizhong.auction.pojo.TpShop;
import com.maizhong.auction.pojo.TpShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpShopMapper {
    long countByExample(TpShopExample example);

    int deleteByExample(TpShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TpShop record);

    int insertSelective(TpShop record);

    List<TpShop> selectByExample(TpShopExample example);

    TpShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TpShop record, @Param("example") TpShopExample example);

    int updateByExample(@Param("record") TpShop record, @Param("example") TpShopExample example);

    int updateByPrimaryKeySelective(TpShop record);

    int updateByPrimaryKey(TpShop record);
}