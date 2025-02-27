package com.te.customerdetails.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class ResponseDto {

	private boolean error;
	private String message;
	private Object Data;
}
