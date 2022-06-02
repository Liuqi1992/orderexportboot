package com.order.controller;

import com.order.model.CustomInfoModel;
import com.order.model.ProductInfoModel;
import com.order.pojo.CustomInfoEntity;
import com.order.pojo.ProductInfoEntity;
import com.order.service.CustomService;
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
@RequestMapping("/custom")
public class CustomController extends BaseController {

    @Autowired
    private CustomService customService;

    @RequestMapping(value = "/listPage", method=RequestMethod.GET)
    public String systemPage() {
        return "/vm/customer/page";
    }

	@RequestMapping(value = "/list", method=RequestMethod.GET)
    @ResponseBody
	public Result list(@RequestParam(name = "page") Integer page, @RequestParam(name = "limit") Integer limit) {
        Map<String, Object> map = CommonPageDeal(page, limit);
	    Result rlt = new Result();
        List<CustomInfoModel> customInfoModels = customService.listPage(map);
        Long count = customService.countNum(map);
        rlt.setCode(0);
        rlt.setCount(count);
        rlt.setData(customInfoModels);
	    return rlt;
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    @ResponseBody
    public Result add(CustomInfoEntity customInfoEntity) {
        Result rlt = new Result();
        customInfoEntity.setId(UUID.randomUUID().toString());
        customInfoEntity.setCreateTime(StringUtil.getFormatDate(new Date()));
        customInfoEntity.setUpdateTime(StringUtil.getFormatDate(new Date()));
        customInfoEntity.setDeleted(Constants.DELETE_FLAG_F);
        customService.AddCustom(customInfoEntity);
        rlt.setCode(0);
        return rlt;
    }

    @RequestMapping(value = "/edit", method=RequestMethod.PUT)
    @ResponseBody
    public Result edit(CustomInfoEntity customInfo) {
        Result rlt = new Result();
        if (customInfo.getId() == null || customInfo.getId().equals("")) {
            rlt.setCode(-1);
            rlt.setMsg("custom id is empty");
            return rlt;
        }
        customInfo.setUpdateTime(StringUtil.getFormatDate(new Date()));
        customService.editCustom(customInfo);
        rlt.setCode(0);
        return rlt;
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam(name = "ids", required = false) String ids) {
        Result rlt = new Result();
        if (null == ids || "".equals(ids)) {
            rlt.setMsg("ids is empty");
            rlt.setCode(-1);
            return rlt;
        }
        customService.batchDelete(ids);
        rlt.setCode(0);
        return rlt;
    }

    public class Result {
        private int code;

        private String msg;

        private Long count;

        private List<CustomInfoModel> Data;

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

        public List<CustomInfoModel> getData() {
            return Data;
        }

        public void setData(List<CustomInfoModel> data) {
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
