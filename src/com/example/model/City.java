package com.example.model;

public class City {
	private int cityId;
	private String cityName;
	private String cityCode;
	private int Province;
	private int id;

		// TODO Auto-generated constructor stub
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
		public int getCityId(){
			return cityId;
		}
		public void setcityID(int cityId){
			this.cityId=cityId;
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
		public int getProvince(){
			return Province;
		}
		public void setProvince(int Province){
			this.Province=Province;
		}


}
