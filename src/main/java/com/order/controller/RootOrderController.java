package com.order.controller;

import com.order.model.ProductInfoModel;
import com.order.model.RootOrderModel;
import com.order.pojo.ProductInfoEntity;
import com.order.pojo.RootOrderEntity;
import com.order.service.ProductService;
import com.order.service.RootOrderService;
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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@EnableAutoConfiguration
@EnableConfigurationProperties
@RequestMapping("/rootorder")
public class RootOrderController extends BaseController {

    @Autowired
    private RootOrderService rootOrderService;

    @RequestMapping(value = "/listPage", method=RequestMethod.GET)
    public String systemPage() {
        return "/vm/rootorder/page";
    }

	@RequestMapping(value = "/list", method=RequestMethod.GET)
    @ResponseBody
	public Result list(@RequestParam(name = "page") Integer page, @RequestParam(name = "limit") Integer limit) {
        Map<String, Object> map = CommonPageDeal(page, limit);
	    Result rlt = new Result();
        List<RootOrderModel> rootOrderModels = rootOrderService.listPage(map);
        Long count = rootOrderService.countNum(map);
        rlt.setCode(0);
        rlt.setCount(count);
        rlt.setData(rootOrderModels);
	    return rlt;
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    @ResponseBody
    public Result add(RootOrderEntity rootOrder) {
        Result rlt = new Result();
        rootOrder.setId(UUID.randomUUID().toString());
        rootOrder.setCreateTime(StringUtil.getFormatDate(new Date()));
        rootOrder.setUpdateTime(StringUtil.getFormatDate(new Date()));
        rootOrder.setSales(new BigDecimal(0));
        rootOrder.setDeleted(Constants.DELETE_FLAG_F);
        rootOrderService.AddRootOrder(rootOrder);
        rlt.setCode(0);
        return rlt;
    }

    @RequestMapping(value = "/edit", method=RequestMethod.PUT)
    @ResponseBody
    public Result edit(RootOrderEntity rootOrder) {
        Result rlt = new Result();
        if (rootOrder.getId() == null || rootOrder.getId().equals("")) {
            rlt.setCode(-1);
            rlt.setMsg("root order id is empty");
            return rlt;
        }
        rootOrder.setUpdateTime(StringUtil.getFormatDate(new Date()));
        rootOrderService.editRootOrder(rootOrder);
        rlt.setCode(0);
        return rlt;
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam(name = "ids", required = false) String ids) {
        Result rlt = new Result();
        if (null == ids || "".equals(ids)) {
            rlt.setCode(-1);
            rlt.setMsg("root order ids is empty");
            return rlt;
        }
        rootOrderService.batchDelete(ids);
        rlt.setCode(0);
        return rlt;
    }

    public class Result {
        private int code;

        private String msg;

        private Long count;

        private List<RootOrderModel> Data;

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

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public List<RootOrderModel> getData() {
            return Data;
        }

        public void setData(List<RootOrderModel> data) {
            Data = data;
        }
    }
}
