package pl.shelterwebapp.form;

import java.util.Date;

import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class DogSearchForm {

	private String name;

	private String sex;

	private String race;

	@NumberFormat
	private double weightFrom;

	@NumberFormat
	private double weightTo;

	private String placeOfFind;

	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfFindFrom;

	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfFindTo;

	private Long penId;

	private String penName;

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

	public double getWeightFrom() {
		return weightFrom;
	}

	public void setWeightFrom(double weightFrom) {
		this.weightFrom = weightFrom;
	}

	public double getWeightTo() {
		return weightTo;
	}

	public void setWeightTo(double weightTo) {
		this.weightTo = weightTo;
	}

	public String getPlaceOfFind() {
		return placeOfFind;
	}

	public void setPlaceOfFind(String placeOfFind) {
		this.placeOfFind = placeOfFind;
	}

	public Date getDateOfFindFrom() {
		return dateOfFindFrom;
	}

	public void setDateOfFindFrom(Date dateOfFindFrom) {
		this.dateOfFindFrom = dateOfFindFrom;
	}

	public Date getDateOfFindTo() {
		return dateOfFindTo;
	}

	public void setDateOfFindTo(Date dateOfFindTo) {
		this.dateOfFindTo = dateOfFindTo;
	}

	public Long getPenId() {
		return penId;
	}

	public void setPenId(Long penId) {
		this.penId = penId;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

}
