package com.cg.ofda.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Restaurant_Table")
public class RestaurantDto {
		@Id
		@Column(name="Restaurant_Id" ,length =5)
		String restaurantId;
	
		
		@Column(name = "Restaurant_name", length = 20)
		String restaurantName;
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name = "Address_id")
		AddressDto address;
		
		@ManyToMany(cascade=CascadeType.ALL)
		@JoinTable(name = "restaurant_items", joinColumns = { @JoinColumn(name = "restaurant_id") }, inverseJoinColumns = { @JoinColumn(name = "item_id") })
		List<ItemDto> item = new ArrayList<ItemDto>();

		@Column(name="Manager_Name")
		String managerName;
		
		@Column(name="Contact_Number")
		String contactNumber;
		

		public RestaurantDto() {
			super();
		}
		
		public RestaurantDto(String restaurantId, String restaurantName, AddressDto address, List<ItemDto> item,
				String managerName, String contactNumber) {
			super();
			this.restaurantId = restaurantId;
			this.restaurantName = restaurantName;
			this.address = address;
			this.item = item;
			this.managerName = managerName;
			this.contactNumber = contactNumber;
		}
		
		public RestaurantDto(String restaurantId, String restaurantName, AddressDto address, String managerName,
				String contactNumber) {
			super();
			this.restaurantId = restaurantId;
			this.restaurantName = restaurantName;
			this.address = address;
			this.managerName = managerName;
			this.contactNumber = contactNumber;
		}

		public String getRestaurantId() {
			return restaurantId;
		}
		public void setRestaurantId(String restaurantId) {
			this.restaurantId = restaurantId;
		}
		public String getRestaurantName() {
			return restaurantName;
		}
		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}
		public AddressDto getAddress() {
			return address;
		}
		public void setAddress(AddressDto address) {
			this.address = address;
		}
		public List<ItemDto> getItem() {
			return item;
		}
		public void setItem(List<ItemDto> item) {
			this.item = item;
		}
		public String getManagerName() {
			return managerName;
		}
		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		@Override
		public String toString() {
			return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
					+ address + ", Item=" + item + ", managerName=" + managerName + ", contactNumber=" + contactNumber
					+ "]";
		}


}
