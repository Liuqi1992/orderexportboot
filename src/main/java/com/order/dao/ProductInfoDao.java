package com.order.dao;

import com.order.pojo.ProductInfoEntity;

import java.util.List;
import java.util.Map;

public interface ProductInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(ProductInfoEntity record);

    int insertSelective(ProductInfoEntity record);

    ProductInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductInfoEntity record);

    int updateByPrimaryKey(ProductInfoEntity record);

    List<ProductInfoEntity> listPage(Map<String, Object> map);

    Long countNum(Map<String, Object> map);

    int batchDelete(List<ProductInfoEntity> list);
}