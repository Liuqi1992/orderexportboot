package com.order.service;

import com.order.dao.RootOrderDao;
import com.order.model.RootOrderModel;
import com.order.pojo.RootOrderEntity;
import com.order.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.awt.ModalExclude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RootOrderService {

    @Autowired
    private RootOrderDao rootOrderDao;

    public List<RootOrderModel> listPage(Map<String,Object> map){
        List<RootOrderEntity> list = rootOrderDao.listPage(map);
        List<RootOrderModel> result = new ArrayList<RootOrderModel>();
        if (list != null) {
            int index = 1;
            for (RootOrderEntity rootOrder : list) {
                RootOrderModel model = convertRootOrderEntityToModel(rootOrder);
                model.setSortNum(index++);
                result.add(model);
            }
        }
       return result;
    }



    public Long countNum(Map<String,Object> map) {
        return rootOrderDao.countNum(map);
    }

    public int AddRootOrder(RootOrderEntity rootOrder) {
        return rootOrderDao.insertSelective(rootOrder);
    }

    public int editRootOrder(RootOrderEntity rootOrder) {
        return rootOrderDao.updateByPrimaryKeySelective(rootOrder);
    }

    public int batchDelete(String ids) {
        ids = StringUtil.removeEndComma(ids);
        List<RootOrderEntity> list = new ArrayList<RootOrderEntity>();
        for (String id : ids.split(",") ) {
            RootOrderEntity rootOrder = new RootOrderEntity();
            rootOrder.setId(id);
            rootOrder.setUpdateTime(StringUtil.getFormatDate(new Date()));
            list.add(rootOrder);
        }
        return rootOrderDao.batchDelete(list);
    }

    private RootOrderModel convertRootOrderEntityToModel(RootOrderEntity rootOrder) {
        RootOrderModel model = new RootOrderModel();
        if (null != rootOrder) {
            model.setId(rootOrder.getId());
            model.setOrderNumber(rootOrder.getOrderNumber());
            model.setOrderName(rootOrder.getOrderName());
            model.setCustomId(rootOrder.getCustomId());
            model.setCustomName(rootOrder.getCustomName());
            model.setSales(rootOrder.getSales());
            model.setCreateTime(rootOrder.getCreateTime());
            model.setUpdateTime(rootOrder.getUpdateTime());
            model.setDeleted(rootOrder.getDeleted());
        }
        return model;
    }


    public RootOrderModel findById(String id) {
        if (null == id || id.equals("")) {
            return new RootOrderModel();
        }
        RootOrderEntity rootOrderEntity = rootOrderDao.selectByPrimaryKey(id);
        return convertRootOrderEntityToModel(rootOrderEntity);
    }
}
