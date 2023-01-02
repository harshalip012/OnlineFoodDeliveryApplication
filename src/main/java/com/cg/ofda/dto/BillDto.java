package com.cg.ofda.dto;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Bill_Table")
public class BillDto {
	@Id
	@Column(name="Bill_Id", length = 10)
	String billId;
	
	@Column(name="Bill_Date", length = 10)
	LocalDate billDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_Id")
	OrderDetailsDto order;
	
	@Column(name="Total_Items")
	int totalItems;
	
	@Column(name="TotalCost", length = 8)
	double totalCost;
		
		
		public BillDto(String billid, LocalDate billDate, OrderDetailsDto order, int totalitem, double totalcost) {
			super();
			this.billId = billid;
			this.billDate = billDate;
			this.order = order;
			this.totalItems = totalitem;
			this.totalCost = totalcost;
		}


		public BillDto() {
			super();
		}
		

		public String getBillid() {
			return billId;
		}


		public void setBillid(String billid) {
			this.billId = billid;
		}


		public LocalDate getBillDate() {
			return billDate;
		}


		public void setBillDate(LocalDate billDate) {
			this.billDate = billDate;
		}


		public int getTotalitem() {
			return totalItems;
		}


		public void setTotalitem(int totalitem) {
			this.totalItems = totalitem;
		}


		public double getTotalcost() {
			return totalCost;
		}


		public void setTotalcost(double totalcost) {
			this.totalCost = totalcost;
		}

		public OrderDetailsDto getOrder() {
			return order;
		}

		public void setOrder(OrderDetailsDto order) {
			this.order = order;
		}


		@Override
		public String toString() {
			return "BillDto [billid=" + billId + ", billDate=" + billDate + ", order=" + order + ", totalitem="
					+ totalItems + ", totalcost=" + totalCost + "]";
		}


		
		


}

