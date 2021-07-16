package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {

	private Long id;
	private Long orderid;
	private Double itemsid;

	public OrderItems(Long id, Long orderid, Double itemsid) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.itemsid = itemsid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Double getItemsid() {
		return itemsid;
	}

public void setItemsid(Double itemsid) {
	this.itemsid = itemsid; }

	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", orderid=" + orderid + ", itemsid=" + itemsid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemsid, orderid);
	}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	OrderItems other = (OrderItems) obj;
	return Objects.equals(id, other.id) && Objects.equals(itemsid, other.itemsid)
			&& Objects.equals(orderid, other.orderid);
}

public static void add(OrderItems modelFromResultSet) {
	// TODO Auto-generated method stub
	
}}