package indi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Car {
@Id
@GeneratedValue
private int id;
private String model;
private String make;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
@Override
public String toString() {
	return "Car [id=" + id + ", model=" + model + ", make=" + make + "]";
}

}
