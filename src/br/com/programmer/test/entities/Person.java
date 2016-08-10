package br.com.programmer.test.entities;

public class Person {
	
	private String name;
	private Person son;
	private Car car;
	
	//gets sets
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getSon() {
		return son;
	}

	public void setSon(Person son) {
		this.son = son;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
