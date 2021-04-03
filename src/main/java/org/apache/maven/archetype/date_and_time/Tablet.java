package org.apache.maven.archetype.date_and_time;

import java.time.LocalDate;

public class Tablet {

	String tabName;
	String tabManufacture;
	LocalDate tabManufactureDate;
	LocalDate tabExpiryDate;
	
	
	public Tablet(String tabName, String tabManufacture, LocalDate tabManufactureDate, LocalDate tabExpiryDate) {
		super();
		this.tabName = tabName;
		this.tabManufacture = tabManufacture;
		this.tabManufactureDate = tabManufactureDate;
		this.tabExpiryDate = tabExpiryDate;
	}
	
	public String getTabName() {
		return tabName;
	}
	
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}
	
	public String getTabManufacture() {
		return tabManufacture;
	}
	
	public void setTabManufacture(String tabManufacture) {
		this.tabManufacture = tabManufacture;
	}
	
	public LocalDate getTabManufactureDate() {
		return tabManufactureDate;
	}
	
	public void setTabManufactureDate(LocalDate tabManufactureDate) {
		this.tabManufactureDate = tabManufactureDate;
	}
	
	public LocalDate getTabExpiryDate() {
		return tabExpiryDate;
	}
	
	public void setTabExpiryDate(LocalDate tabExpiryDate) {
		this.tabExpiryDate = tabExpiryDate;
	}

	@Override
	public String toString() {
		return "Tablet [tabName=" + tabName + ", tabManufacture=" + tabManufacture + ", tabManufactureDate="
				+ tabManufactureDate + ", tabExpiryDate=" + tabExpiryDate + "]";
	}
	
}
