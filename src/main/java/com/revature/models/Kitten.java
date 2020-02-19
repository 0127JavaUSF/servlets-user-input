package com.revature.models;

public class Kitten {
	private int id;
	private String name;
	private String furColor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((furColor == null) ? 0 : furColor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kitten other = (Kitten) obj;
		if (furColor == null) {
			if (other.furColor != null)
				return false;
		} else if (!furColor.equals(other.furColor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kitten [id=" + id + ", name=" + name + ", furColor=" + furColor + "]";
	}

	public Kitten(String name, String furColor) {
		super();
		this.name = name;
		this.furColor = furColor;
	}

	public Kitten() {
		super();
	}

}
