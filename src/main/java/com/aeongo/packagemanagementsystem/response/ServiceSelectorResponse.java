package com.aeongo.packagemanagementsystem.response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ServiceSelectorResponse {
	
	
	private List<Service> services;
	private Date expirationDate;
	
	public ServiceSelectorResponse() {
		services = new ArrayList<>();
		expirationDate = null;
	}
	public ServiceSelectorResponse(List<Service> services, Date expirationDate) {
		super();
		this.services = services;
		this.expirationDate = expirationDate;
	}
	public void addService(Integer serviceId,String title,String description, String shotDescription, String picture, String serviceType, String serviceDisplayPriority, List<Integer> pId, List<String> pName) {
		Service newOne = new Service(serviceId, title, description, shotDescription, picture, serviceType, serviceDisplayPriority, new ArrayList<>());
		newOne.addPrivileges(pId, pName);
		this.services.add(newOne);
	}
	@Data
	@AllArgsConstructor
	private static class Service{
		private Integer serviceId;
		private String title;//name
		private String description;
//		private String subtitle;
		private String shortDescription;
		private String picture;
//		private String footnote;
//		private String action;
//		private String actionIcon;
//		private String statusIcon;
//		private String bgColor;
//		private String fgColor;
//		private String tileSize;
		private String serviceType;
		private String serviceDisplayPriority;
		private List<Privilege> privileges = new ArrayList<>();
		public void addPrivileges(List<Integer> pId,List<String>pName) {
			for (int i = 0;i<pId.size()&&i<pName.size();i++) {
				Privilege newOne = new Privilege(pId.get(i),pName.get(i));
				privileges.add(newOne);
			}
		}
		@Data
		@AllArgsConstructor
		private static class Privilege{
			private Integer privilegeId;
			private String privilegeName;
		}
//		private String purchaseStatus;
//		private Date serviceExpirationDate;
//		private Integer serviceCount;
	}

}
