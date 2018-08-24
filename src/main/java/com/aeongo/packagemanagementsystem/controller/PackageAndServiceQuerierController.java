package com.aeongo.packagemanagementsystem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aeongo.packagemanagementsystem.response.GeneralResponse;
import com.aeongo.packagemanagementsystem.response.PackageResponse;
import com.aeongo.packagemanagementsystem.response.PackageSelectorResponse;
import com.aeongo.packagemanagementsystem.response.ServiceResponse;
import com.aeongo.packagemanagementsystem.service.EmrInformationService;
import com.aeongo.packagemanagementsystem.service.PackageAndServiceQuerierService;
import com.aeongo.packagemanagementsystem.service.ValidationService;

import io.swagger.annotations.ApiOperation;


@Controller
public class PackageAndServiceQuerierController {

	
	private PackageAndServiceQuerierService packageAndServiceQuerierService;
	
	private EmrInformationService emrInformationService;
	
	@Autowired
	public PackageAndServiceQuerierController(PackageAndServiceQuerierService packageAndServiceQuerierService,
			EmrInformationService emrInformationService) {
		this.packageAndServiceQuerierService = packageAndServiceQuerierService;
		this.emrInformationService = emrInformationService;
	}
	
	/** 
	* @Title: Service Querier
	* @Description: Return the services based on the serviceType to the front-end
	* @author Sun
	*/
	@ApiOperation(value = "Query Services",
			tags = {"Package And Service Querier"})
	@PostMapping("/getServices")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<List<ServiceResponse>> getServices(
			@RequestParam(name = "serviceType", required = true) String serviceType,
			@RequestParam(name = "access_token", required = true) String access_token) {
		
		GeneralResponse<List<ServiceResponse>> response = new GeneralResponse<>();
		response.setMsg("query success");
		response.setStatus(0);
		List<ServiceResponse> services = new ArrayList<>();
		return response;
	}
	
	
	/** 
	* @Title: Service Querier
	* @Description: Return the services based on the serviceType to the front-end
	* @author Sun
	*/
	@ApiOperation(value = "Query A Service Based On the",
			tags = {"Package And Service Querier"})
	@PostMapping("/getService")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<ServiceResponse> getService(
			@RequestParam(name = "serviceId", required = true) Integer serviceId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		return null;
	}
	
	
	
	
	
	
	/** 
	* @Title: Package Querier
	* @Description: Return the packages based on doctor
	* @author Sun
	*/
	@ApiOperation(value = "Query Packages Based On The Doctor",
			tags = {"Package And Service Querier"})
	@PostMapping("/getPackageByDoctor")
	@ResponseStatus(HttpStatus.OK)
	public  @ResponseBody GeneralResponse<List<PackageResponse>> getPackageByDoctor(
			@RequestParam(name = "patientId", required = true) Integer patientId,
			@RequestParam(name = "doctorId", required = true) Integer doctorId,
			@RequestParam(name = "includeSystemPackage", required = true) Boolean includeSystemPackage,
			@RequestParam(name = "offeredByDoctorOnly", required = true) Boolean offeredByDoctorOnly,
			@RequestParam(name = "access_token", required = true) String access_token) {

		//the response will be returned
		GeneralResponse<List<PackageResponse>> response = new GeneralResponse<List<PackageResponse>>();

		response.setMsg("success");
		response.setStatus(0);
		response.setData(this.packageAndServiceQuerierService.getPackageByDoctor(patientId, doctorId, access_token));
		
		
		
		
//		GeneralResponse<List<PackageResponse>> response = new GeneralResponse<List<PackageResponse>>();
//		response.setMsg("query success");
//		response.setStatus(0);
//		
//		List<PackageResponse> packages = new ArrayList<>();
//		
//		PackageResponse package1 = new PackageResponse();
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
//		PackageResponse.Plan plan11 = new PackageResponse.Plan();
//		plan11.setPlanId(30000001);
//		plan11.setTitle("早产儿服务管理A套餐");
//		plan11.setPicture("/pic/plan11");
//		plan11.setShortDescription("半年包， 咨询次数：5");
//		plan11.setFootnote("原价￥1227");
//		plan11.setPrice("￥198");
//		plan11.setAction("查看");
//		plan11.setActionIcon("/pic/rightarrow");
//		PackageResponse.Plan plan12 = new PackageResponse.Plan();
//		plan12.setPlanId(30000002);
//		plan12.setTitle("早产儿服务管理B套餐");
//		plan12.setPicture("/pic/plan12");
//		plan12.setShortDescription("年包， 咨询次数：10");
//		plan12.setFootnote("原价￥2499");
//		plan12.setPrice("￥388");
//		plan12.setAction("查看");
//		plan12.setActionIcon("/pic/rightarrow");
//		List<PackageResponse.Plan> plans1 = new ArrayList<>();
//		plans1.add(plan11);
//		plans1.add(plan12);
//		package1.setPlans(plans1);
//		
//		
//		PackageResponse package2 = new PackageResponse();
//		package2.setPackageId("pk10000002");
//		package2.setTitle("黄疸服务");
//		package2.setPicture("/pic/jaundice");
//		package2.setShortDescription("用户可记录宝宝黄疸情况，实时查看数据图表，系统会根据宝宝状况自动发送预警");
//		package2.setDescription("用户可记录宝宝黄疸情况，实时查看数据图表，系统会根据宝宝状况自动发送预警");
//		package2.setFootnote("适用范围：0-1岁");
//		package2.setAction("查看");
//		package2.setActionIcon("/pic/rightarrow");
//		package2.setPurchaseStatus("need to pay");
//		PackageResponse.Plan plan21 = new PackageResponse.Plan();
//		PackageResponse.Plan plan22 = new PackageResponse.Plan();
//		List<PackageResponse.Plan> plans2 = new ArrayList<>();
//		
//		plan21.setPlanId(30000003);
//		plan21.setTitle("黄疸服务A套餐");
//		plan21.setPicture("/pic/plan23");
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
//		response.setData(packages);
		
		return response;
	}
	
	
	/** 
	* @Title: Package Querier
	* @Description: Return the packages based on the service
	* @author Sun
	*/
	@ApiOperation(value = "Query Packages Based On The Service",
			tags = {"Package And Service Querier"})
	@PostMapping("/getPackageByService")
	@ResponseStatus(HttpStatus.OK)
	public GeneralResponse<List<PackageResponse>> getPackageByService(
			@RequestParam(name = "serviceId", required = true) Integer serviceId,
			@RequestParam(name = "access_token", required = true) String access_token) {
		return null;
	}
	
}
