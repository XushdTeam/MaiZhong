package com.maizhong.rest.service;

import com.maizhong.pojo.TbMessage;
import com.maizhong.pojo.vo.TbCarVo;

import java.io.IOException;
import java.util.List;

/**
 * Created by yangF on 2017/3/30.
 */
public interface DataSyncService {

    void addSolrDocUseVo(List<TbCarVo> vos) throws Exception;

    void deleteAll(List<String> ids) throws Exception;

    void dataSyncOfSingle(Long delId, Long insertId) throws Exception;

    String pinYinAnalysis(String initString) throws IOException;
}
