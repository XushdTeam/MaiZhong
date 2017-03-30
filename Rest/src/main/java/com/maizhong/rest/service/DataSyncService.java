package com.maizhong.rest.service;

import com.maizhong.pojo.TbMessage;
import com.maizhong.pojo.vo.TbCarVo;

import java.util.List;

/**
 * Created by yangF on 2017/3/30.
 */
public interface DataSyncService {
    String syncCar(List<TbMessage> messages);

    void addSolrDocUseVo(List<TbCarVo> vos) throws Exception;
}
