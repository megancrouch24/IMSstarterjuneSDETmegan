package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long id;
	private String Name;
	private Double Value;

	public Item(Long id, String Name, Double Value) {
		this.setId(id);
		this.setName(Name);
		this.setValue(Value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Name, Value, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(Name, other.Name) && Objects.equals(Value, other.Value) && Objects.equals(id, other.id);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getValue() {
		return Value;
	}

	public void setValue(Double value) {
		Value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", Name=" + Name + ", Value=" + Value + "]";
	}

}
