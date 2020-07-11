package com.food.app.domain.bean;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)

public class MenuItem {

 
    private String id;

    private String name;

    private String imagePath;

    private Double price;
    
    private String resid;
    private Integer preptime;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

	public String getResid() {
		return resid;
	}

	public void setResid(String resid) {
		this.resid = resid;
	}
	
	

	public Integer getPreptime() {
		return preptime;
	}

	public void setPreptime(Integer preptime) {
		this.preptime = preptime;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", imagePath=" + imagePath + ", price=" + price + ", resid="
				+ resid + ", preptime=" + preptime + "]";
	}

	

}
