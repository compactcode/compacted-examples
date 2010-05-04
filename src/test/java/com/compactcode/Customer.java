package com.compactcode;

import com.google.common.base.Function;
import com.google.common.base.Objects;

public class Customer {
	
	public static final Function<Customer, Integer> toAge() {
		return Functions.toPropertyValue("age");
	};
	
	private Integer age;
	
	public Customer(Integer age) {
		this.age = age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public boolean equals(Object that) {
		return Objects.equal(this.age, ((Customer)that).age);
	}
	
}