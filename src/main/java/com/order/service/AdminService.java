package com.order.service;

import com.order.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017-06-20.
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public List list(Map<String,Object> map){
       return adminDao.list(map);
    }
}
