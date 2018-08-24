package com.aeongo.packagemanagementsystem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aeongo.packagemanagementsystem.entity.Service;
import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.response.ServiceResponse;
import com.aeongo.packagemanagementsystem.response.ServiceSelectorResponse;
import com.aeongo.packagemanagementsystem.service.PackageAndServiceSelectorService;
import com.aeongo.packagemanagementsystem.service.ValidationService;

import io.swagger.annotations.ApiOperation;

@RestController
public class PackageAndServiceSelectorController {

	
	@Autowired
	private PackageAndServiceSelectorService serviceAndPackageSelectorService;
	
	@Autowired
	public PackageAndServiceSelectorController(PackageAndServiceSelectorService serviceAndPackageSelectorService) {
		this.serviceAndPackageSelectorService = serviceAndPackageSelectorService;
	}


	
	/** 
	* @Title: Physical Health Service Selector
	* @Description: Select physical health service based on the patientId
	* @author Sun
	*/
	@ApiOperation(value = "Select physical health service",
			tags = {"Package And Service Selector"})
	@PostMapping("/physicalHealthServiceSelector")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<ServiceSelectorResponse> physicalHealthServiceSelector(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		GeneralResponse<ServiceSelectorResponse> response = new GeneralResponse<>();
		response.setMsg("query success");
		response.setStatus(0);
		List<ServiceSelectorResponse.Service> services = new ArrayList<>();
		ServiceSelectorResponse.Service service1 = new ServiceSelectorResponse.Service();
		service1.setServiceId(100000001);
		service1.setTitle("diaper");
		service1.setPicture("/pic/diaper");
		ServiceSelectorResponse.Service service2 = new ServiceSelectorResponse.Service();
		service2.setServiceId(100000002);
		service2.setTitle("feeding");
		service2.setPicture("/pic/feeding");
		ServiceSelectorResponse.Service service3 = new ServiceSelectorResponse.Service();
		service3.setServiceId(100000003);
		service3.setTitle("growth");
		service3.setPicture("/pic/growth");
		services.add(service1);
		services.add(service2);
		services.add(service3);
		ServiceSelectorResponse raw = new ServiceSelectorResponse(services, new Date());
		response.setData(raw);
		return response;
	}
	
	
	
	/** 
	* @Title: Mental Health Service Selector
	* @Description: Select mental health services based on the patientId
	* @author Sun
	*/
	@ApiOperation(value = "Select mental health service",
			tags = {"Package And Service Selector"})
	@PostMapping("/mentalHealthServiceSelector")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<ServiceSelectorResponse> mentalHealthServiceSelector(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		return null;
	}
	
	
	
	
	/** 
	* @Title: Health History Selector
	* @Description: Select health history services based on the patientId
	* @author Sun
	*/
	@ApiOperation(value = "Select mental health service",
			tags = {"Package And Service Selector"})
	@PostMapping("/healthHistorySelector")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<ServiceSelectorResponse> healthHistorySelector(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		//return serviceAndPackageSelectorService.mentalHealthServiceSelectorService(patientId);
		
		GeneralResponse<ServiceSelectorResponse> response = new GeneralResponse<>();
		response.setMsg("query success");
		response.setStatus(0);
		List<ServiceSelectorResponse.Service> services = new ArrayList<>();
		ServiceSelectorResponse.Service service1 = new ServiceSelectorResponse.Service();
		service1.setServiceId(100000004);
		service1.setTitle("Doctor visiting history");
		service1.setPicture("/pic/visitinghistory");
		service1.setShortDescription("You can upload your doctor visiting history");
		ServiceSelectorResponse.Service service2 = new ServiceSelectorResponse.Service();
		service2.setServiceId(100000005);
		service2.setTitle("Birth history");
		service2.setPicture("/pic/birthhistory");
		service2.setShortDescription("You can add or modify your birth history");
		ServiceSelectorResponse.Service service3 = new ServiceSelectorResponse.Service();
		service3.setServiceId(100000006);
		service3.setTitle("Health requirement");
		service3.setPicture("/pic/healthrequirement");
		service3.setShortDescription("Please tell us your health requirement");
		services.add(service1);
		services.add(service2);
		services.add(service3);
		ServiceSelectorResponse raw = new ServiceSelectorResponse(services, new Date());
		response.setData(raw);
		return response;
	}
	
	
	
	
	
