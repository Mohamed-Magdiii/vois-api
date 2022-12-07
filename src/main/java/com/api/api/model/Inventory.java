package com.api.api.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "inventory")
public class Inventory {
	@Id
	private String id;

	private int temprature = 1;

	private String status = "READY";

	private String pinCode;

	private Date createdAt;

	private Date updatedAt;

}
