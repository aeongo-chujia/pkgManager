package com.aeongo.packagemanagementsystem.response;

import java.util.List;

import lombok.Data;

@Data
public class DoctorInfoResponse {

	private String msg;
	private Integer status;
	private Info data;
	
	@Data
	public static class Info{
		private Integer id;
		private String type;
		private String fullname;
		private String avatar;
		private String is_locked_out;
		private String lockout_util_date;
		private String modified_date;
		private String department;
		private String referral_code;
		private Integer gender;
		private String title;
		private String hospital;
		private String barcode;
		private String intro;
		private String pronvince;
		private String city;
		private String medical_practitioner_number;
		private String remark;
		private List<AdeptTag> adept_tags;
		
		@Data
		public static class AdeptTag{
			private String id;
			private String name;
		}
	}
 
	
	
}
