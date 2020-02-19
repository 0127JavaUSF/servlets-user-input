package com.revature.models;

public class Food {
	private int id;
	private String name;
	private String foodGroup;
	private int calories;

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

	public String getFoodGroup() {
		return foodGroup;
	}

	public void setFoodGroup(String foodGroup) {
		this.foodGroup = foodGroup;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + ((foodGroup == null) ? 0 : foodGroup.hashCode());
		result = prime * result + id;
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
		Food other = (Food) obj;
		if (calories != other.calories)
			return false;
		if (foodGroup == null) {
			if (other.foodGroup != null)
				return false;
		} else if (!foodGroup.equals(other.foodGroup))
			return false;
		if (id != other.id)
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
		return "Food [id=" + id + ", name=" + name + ", foodGroup=" + foodGroup + ", calories=" + calories + "]";
	}

	public Food(int id, String name, String foodGroup, int calories) {
		super();
		this.id = id;
		this.name = name;
		this.foodGroup = foodGroup;
		this.calories = calories;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

}
