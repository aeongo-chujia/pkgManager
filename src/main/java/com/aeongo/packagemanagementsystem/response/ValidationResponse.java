package com.aeongo.packagemanagementsystem.response;

import java.util.List;

import com.aeongo.packagemanagementsystem.response.DoctorInfoResponse.Info;
import com.aeongo.packagemanagementsystem.response.DoctorInfoResponse.Info.AdeptTag;

import lombok.Data;


@Data
public class ValidationResponse {

	
	private String msg;
	private Integer status;
//	private Info data;
//	
//	@Data
//	public static class Info{
//
//		private String access_token;
//		private String expires_in;
//		private Integer actor_id;
//		private String actor_type;
//		private String clinet_id;
//		private String refresh_token;
//
//	}
	
}
