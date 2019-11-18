package com.example.model;

public class City {
	private String cityName;
	private String cityCode;
	private int ProvinceId;
	private int id;

		// TODO Auto-generated constructor stub
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
		public String cityName(){
			return cityName;
		}
		public void setCityName(String cityName){
			this.cityName=cityName;
		}
		public String getCityCode(){
			return cityCode;
		}
		public  void setCityCode(String cityCode){
			this.cityCode=cityCode;
		}
		public int getProvinceId(){
			return ProvinceId;
		}
		public void setProvinceId(int ProvinceId){
			this.ProvinceId=ProvinceId;
		}


}
