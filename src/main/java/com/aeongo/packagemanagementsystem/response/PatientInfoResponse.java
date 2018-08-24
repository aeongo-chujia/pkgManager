package com.aeongo.packagemanagementsystem.response;

import java.util.List;

import com.aeongo.packagemanagementsystem.response.DoctorInfoResponse.Info;
import com.aeongo.packagemanagementsystem.response.DoctorInfoResponse.Info.AdeptTag;

import lombok.Data;

@Data
public class PatientInfoResponse {

	
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
		private Integer user_id;
		private Integer gender;
		private String birthday;
		private List<String> pinyin;		
		private List<String> letter;
		private String info;
		private List<HealthTag> health_tags;
		private List<Integer> doctor_ids;
		private String pronvince;
		private String city;
		
		@Data
		public static class HealthTag{
			private String id;
			private String name;
		}
	}
	
}
