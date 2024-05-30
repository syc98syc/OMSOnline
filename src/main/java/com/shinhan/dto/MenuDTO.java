package com.shinhan.dto;

public class MenuDTO {
	int menu_code;
	String name;
	String category;
	int price;
	
	public MenuDTO(int menu_code, String name, String category, int price) {
		this.menu_code = menu_code;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public MenuDTO() {
	}
	
	public int getMenu_code() {
		return menu_code;
	}
	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "[메뉴코드=" + menu_code + ", 메뉴이름=" + name + ", 분류=" + category + ", 가격=" + price + "]";
	}
}
