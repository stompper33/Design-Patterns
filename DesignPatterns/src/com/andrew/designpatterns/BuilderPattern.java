package com.andrew.designpatterns;

public class BuilderPattern {

	public static void main(String[] args)
	{
		Person person1 = 
				new PersonBuilder()
					.setFname("Andrew")
					.setLname("Calderon")
					.setAge(27)
					.setGender("Male").createPerson();
	
		Person person2 = 
				new PersonBuilder()
				.setFname("Tina")
				.setLname("Romero")
				.setEmployed(false)
				.createPerson();
		
		System.out.println(person1);
		System.out.println(person2);
	}
}

class Person
{
	String fname;
	String lname;
	String mname;
	int age;
	String occupation;
	String address;
	boolean isEmployed;
	String gender;
	
	public Person(String fname, String lname, String mname, int age, String occupation, String address,
			boolean isEmployed, String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mname = mname;
		this.age = age;
		this.occupation = occupation;
		this.address = address;
		this.isEmployed = isEmployed;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + ", mname=" + mname + ", age=" + age + ", occupation="
				+ occupation + ", address=" + address + ", isEmployed=" + isEmployed + ", gender=" + gender + "]";
	}
}

class PersonBuilder
{
	String fname;
	String lname;
	String mname;
	int age;
	String occupation;
	String address;
	boolean isEmployed;
	String gender;
	
	public PersonBuilder setFname(String fname) {
		this.fname = fname;
		return this;
	}
	public PersonBuilder setLname(String lname) {
		this.lname = lname;
		return this;
	}
	public PersonBuilder setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public PersonBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	public PersonBuilder setOccupation(String occupation) {
		this.occupation = occupation;
		return this;
	}
	public PersonBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	public PersonBuilder setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
		return this;
	}
	public PersonBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}
	
	public Person createPerson()
	{
		return new Person(fname, lname, mname, age, occupation, address,
				isEmployed, gender);
	}	
}