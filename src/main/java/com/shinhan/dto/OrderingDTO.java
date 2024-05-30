package com.shinhan.dto;

import java.sql.Date;

public class OrderingDTO {
	int order_code;
	int menu_code;
	int member_code;
	int quantity;
	int price;
	Date order_date;
	String progress;
	String cancel_or;
	
	
	public OrderingDTO() {
	}
	
	public OrderingDTO(int order_code, int menu_code, int member_code, int quantity, int price, Date order_date,
			String progress, String cancel_or) {
		this.order_code = order_code;
		this.menu_code = menu_code;
		this.member_code = member_code;
		this.quantity = quantity;
		this.price = price;
		this.order_date = order_date;
		this.progress = progress;
		this.cancel_or = cancel_or;
	}
	
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}
	public int getMenu_code() {
		return menu_code;
	}
	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getCancel_or() {
		return cancel_or;
	}
	public void setCancel_or(String cancel_or) {
		this.cancel_or = cancel_or;
	}
	@Override
	public String toString() {
		return "[주문코드=" + order_code + ", 메뉴코드=" + menu_code + ", 멤버코드=" + member_code
				+ ", 수량=" + quantity + ", 가격=" + price + ", 주문일자=" + order_date + ", 조리여부="
				+ progress + ", 취소여부=" + cancel_or + "]";
	}
	
	
}
