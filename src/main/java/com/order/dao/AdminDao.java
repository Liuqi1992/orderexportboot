package com.order.dao;

import com.order.pojo.AdminEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017-06-19.
 */
public interface AdminDao {

    List<AdminEntity> list(Map<String, Object> map);
}
