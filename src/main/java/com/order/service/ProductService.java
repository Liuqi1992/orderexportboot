package com.order.service;

import com.order.dao.ProductInfoDao;
import com.order.model.AdminModel;
import com.order.model.ProductInfoModel;
import com.order.pojo.AdminEntity;
import com.order.pojo.ProductInfoEntity;
import com.order.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    public List<ProductInfoModel> listPage(Map<String,Object> map){
        List<ProductInfoEntity> list = productInfoDao.listPage(map);
        List<ProductInfoModel> result = new ArrayList<ProductInfoModel>();
        if (list != null) {
            int index = 1;
            for (ProductInfoEntity productInfo : list) {
                ProductInfoModel model = convertProductInfoEntityToModel(productInfo);
                model.setSortNum(index++);
                result.add(model);
            }
        }
       return result;
    }

    public Long countNum(Map<String,Object> map) {
        return productInfoDao.countNum(map);
    }

    public int AddProduct(ProductInfoEntity productInfoEntity) {
        return productInfoDao.insertSelective(productInfoEntity);
    }

    public int editProduct(ProductInfoEntity productInfoEntity) {
        return productInfoDao.updateByPrimaryKeySelective(productInfoEntity);
    }

    public int batchDelete(String ids) {
        ids = StringUtil.removeEndComma(ids);
        List<ProductInfoEntity> list = new ArrayList<ProductInfoEntity>();
        for (String id : ids.split(",") ) {
            ProductInfoEntity productInfo = new ProductInfoEntity();
            productInfo.setId(id);
            productInfo.setUpdateTime(StringUtil.getFormatDate(new Date()));
            list.add(productInfo);
        }
        return productInfoDao.batchDelete(list);
    }

    private ProductInfoModel convertProductInfoEntityToModel(ProductInfoEntity productInfo) {
        ProductInfoModel model = new ProductInfoModel();
        if (null != productInfo) {
            model.setId(productInfo.getId());
            model.setProductName(productInfo.getProductName());
            model.setDepartDate(productInfo.getDepartDate());
            model.setStock(productInfo.getStock());
            model.setCreateTime(productInfo.getCreateTime());
            model.setUpdateTime(productInfo.getUpdateTime());
            model.setDeleted(productInfo.getDeleted());
        }
        return model;
    }


}
