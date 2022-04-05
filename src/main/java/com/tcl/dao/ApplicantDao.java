package com.tcl.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017-06-19.
 */
public interface ApplicantDao {

    public List list(Map<String,Object> map);

    public Long listTotal(Map<String,Object> map);

    public List tradeList(Map<String,Object> map);

    public List tradeListByDay(Map<String,Object> map);

    public List queryReport(Map<String,Object> map);

    public List tradeListByStatus(Map<String,Object> map);

    public List getMyUserDetail(Long applyId);
}
