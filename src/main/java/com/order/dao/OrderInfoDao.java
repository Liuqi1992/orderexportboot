package com.order.dao;

import com.order.pojo.OrderInfoEntity;
import com.order.pojo.ProductInfoEntity;

import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(OrderInfoEntity record);

    int insertSelective(OrderInfoEntity record);

    OrderInfoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderInfoEntity record);

    int updateByPrimaryKey(OrderInfoEntity record);

    List<OrderInfoEntity> listPage(Map<String, Object> map);

    Long countNum(Map<String, Object> map);

    int batchDelete(List<OrderInfoEntity> list);
}