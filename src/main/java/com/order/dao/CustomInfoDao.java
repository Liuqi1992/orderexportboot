package com.order.dao;

import com.order.pojo.CustomInfoEntity;
import com.order.pojo.ProductInfoEntity;

import java.util.List;
import java.util.Map;

public interface CustomInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(CustomInfoEntity record);

    int insertSelective(CustomInfoEntity record);

    CustomInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomInfoEntity record);

    int updateByPrimaryKey(CustomInfoEntity record);

    List<CustomInfoEntity> listPage(Map<String, Object> map);

    Long countNum(Map<String, Object> map);

    int batchDelete(List<CustomInfoEntity> list);
}