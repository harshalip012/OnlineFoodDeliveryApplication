package com.cg.ofda.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Category_Table")
public class CategoryDto {
	
	
		@Id
		@Column(name="Cartegory_Id",length = 5)
		String catId;
		@Column(name="Category_Name",length = 20)
		String categoryName;
		
		public CategoryDto() {
			super();
		}
		public CategoryDto(String catId, String categoryName) {
			super();
			this.catId = catId;
			this.categoryName = categoryName;
		}
		public String getCatId() {
			return catId;
		}
		public void setCatId(String catId) {
			this.catId = catId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		@Override
		public String toString() {
			return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
		}


}
