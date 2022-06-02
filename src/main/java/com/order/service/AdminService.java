package com.order.service;

import com.order.dao.AdminDao;
import com.order.model.AdminModel;
import com.order.pojo.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public List<AdminModel> list(Map<String,Object> map){
        List<AdminEntity> list = adminDao.list(map);
        List<AdminModel> result = new ArrayList<AdminModel>();
        if (list != null) {
            for (AdminEntity admin : list) {
                result.add(convertAdminEntityToModel(admin));
            }
        }
       return result;
    }

    private AdminModel convertAdminEntityToModel(AdminEntity admin) {
        AdminModel model = new AdminModel();
        model.setId(admin.getId());
        model.setName(admin.getName());
        model.setPassword(admin.getPassword());
        model.setCreatetime(admin.getCreatetime());
        model.setUpdatetime(admin.getUpdatetime());
        return model;
    }
}
