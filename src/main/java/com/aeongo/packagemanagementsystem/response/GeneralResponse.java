package com.aeongo.packagemanagementsystem.response;

import lombok.Data;

@Data
public class  GeneralResponse<T>  {

	private Integer status;
	private String msg;
	private T data;
	
	public GeneralResponse(Integer status,String msg,T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public GeneralResponse() {
	}
}
