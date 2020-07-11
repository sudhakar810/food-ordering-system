package com.food.app.domain.bean;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Restaurant {

    private String resid;

    private String name;

    private String address;

    private String regNumber;
    
    //private List<Menu> menus;


	public String getName() {
		return name;
	}

	public String getResid() {
		return resid;
	}

	public void setResid(String resid) {
		this.resid = resid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	@Override
	public String toString() {
		return "Restaurant [resid=" + resid + ", name=" + name + ", address=" + address + ", regNumber=" + regNumber
				+ "]";
	}
	
}
