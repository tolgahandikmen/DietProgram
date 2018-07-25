
public class Person {
	private int personId;
	private String name;
	private String male;
	private int weight;
	private int height;
	private int yearOfBirth;
	private float dailyCalorie;
	private float takenCalorie;
	private float burnedCalorie;
	
	
	public Person(int personId, String name, String male, int weight, int height, int yearOfBirth) {
		this.personId = personId;
		this.name = name;
		this.male = male;
		this.weight = weight;
		this.height = height;
		this.yearOfBirth = yearOfBirth;
		this.takenCalorie = 0;
		this.burnedCalorie = 0;
		calculateDailyCalorie();
	}
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male = male;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public float getDailyCalorie() {
		return dailyCalorie;
	}
	public void calculateDailyCalorie() {
		if (male.equals("male")) {
			this.dailyCalorie = (int)Math.round((float) (66 + (13.75 * weight) + (5 * height) - (6.8 * (2018 - yearOfBirth))));
		}
		else {
			this.dailyCalorie = (int)Math.round((float) (665 + (9.6 * weight) + (1.7 * height) - (4.7 * (2018 - yearOfBirth))));
		}
	}


	public float getTakenCalorie() {
		return takenCalorie;
	}


	public void setTakenCalorie(float takenCalorie) {
		this.takenCalorie += takenCalorie;
	}


	public float getBurnedCalorie() {
		return burnedCalorie;
	}


	public void setBurnedCalorie(float burnedCalorie) {
		this.burnedCalorie += burnedCalorie;
	}

	public float calculateResult(float need,float taken, float burned) {
		float result = (int)Math.round(taken - burned - need);
		return result;
	}
	
	

}
