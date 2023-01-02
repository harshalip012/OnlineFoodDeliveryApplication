package com.cg.ofda.dto;
import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Item_Table")
public class ItemDto {
	@Id
	@Column(name ="Item_Id", length = 5)
	String itemId;
	
	@Column(name = "Item_Name", length = 10)
	String itemName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cart_Id")
	CategoryDto category;
	
	@Column(name="quantity", length = 5)
	int quantity;
	
	@Column(name="cost", length = 5)
	double cost;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy= "item")
	@JsonIgnore
	List<RestaurantDto> restaurants = new ArrayList<RestaurantDto>();
	
		
		
		public ItemDto(String itemId, String itemName, CategoryDto category, int quantity, double cost,
				List<RestaurantDto> restuarants) {
			super();
			this.itemId = itemId;
			this.itemName = itemName;
			this.category = category;
			this.quantity = quantity;
			this.cost = cost;
			this.restaurants = restuarants;
			
		}
		
		
		public ItemDto(String itemId, String itemName, CategoryDto category, int quantity, double cost) {
			super();
			this.itemId = itemId;
			this.itemName = itemName;
			this.category = category;
			this.quantity = quantity;
			this.cost = cost;
		}


		public ItemDto() {
			super();
		}

		public String getItemId() {
			return itemId;
		}

		public List<RestaurantDto> getRestaurants() {
			return restaurants;
		}

		

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public CategoryDto getCategory() {
			return category;
		}

		public void setCategory(CategoryDto category) {
			this.category = category;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}


		public void setRestuarants(List<RestaurantDto> restuarants) {
			this.restaurants = restuarants;
		}

		@Override
		public String toString() {
			return "ItemDto [ItemId=" + itemId + ", ItemName=" + itemName + ", category=" + category + ", quantity="
					+ quantity + ", cost=" + cost + ", restaurants=" + restaurants
					+ "]";
		}

}
