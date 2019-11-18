package com.example.model;

public class County {

	private int cityId;
	private String countyName;
	private String countyCode;
	private int id;

		// TODO Auto-generated constructor stub
		public int getCityId(){
			return cityId;
		}
		public void setCityId(int cityId){
			this.cityId=cityId;
		}
		public String getCountyName(){
			return countyName;
		}
		public void setCountyName(String countyName){
			this.countyName=countyName;
		}
		public String getCountyCode(){
			return countyCode;
		}
		public  void setCountyCode(String countyCode){
			this.countyCode=countyCode;
		}
		public int getId(){
			return id;
		}
		public void setId(int id){
			this.id=id;
		}

}
