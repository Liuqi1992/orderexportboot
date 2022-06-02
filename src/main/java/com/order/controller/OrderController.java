package com.order.controller;

import com.order.model.OrderInfoModel;
import com.order.model.ProductInfoModel;
import com.order.model.RootOrderModel;
import com.order.pojo.OrderInfoEntity;
import com.order.pojo.ProductInfoEntity;
import com.order.service.OrderService;
import com.order.service.ProductService;
import com.order.service.RootOrderService;
import com.order.utils.Constants;
import com.order.utils.StringUtil;
import javafx.scene.transform.Rotate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@EnableAutoConfiguration
@EnableConfigurationProperties
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RootOrderService rootOrderService;

    @RequestMapping(value = "/listPage", method=RequestMethod.GET)
    public String systemPage(ModelMap map, @RequestParam(name = "rootOrderId") String rootOrderId) {
        map.put("rootOrderId", rootOrderId);
        RootOrderModel rootOrder = rootOrderService.findById(rootOrderId);
        map.put("rootOrder", rootOrder);
        return "/vm/order/page";
    }

	@RequestMapping(value = "/list", method=RequestMethod.GET)
    @ResponseBody
	public Result list(@RequestParam(name = "page") Integer page,
                       @RequestParam(name = "limit") Integer limit,
                       @RequestParam(name = "rootOrderId") String rootOrderId) {
        Result rlt = new Result();
        if (null == rootOrderId || rootOrderId.equals("")) {
            rlt.setCode(-1);
            rlt.setMsg("rootOrderId is empty");
            return rlt;
        }
        Map<String, Object> map = CommonPageDeal(page, limit);
        map.put("rootOrderId", rootOrderId);
        List<OrderInfoModel> orderInfoModels = orderService.listPage(map);
        Long count = orderService.countNum(map);
        rlt.setCode(0);
        rlt.setCount(count);
        rlt.setData(orderInfoModels);
	    return rlt;
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    @ResponseBody
    public Result add(OrderInfoEntity orderInfo) {
        Result rlt = new Result();
        orderInfo.setId(UUID.randomUUID().toString());
        orderInfo.setCreateTime(StringUtil.getFormatDate(new Date()));
        orderInfo.setUpdateTime(StringUtil.getFormatDate(new Date()));
        orderInfo.setDeleted(Constants.DELETE_FLAG_F);
        orderService.AddOrder(orderInfo);
        rlt.setCode(0);
        return rlt;
    }

    @RequestMapping(value = "/edit", method=RequestMethod.PUT)
    @ResponseBody
    public Result edit(OrderInfoEntity orderInfo) {
        Result rlt = new Result();
        if (orderInfo.getId() == null || orderInfo.getId().equals("")) {
            rlt.setCode(-1);
            rlt.setMsg("order id is empty");
            return rlt;
        }
        orderInfo.setUpdateTime(StringUtil.getFormatDate(new Date()));
        orderService.editOrder(orderInfo);
        rlt.setCode(0);
        return rlt;
    }

    @RequestMapping(value = "/delete", method=RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam(name = "ids", required = false) String ids) {
        Result rlt = new Result();
        if (null == ids || "".equals(ids)) {
            rlt.setCode(-1);
            rlt.setMsg("ids is empty.");
            return rlt;
        }
        orderService.batchDelete(ids);
        rlt.setCode(0);
        return rlt;
    }

    public class Result {
        private int code;

        private String msg;

        private Long count;

        private List<OrderInfoModel> Data;

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

        public List<OrderInfoModel> getData() {
            return Data;
        }

        public void setData(List<OrderInfoModel> data) {
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
