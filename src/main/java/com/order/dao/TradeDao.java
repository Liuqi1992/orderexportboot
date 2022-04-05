package com.order.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017-06-19.
 */
public interface TradeDao {

    void updateTrade(Map<String, Object> map);

    List tradeList(Map<String, Object> map);

    long tradeListTotal(Map<String, Object> map);

    List jdoctorTradeList(Map map);
}
