package com.order.service;

import com.order.dao.CustomInfoDao;
import com.order.model.CustomInfoModel;
import com.order.model.ProductInfoModel;
import com.order.pojo.CustomInfoEntity;
import com.order.pojo.ProductInfoEntity;
import com.order.utils.StringUtil;
import org.hibernate.jpa.criteria.predicate.MemberOfPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CustomService {

    @Autowired
    private CustomInfoDao customInfoDao;

    public List<CustomInfoModel> listPage(Map<String,Object> map){
        List<CustomInfoEntity> list = customInfoDao.listPage(map);
        List<CustomInfoModel> result = new ArrayList<CustomInfoModel>();
        if (list != null) {
            int index = 1;
            for (CustomInfoEntity customInfo : list) {
                CustomInfoModel model = convertCustomInfoEntityToModel(customInfo);
                model.setSortNum(index++);
                result.add(model);
            }
        }
       return result;
    }

    public Long countNum(Map<String,Object> map) {
        return customInfoDao.countNum(map);
    }

    public int AddCustom(CustomInfoEntity customInfoEntity) {
        return customInfoDao.insertSelective(customInfoEntity);
    }

    public int editCustom(CustomInfoEntity customInfoEntity) {
        return customInfoDao.updateByPrimaryKeySelective(customInfoEntity);
    }

    public int batchDelete(String ids) {
        ids = StringUtil.removeEndComma(ids);
        List<CustomInfoEntity> list = new ArrayList<CustomInfoEntity>();
        for (String id : ids.split(",") ) {
            CustomInfoEntity customInfo = new CustomInfoEntity();
            customInfo.setId(id);
            customInfo.setUpdateTime(StringUtil.getFormatDate(new Date()));
            list.add(customInfo);
        }
        return customInfoDao.batchDelete(list);
    }

    private CustomInfoModel convertCustomInfoEntityToModel(CustomInfoEntity customInfo) {
        CustomInfoModel model = new CustomInfoModel();
        if (null != customInfo) {
            model.setId(customInfo.getId());
            model.setSupplierName(customInfo.getSupplierName());
            model.setLinkman(customInfo.getLinkman());
            model.setContact(customInfo.getContact());
            model.setCollectionAccount(customInfo.getCollectionAccount());
            model.setCollectionAccountNumber(customInfo.getCollectionAccountNumber());
            model.setDepositBank(customInfo.getDepositBank());
            model.setAlipay(customInfo.getAlipay());
            model.setCreateTime(customInfo.getCreateTime());
            model.setUpdateTime(customInfo.getUpdateTime());
            model.setDeleted(customInfo.getDeleted());
        }
        return model;
    }
}
