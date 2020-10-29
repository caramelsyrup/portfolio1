package com.myboard.dto;

import lombok.Setter;

@Setter
public class AddressDTO {
	private String zipcode,sido,gugun,dong,bunji;
	private int seq;
	public String getZipcode() {
		return zipcode;
	}
	public String getSido() {
		return sido;
	}
	public String getGugun() {
		return gugun;
	}
	public String getDong() {
		return dong;
	}
	public String getBunji() {
		return bunji == null? "" : bunji;
	}
	public int getSeq() {
		return seq;
	}

	
}
