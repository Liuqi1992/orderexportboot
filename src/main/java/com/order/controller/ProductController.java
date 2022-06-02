package com.order.controller;

import com.order.model.ProductInfoModel;
import com.order.pojo.ProductInfoEntity;
import com.order.service.ProductService;
import com.order.utils.Constants;
import com.order.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@EnableAutoConfiguration
@EnableConfigurationProperties
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/listPage", method=RequestMethod.GET)
    public String systemPage() {
        return "/vm/system/page";
    }

	@RequestMapping(value = "/list", method=RequestMethod.GET)
    @ResponseBody
	public Result list(@RequestParam(name = "page") Integer page, @RequestParam(name = "limit") Integer limit) {
        Map<String, Object> map = CommonPageDeal(page, limit);
	    Result rlt = new Result();
        List<ProductInfoModel> productInfoModels = productService.listPage(map);
        Long count = productService.countNum(map);
        rlt.setCode(0);
        rlt.setCount(count);
        rlt.setData(productInfoModels);
	    return rlt;
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    @ResponseBody
    public Result add(ProductInfoEntity productInfo) {
        Result rlt = new Result();
        productInfo.setId(UUID.randomUUID().toString());
        productInfo.setCreateTime(StringUtil.getFormatDate(new Date()));
        productInfo.setUpdateTime(StringUtil.getFormatDate(new Date()));
        productInfo.setDeleted(Constants.DELETE_FLAG_F);
        productService.AddProduct(productInfo);
        rlt.setCode(0);
        return rlt;
    }

    @RequestMapping(value = "/edit", method=RequestMethod.PUT)
    @ResponseBody
    public Result edit(ProductInfoEntity productInfo) {
        Result rlt = new Result();
        if (productInfo.getId() == null || productInfo.getId().equals("")) {
            rlt.setCode(-1);
            rlt.setMsg("product id is empty");
            return rlt;
        }
        productInfo.setUpdateTime(StringUtil.getFormatDate(new Date()));
        productService.editProduct(productInfo);
        rlt.setCode(0);
        return rlt;
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam(name = "ids", required = false) String ids) {
        Result rlt = new Result();
        if (null == ids || "".equals(ids)) {
            rlt.setCode(-1);
            rlt.setMsg("ids is empty");
            return rlt;
        }
        productService.batchDelete(ids);
        rlt.setCode(0);
        return rlt;
    }

    public class Result {
        private int code;

        private String msg;

        private Long count;

        private List<ProductInfoModel> Data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<ProductInfoModel> getData() {
            return Data;
        }

        public void setData(List<ProductInfoModel> data) {
            Data = data;
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }
    }
}
