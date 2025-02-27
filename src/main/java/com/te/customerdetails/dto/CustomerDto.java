package com.te.customerdetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private int cusId;
	private String cusName;
	private long custMobile;
	private String gender;
	private int age;
}
