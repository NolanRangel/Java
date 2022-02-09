package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser{
		private ArrayList<String> patientNotes;
		private Integer physId;
		private int pin;
		
		public Physician(Integer id) {
			this.physId = id;
			this.patientNotes = new ArrayList<String>();
			
		}
		

		public boolean assignPin(int pin) {
			if(pin > 999 && pin < 10000) {
				this.pin = pin;
				return true;
			} else {
				return false;
			}
			
		}
		public boolean accessAuthorized(Integer id) {
			if(this.physId == id) {
				return true;
			} else {
				return false;
			}
		}


		
	    public void newPatientNotes(String notes, String patientName, Date date) {
	        String report = String.format(
	            "Datetime Submitted: %s \n", date);
	        report += String.format("Reported By ID: %s\n", this.physId);
	        report += String.format("Patient Name: %s\n", patientName);
	        report += String.format("Notes: %s \n", notes);
	        this.patientNotes.add(report);
	    }


		public ArrayList<String> getPatientNotes() {
			return patientNotes;
		}


		public void setPatientNotes(ArrayList<String> patientNotes) {
			this.patientNotes = patientNotes;
		}


		public Integer getId() {
			return physId;
		}


		public void setId(int id) {
			this.physId = id;
		}


		public int getPin() {
			return pin;
		}


		public void setPin(int pin) {
			this.pin = pin;
		}
		

		
		
	}


