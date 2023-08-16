package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImagData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private String type;
	//@lob:-cinvert file to bytearrayand store in db.
	@Lob
	@Column(name="ImageData",length = 1000)
	private byte[] imageData;
	
	
	

}
