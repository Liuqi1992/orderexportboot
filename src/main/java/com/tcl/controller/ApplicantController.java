package com.tcl.controller;

import com.tcl.pojo.AppCApplicantEntity;
import com.tcl.pojo.AppCTradeEntity;
import com.tcl.repository.ApplicantRepository;
import com.tcl.repository.TradeRepository;
import com.tcl.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by wang on 2017-06-14.
 * 用户联系人
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/applicant")
public class ApplicantController {
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private TradeRepository tradeRepository;

    @RequestMapping(value="/getApplicantByTradeId")
    @ResponseBody
    public Result getApplicantByTradeId(HttpServletRequest request,@RequestParam Long tradeId){
        Result rlt=new Result();
        AppCTradeEntity trade=tradeRepository.findOne(tradeId);
        if(trade==null){
            rlt.setRlt(-1);
            rlt.setTxt("订单不存在");
            return rlt;
        }
        AppCApplicantEntity applicant=applicantRepository.findOne(trade.getApplicantId());
        rlt.setApplicantEntity(applicant);
        rlt.setTrade(trade);
        rlt.setRlt(200);
        return rlt;
    }


    @RequestMapping(value="/updateApplicnat")
    @ResponseBody
    public Result saveApplicnat(HttpServletRequest request,@RequestParam Long id,@RequestParam String phone,@RequestParam String address,@RequestParam int age,@RequestParam String sex){
        Result rlt=new Result();
        AppCApplicantEntity applicantd=applicantRepository.findOne(id);
        if(applicantd==null){
            rlt.setRlt(-1);
            rlt.setTxt("此用户不存在");
        }else {
            applicantd.setAddress(address);
            applicantd.setPhone(phone);
            applicantd.setAge(age);
            applicantd.setSex(sex);
            applicantd.setModifyTime(new Date());
            applicantRepository.save(applicantd);
            rlt.setRlt(200);
            rlt.setTxt("修改联系人成功");
        }

        return rlt;
    }
    public class Result {
        private int rlt;
        private String txt;
        private List<AppCApplicantEntity> list;
        private AppCApplicantEntity applicantEntity;
        private AppCTradeEntity trade;

        public AppCTradeEntity getTrade() {
            return trade;
        }

        public void setTrade(AppCTradeEntity trade) {
            this.trade = trade;
        }

        public int getRlt() {
            return rlt;
        }

        public void setRlt(int rlt) {
            this.rlt = rlt;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public List<AppCApplicantEntity> getList() {
            return list;
        }

        public void setList(List<AppCApplicantEntity> list) {
            this.list = list;
        }

        public AppCApplicantEntity getApplicantEntity() {
            return applicantEntity;
        }

        public void setApplicantEntity(AppCApplicantEntity applicantEntity) {
            this.applicantEntity = applicantEntity;
        }
    }
}
