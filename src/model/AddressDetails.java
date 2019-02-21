package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address_details")
public class AddressDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private int id;
	@Column(name = "ADDRESS_NAME")
	private String addressName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SCHOOL_ID")
	private School school;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//	@JoinTable(name = "ADDRESS_DETAILS", joinColumns = {
//			@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID") }, inverseJoinColumns = {
//					@JoinColumn(name = "ITEM_ID", referencedColumnName = "ID", unique = true) })

	private List<ContactsListItem> listOfItems;

	public AddressDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDetails(String addressName, School school) {
		super();
		this.addressName = addressName;
		this.school = school;
	}

	public AddressDetails(String addressName, School school, List<ContactsListItem> listOfItems) {
		super();
		this.addressName = addressName;
		this.school = school;
		this.listOfItems = listOfItems;
	}

	public AddressDetails(int id, String addressName, School school, List<ContactsListItem> listOfItems) {
		super();
		this.id = id;
		this.addressName = addressName;
		this.school = school;
		this.listOfItems = listOfItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<ContactsListItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<ContactsListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "AddressDetails [id=" + id + ", addressName=" + addressName + ", school=" + school + ", listOfItems="
				+ listOfItems + "]";
	}

}