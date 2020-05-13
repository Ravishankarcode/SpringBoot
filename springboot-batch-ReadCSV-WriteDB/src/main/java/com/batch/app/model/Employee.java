package com.batch.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String employeeName;
	private String designation;
	private String createdTS;
	private String modifiedTS;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(String createdTS) {
		this.createdTS = createdTS;
	}

	public String getModifiedTS() {
		return modifiedTS;
	}

	public void setModifiedTS(String modifiedTS) {
		this.modifiedTS = modifiedTS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdTS == null) ? 0 : createdTS.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + id;
		result = prime * result + ((modifiedTS == null) ? 0 : modifiedTS.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (createdTS == null) {
			if (other.createdTS != null)
				return false;
		} else if (!createdTS.equals(other.createdTS))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (id != other.id)
			return false;
		if (modifiedTS == null) {
			if (other.modifiedTS != null)
				return false;
		} else if (!modifiedTS.equals(other.modifiedTS))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", designation=" + designation + ", createdTS="
				+ createdTS + ", modifiedTS=" + modifiedTS + "]";
	}

}
