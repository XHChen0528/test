package com.AIRetail.Controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.AIRetail.Entity.ShopStructureEntity;
import com.AIRetail.Model.*;
import com.AIRetail.Service.*;

@Controller
public class RetailController {
	@Autowired
	PassengersService passenser;
	@Autowired
	HeatmapService heatmap;
	/**
	 * ����ͻ�ͳ����Ϣҳ��
	 * @return
	 */
	@RequestMapping(value = "customers")
	public String CustomersStatistics() {
		return "customersstatistics";
	}
	
	@RequestMapping(value = "report")
	public String CustomerReport() {
		return "customerreport";
	}
	
	@RequestMapping(value = "getCustomerData")
	public @ResponseBody List<CustomerData> GetOutData(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerData> data = passenser.getCustomerData(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}
	
	@RequestMapping(value = "getInDatabyG")
	public @ResponseBody List<CustomerDataGender> GetInDataByGender(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerDataGender> data = passenser.getInDataByGender(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}

	@RequestMapping(value = "getInDatabyA")
	public @ResponseBody List<CustomerDataAge> GetInDataByAge(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerDataAge> data = passenser.getInDataByAge(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}
	@RequestMapping(value = "getOutDatabyG")
	public @ResponseBody List<CustomerDataGender> GetOutDataByGender(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerDataGender> data = passenser.getOutDataByGender(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}

	@RequestMapping(value = "getOutDatabyA")
	public @ResponseBody List<CustomerDataAge> GetOutDataByAge(@RequestParam("rankid") Integer rankid,
			@RequestParam("st") String st, @RequestParam("et") String et, @RequestParam("type") String type) {

		List<CustomerDataAge> data = passenser.getOutDataByAge(Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}

	/**
	 * ��������ͼҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "heatmap")
	public String Heatmap() {
//		// ��֤�û��������û���Ϣ�����ݿ��в�ѯ��صĵ�����Ϣ
//		ZoneModel info = new ZoneModel();
//		info.setName("�㽭ʡ");
//		info.setZoneID(32);
//		CityModel wocao = new CityModel();
//		wocao.setName("����");
//		wocao.setCityID(320);
//		ShopInfoModel shop1 = new ShopInfoModel();
//		shop1.setName("��Ȫ����");
//		shop1.setShopID(32001);
//		wocao.getShopes().add(shop1);
//		ShopInfoModel shop2 = new ShopInfoModel();
//		shop2.setName("��������");
//		shop2.setShopID(32002);
//		wocao.getShopes().add(shop2);
//		ShopInfoModel shop3 = new ShopInfoModel();
//		shop3.setName("�����Ļ��㳡��");
//		shop3.setShopID(32003);
//		wocao.getShopes().add(shop3);
//
//		CityModel wocao1 = new CityModel();
//		wocao1.setName("����");
//		wocao1.setCityID(321);
//		ShopInfoModel shop4 = new ShopInfoModel();
//		shop4.setName("�Ϻ�����");
//		shop4.setShopID(32101);
//		wocao1.getShopes().add(shop4);
//		ShopInfoModel shop5 = new ShopInfoModel();
//		shop5.setName("������");
//		shop5.setShopID(32102);
//		wocao1.getShopes().add(shop5);
//		ShopInfoModel shop6 = new ShopInfoModel();
//		shop6.setName("���Ƶ�");
//		shop6.setShopID(32103);
//		wocao1.getShopes().add(shop6);
//
//		info.getCities().add(wocao);
//		info.getCities().add(wocao1);
//
//		model.addAttribute("info", info);
		return "heatmap";
	}

	@RequestMapping(value = "getheatmapdata")
	@ResponseBody
	public HeatMapDataModel HeatMapData(@RequestParam("rankid") Integer rankid, @RequestParam("st") String st,
			@RequestParam("et") String et, @RequestParam("type") String type) {		
		HeatMapDataModel data = heatmap.getHmDataANDStruct(rankid, Timestamp.valueOf(st), Timestamp.valueOf(et), type);
		return data;
	}
}
