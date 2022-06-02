package com.order.dao;

import com.order.pojo.ProductInfoEntity;
import com.order.pojo.RootOrderEntity;

import java.util.List;
import java.util.Map;

public interface RootOrderDao {
    int deleteByPrimaryKey(String id);

    int insert(RootOrderEntity record);

    int insertSelective(RootOrderEntity record);

    RootOrderEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RootOrderEntity record);

    int updateByPrimaryKey(RootOrderEntity record);

    List<RootOrderEntity> listPage(Map<String, Object> map);

    Long countNum(Map<String, Object> map);

    int batchDelete(List<RootOrderEntity> list);
}