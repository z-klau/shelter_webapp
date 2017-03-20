package pl.shelterwebapp.form;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class DogForm {

	private Long id;

	@Size(min = 2)
	private String name;

	private String sex;

	@NotEmpty
	private String race;

	@NumberFormat
	@DecimalMin("0.3")
	@DecimalMax("80.0")
	private double weight;

	@NotEmpty
	private String placeOfFind;

	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfFind;

	private Long penId;

	public DogForm() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPlaceOfFind() {
		return placeOfFind;
	}

	public void setPlaceOfFind(String placeOfFind) {
		this.placeOfFind = placeOfFind;
	}

	public Date getDateOfFind() {
		return dateOfFind;
	}

	public void setDateOfFind(Date dateOfFind) {
		this.dateOfFind = dateOfFind;
	}

	public Long getPenId() {
		return penId;
	}

	public void setPenId(Long penId) {
		this.penId = penId;
	}

}
