package com.order.controller;

import java.util.HashMap;
import java.util.Map;

/**
 *    
 * @className: BaseController     
 * @author: liuqi
 * @date: 2022/5/20  
 */ 
public class BaseController {

    static Map<String, Object> CommonPageDeal(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }
        map.put("startNum", (page - 1) * 10);
        map.put("limit", limit);
        return map;
    }
}
