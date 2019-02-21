package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCHOOL_ID")
	private int id;
	@Column(name = "SCHOOL_NAME")
	private String schoolName;

	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

	public School(String schoolName) {
		super();
		this.schoolName = schoolName;
	}

	public School(int id, String schoolName) {
		super();
		this.id = id;
		this.schoolName = schoolName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String SchoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", schoolName=" + schoolName + "]";
	}
}