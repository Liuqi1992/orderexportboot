package com.order.service;

import com.order.dao.ApplicantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017-06-20.
 */
@Service
@Transactional
public class ApplicantService {
    @Autowired
    private ApplicantDao applicantDao;

    public List list(Map<String,Object> map){
       return applicantDao.list(map);
    }
    public Long listTotal(Map<String,Object> map){
        return applicantDao.listTotal(map);
    }

    public List tradeList(Map<String,Object> map){
        return applicantDao.tradeList(map);
    }

    public List tradeListByDay(Map<String,Object> map){
        return applicantDao.tradeListByDay(map);
    }

    public List queryReport(Map<String,Object> map){
        return applicantDao.queryReport(map);
    }

    public List queryTradeByStatus(Map<String,Object> map){
        return applicantDao.tradeListByStatus(map);
    }

    public List getMyUserDetail(Long applyId){
        return applicantDao.getMyUserDetail(applyId);
    }
}
