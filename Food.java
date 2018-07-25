
public class Food {
	private int foodId;
	private String name;
	private int calorie;
	
	
	public Food(int foodId, String name, int calorie) {
		this.foodId = foodId;
		this.name = name;
		this.calorie = calorie;
	}
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	
	

}
