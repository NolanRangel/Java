package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	    private Integer employeeID;
	    private String role;
	    private int pin;
	    private ArrayList<String> securityIncidents;
	    

	    public AdminUser(int id, String role) {
	    	this.employeeID = id;
	    	this.role = role;
	    	this.securityIncidents = new ArrayList<String>();
	    }
	    
	    
	    // TO DO: Implement HIPAACompliantUser!
	    public boolean assignPin(int pin) {
	    	if(pin > 99999 && pin < 1000000) {
	    		this.pin = pin;
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
	    
	    public boolean accessAuthorized(Integer id) {
	    	if(this.employeeID != id) {
	    		this.authIncident();
	    		return false;
	    	} else {
	    		return true;
	    	}
	    }
	    
	    // TO DO: Implement HIPAACompliantAdmin!
	    public ArrayList<String> reportSecurityIncidents(){
	    	return this.securityIncidents;
	    }
	    
	    
	   
	    
	    
	    public void newIncident(String notes) {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	            new Date(), this.employeeID, notes
	        );
	        securityIncidents.add(report);
	    }
	    public void authIncident() {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	            new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	        );
	        securityIncidents.add(report);
	    }
	    
	    // TO DO: Setters & Getters
		public Integer getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(Integer employeeID) {
			this.employeeID = employeeID;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public int getPin() {
			return pin;
		}

		public void setPin(int pin) {
			this.pin = pin;
		}

		public ArrayList<String> getSecurityIncidents() {
			return securityIncidents;
		}

		public void setSecurityIncidents(ArrayList<String> securityIncidents) {
			this.securityIncidents = securityIncidents;
		}
	    


}
