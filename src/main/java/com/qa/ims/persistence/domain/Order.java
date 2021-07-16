package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long customerid;
	private Long orderid;

	public Order(Long id, Long customerid) {

		this.setOrderid(orderid);
		this.setCustomerid(customerid);

	}

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerid, orderid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerid, other.customerid) && Objects.equals(orderid, other.orderid);
	}

	public static void add(Order modelFromResultSet) {

	}
}
