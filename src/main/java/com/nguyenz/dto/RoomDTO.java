package com.nguyenz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDTO {
	private int id;
	private String name;
	private double area;
	private String address;
	private int price;
	private String image;
	private String description;
	private String postDate;
	private String updateDate;
	private int categoryId;
}
