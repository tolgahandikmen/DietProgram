
public class Sport {
	private int sportId;
	private String name;
	private int burnedCalorie;
	
	
	public Sport(int sportId, String name, int burnedCalorie) {
		this.sportId = sportId;
		this.name = name;
		this.burnedCalorie = burnedCalorie;
	}
	
	public int getSportId() {
		return sportId;
	}
	public void setSportId(int sportId) {
		this.sportId = sportId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBurnedCalorie() {
		return burnedCalorie;
	}
	public void setBurnedCalorie(int burnedCalorie) {
		this.burnedCalorie = burnedCalorie;
	}
	
}
