package com.order.service;

import com.order.dao.OrderInfoDao;
import com.order.model.OrderInfoModel;
import com.order.pojo.OrderInfoEntity;
import com.order.pojo.ProductInfoEntity;
import com.order.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    public List<OrderInfoModel> listPage(Map<String,Object> map){
        List<OrderInfoEntity> list = orderInfoDao.listPage(map);
        List<OrderInfoModel> result = new ArrayList<OrderInfoModel>();
        if (list != null) {
            int index = 1;
            for (OrderInfoEntity orderInfo : list) {
                OrderInfoModel model = convertOrderInfoEntityToModel(orderInfo);
                model.setSortNum(index++);
                result.add(model);
            }
        }
       return result;
    }

    public Long countNum(Map<String,Object> map) {
        return orderInfoDao.countNum(map);
    }

    public int AddOrder(OrderInfoEntity orderInfoEntity) {
        return orderInfoDao.insertSelective(orderInfoEntity);
    }

    public int editOrder(OrderInfoEntity orderInfoEntity) {
        return orderInfoDao.updateByPrimaryKeySelective(orderInfoEntity);
    }

    public int batchDelete(String ids) {
        ids = StringUtil.removeEndComma(ids);
        List<OrderInfoEntity> list = new ArrayList<OrderInfoEntity>();
        for (String id : ids.split(",") ) {
            OrderInfoEntity orderInfo = new OrderInfoEntity();
            orderInfo.setId(id);
            orderInfo.setUpdateTime(StringUtil.getFormatDate(new Date()));
            list.add(orderInfo);
        }
        return orderInfoDao.batchDelete(list);
    }

    private OrderInfoModel convertOrderInfoEntityToModel(OrderInfoEntity orderInfo) {
        OrderInfoModel model = new OrderInfoModel();
        if (null != orderInfo) {
            model.setId(orderInfo.getId());
            model.setOrderNumber(orderInfo.getOrderNumber());
            model.setOrderResource(orderInfo.getOrderResource());
            model.setNumber(orderInfo.getNumber());
            model.setOrderDate(orderInfo.getOrderDate());
            model.setDepartDate(orderInfo.getDepartDate());
            model.setOrderAmount(orderInfo.getOrderAmount());
            model.setCost(orderInfo.getCost());
            model.setCustomId(orderInfo.getCustomId());
            model.setSupplier(orderInfo.getSupplier());
            model.setTouristInfo(orderInfo.getTouristInfo());
            model.setBillAccount(orderInfo.getBillAccount());
            model.setCreateTime(orderInfo.getCreateTime());
            model.setUpdateTime(orderInfo.getUpdateTime());
            model.setDeleted(orderInfo.getDeleted());
        }
        return model;
    }


}
