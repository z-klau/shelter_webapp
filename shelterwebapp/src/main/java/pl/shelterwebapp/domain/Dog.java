package pl.shelterwebapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dogs")
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String sex;
	private String race;
	private double weight;

	@Column(name = "place_of_find")
	private String placeOfFind;

	@Column(name = "date_of_find")
	@Temporal(TemporalType.DATE)
	private Date dateOfFind;

	@ManyToOne
	@JoinColumn(name = "pen_id")
	private Pen pen;

	public Dog() {
	}

	public Dog(Long id, String name, String sex, String race, double weight, String placeOfFind, Date dateOfFind, Pen pen) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.race = race;
		this.weight = weight;
		this.placeOfFind = placeOfFind;
		this.dateOfFind = dateOfFind;
		this.pen = pen;
		pen.getDogs().add(this);
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

	public Pen getPen() {
		return pen;
	}

	public void setPen(Pen pen) {
		this.pen = pen;
	}

}
