package com.order.controller;

import com.order.pojo.*;
import com.order.repository.*;
import com.order.vo.ApplicantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@EnableAutoConfiguration
public class TradeController {
	@Autowired
	private TradeRepository tradeRepository;
	private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

//	private final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	private final long SERVICE_FEE = 5000L;

	//根据订单号查询 订单详情 web
	@RequestMapping(value = "/trade/getTradeByTradeNumWeb", method = RequestMethod.GET)
	public String getTradeByTradeNumWeb(ModelMap map,@RequestParam(required = false) String tradeNum,@RequestParam(required = false) String status){
		Result rlt=new Result();
		AppCTradeEntity trade=tradeRepository.getTradeByTradeNum(tradeNum,status);
		map.put("rlt", rlt);
		return "tradequery";
	}

	public class Result {
		private int rlt;
		private String txt;
		private AppCTradeEntity tradeEntity;
		private AppCApplicantEntity applicant;
		private List<AppCTradeEntity> tradeList;
		private List<AppCApplicantEntity> list;
		private List<ApplicantVo> applicantVoList;
		private List lists;


		public List getLists() {
			return lists;
		}

		public void setLists(List lists) {
			this.lists = lists;
		}

		public List<ApplicantVo> getApplicantVoList() {
			return applicantVoList;
		}

		public void setApplicantVoList(List<ApplicantVo> applicantVoList) {
			this.applicantVoList = applicantVoList;
		}

		public List<AppCApplicantEntity> getList() {
			return list;
		}

		public void setList(List<AppCApplicantEntity> list) {
			this.list = list;
		}

		public int getRlt() {
			return rlt;
		}

		public AppCApplicantEntity getApplicant() {
			return applicant;
		}

		public void setApplicant(AppCApplicantEntity applicant) {
			this.applicant = applicant;
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

		public AppCTradeEntity getTradeEntity() {
			return tradeEntity;
		}

		public void setTradeEntity(AppCTradeEntity tradeEntity) {
			this.tradeEntity = tradeEntity;
		}

		public List<AppCTradeEntity> getTradeList() {
			return tradeList;
		}

		public void setTradeList(List<AppCTradeEntity> tradeList) {
			this.tradeList = tradeList;
		}
	}
}