	/** 
	* @Title: Package Selector
	* @Description: Select packages based on patientId
	* @author Sun
	*/
	@ApiOperation(value = "Select package",
			tags = {"Package And Service Selector"})
	@PostMapping("/packageSelector")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<PackageSelectorResponse> packageSelector(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		
		//the response will be returned
		GeneralResponse<PackageSelectorResponse> response = new GeneralResponse<PackageSelectorResponse>();
		
		response.setMsg("query success");
		response.setStatus(0);
		response.setData(serviceAndPackageSelectorService.packageSelectorService(patientId,access_token));


//		GeneralResponse<PackageSelectorResponse> response = new GeneralResponse<PackageSelectorResponse>();
//		response.setMsg("query success");
//		response.setStatus(0);
//		
//		List<PackageSelectorResponse.Package> packages = new ArrayList<>();
//		PackageSelectorResponse.Package package1 = new PackageSelectorResponse.Package();
//		package1.setPackageId("pk10000001");
//		package1.setTitle("早产儿管理服务");
//		package1.setPicture("/pic/pretermservice");
//		package1.setShortDescription("用户可记录宝宝数据，实时查看数据图表，系统会根据宝宝状况自动发送预警");
//		package1.setDescription("• 早产儿宝宝的随访管理神器\r\n" + 
//				"• 身长、体重、头围三大指标线性检测，宫内生长曲线、9城市生长曲线，who曲线共同辅助监测\r\n" + 
//				"• 日常喂养以及行为数据联系记录\r\n" + 
//				"• 早产儿科普知识、常用量表全面覆盖。帮助宝宝健康生长\r\n" + 
//				"• 适用范围：0~2岁早产儿");
//		package1.setFootnote("适用范围：0-2岁");
//		package1.setAction("查看");
//		package1.setActionIcon("/pic/rightarrow");
//		package1.setPurchaseStatus("paid");
//		PackageSelectorResponse.Plan plan11 = new PackageSelectorResponse.Plan();
//		plan11.setPlanId(30000001);
//		plan11.setTitle("早产儿服务管理A套餐");
//		plan11.setPicture("/pic/plan11");
//		plan11.setShortDescription("半年包， 咨询次数：5");
//		plan11.setFootnote("原价￥1227");
//		plan11.setPrice("￥198");
//		plan11.setAction("查看");
//		plan11.setActionIcon("/pic/rightarrow");
//		PackageSelectorResponse.Plan plan12 = new PackageSelectorResponse.Plan();
//		plan12.setPlanId(30000002);
//		plan12.setTitle("早产儿服务管理B套餐");
//		plan12.setPicture("/pic/plan12");
//		plan12.setShortDescription("年包， 咨询次数：10");
//		plan12.setFootnote("原价￥2499");
//		plan12.setPrice("￥388");
//		plan12.setAction("查看");
//		plan12.setActionIcon("/pic/rightarrow");
//		List<PackageSelectorResponse.Plan> plans1 = new ArrayList<>();
//		plans1.add(plan11);
//		plans1.add(plan12);
//		package1.setPlans(plans1);
//		
//		
//		PackageSelectorResponse.Package package2 = new PackageSelectorResponse.Package();
//		package2.setPackageId("pk10000002");
//		package2.setTitle("黄疸服务");
//		package2.setPicture("/pic/jaundice");
//		package2.setShortDescription("用户可记录宝宝黄疸情况，实时查看数据图表，系统会根据宝宝状况自动发送预警");
//		package2.setDescription("用户可记录宝宝黄疸情况，实时查看数据图表，系统会根据宝宝状况自动发送预警");
//		package2.setFootnote("适用范围：0-1岁");
//		package2.setAction("查看");
//		package2.setActionIcon("/pic/rightarrow");
//		package2.setPurchaseStatus("need to pay");
//		PackageSelectorResponse.Plan plan21 = new PackageSelectorResponse.Plan();
//		PackageSelectorResponse.Plan plan22 = new PackageSelectorResponse.Plan();
//		List<PackageSelectorResponse.Plan> plans2 = new ArrayList<>();
//		
//		plan21.setPlanId(30000003);
//		plan21.setTitle("黄疸服务A套餐");
//		plan21.setPicture("/pic/plan21");
//		plan21.setShortDescription("半年包， 咨询次数：5");
//		plan21.setFootnote("原价￥1227");
//		plan21.setPrice("￥198");
//		plan21.setAction("查看");
//		plan21.setActionIcon("/pic/rightarrow");
//		plan22.setPlanId(30000004);
//		plan22.setTitle("黄疸服务B套餐");
//		plan22.setPicture("/pic/plan12");
//		plan22.setShortDescription("年包， 咨询次数：10");
//		plan22.setFootnote("原价￥2499");
//		plan22.setPrice("￥388");
//		plan22.setAction("查看");
//		plan22.setActionIcon("/pic/rightarrow");
//		plans2.add(plan21);
//		plans2.add(plan22);
//		package2.setPlans(plans2);
//		
//		packages.add(package1);
//		packages.add(package2);
//		PackageSelectorResponse raw = new PackageSelectorResponse(packages, new Date());
//		response.setData(raw);
//		
//		return response;
		return response;
	}
	
}
