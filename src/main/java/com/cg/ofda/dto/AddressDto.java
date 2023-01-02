package com.cg.ofda.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Address_table")

public class AddressDto {
	
		@Id
		@Column(name="Address_Id")
		String addressid;
		@Column(name="Building_Name")
		String buildingName;
		@Column(name="Street_No")
		String streetNo;
		@Column(name="Area")
		String area;
		@Column(name="City")
		String city;
		@Column(name="State")
		String state;
		@Column(name="Country")
		String country;
		@Column(name="Pincode")
		String pincode;
		

		public AddressDto() {
			// TODO Auto-generated constructor stub
		}


		public AddressDto(String addressid, String buildingName, String streetNo, String area, String city, String state,
				String country, String pincode) {
			super();
			this.addressid = addressid;
			this.buildingName = buildingName;
			this.streetNo = streetNo;
			this.area = area;
			this.city = city;
			this.state = state;
			this.country = country;
			this.pincode = pincode;
		}


		public String getAddressid() {
			return addressid;
		}


		public void setAddressid(String addressid) {
			this.addressid = addressid;
		}


		public String getBuildingName() {
			return buildingName;
		}


		public void setBuildingName(String buildingName) {
			this.buildingName = buildingName;
		}


		public String getStreetNo() {
			return streetNo;
		}


		public void setStreetNo(String streetNo) {
			this.streetNo = streetNo;
		}


		public String getArea() {
			return area;
		}


		public void setArea(String area) {
			this.area = area;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public String getPincode() {
			return pincode;
		}


		public void setPincode(String pincode) {
			this.pincode = pincode;
		}


		@Override
		public String toString() {
			return "AddressDto [addressid=" + addressid + ", buildingName=" + buildingName + ", streetNo=" + streetNo
					+ ", area=" + area + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
					+ pincode + "]";
		}


		
}

