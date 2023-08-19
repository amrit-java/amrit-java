
package com.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	//private String name;
	//private String email;
	private String city;
	private String product;

}
