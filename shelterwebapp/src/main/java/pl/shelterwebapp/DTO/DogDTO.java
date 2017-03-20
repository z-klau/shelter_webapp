package pl.shelterwebapp.DTO;

public class DogDTO {

	private Long id;

	private String name;

	private String sex;

	private String race;

	private double weight;

	private String placeOfFind;

	private String dateOfFind;

	private String penName;

	private Long penId;

	public DogDTO(Long id, String name, String sex, String race, double weight, String placeOfFind, String dateOfFind,
			String penName, Long penId) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.race = race;
		this.weight = weight;
		this.placeOfFind = placeOfFind;
		this.dateOfFind = dateOfFind;
		this.penName = penName;
		this.penId = penId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getRace() {
		return race;
	}

	public double getWeight() {
		return weight;
	}

	public String getPlaceOfFind() {
		return placeOfFind;
	}

	public String getDateOfFind() {
		return dateOfFind;
	}

	public String getPenName() {
		return penName;
	}

	public Long getPenId() {
		return penId;
	}

}
