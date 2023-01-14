package com.iGSE.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "BILL_SEQ")
	@SequenceGenerator(initialValue=1, name="BILL_SEQ", sequenceName="BILL_SEQ", allocationSize=1)
	private long id;
	
	private int eMeterReadingDay;

	private int eMeterReadingNight;

	private int gMeterReading;
	
	private long days;
	
	private String billDate;
	
	private String email;
	
	private double due;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String status = "un-paid";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int geteMeterReadingDay() {
		return eMeterReadingDay;
	}

	public void seteMeterReadingDay(int eMeterReadingDay) {
		this.eMeterReadingDay = eMeterReadingDay;
	}

	public int geteMeterReadingNight() {
		return eMeterReadingNight;
	}

	public void seteMeterReadingNight(int eMeterReadingNight) {
		this.eMeterReadingNight = eMeterReadingNight;
	}

	public int getgMeterReading() {
		return gMeterReading;
	}

	public void setgMeterReading(int gMeterReading) {
		this.gMeterReading = gMeterReading;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public long getDays() {
		return days;
	}

	public void setDays(long days) {
		this.days = days;
	}

	public double getDue() {
		return due;
	}

	public void setDue(double due) {
		this.due = due;
	}

	

	public Bill(long id, int eMeterReadingDay, int eMeterReadingNight, int gMeterReading, long days, String billDate,
			String email, double due, String status) {
		super();
		this.id = id;
		this.eMeterReadingDay = eMeterReadingDay;
		this.eMeterReadingNight = eMeterReadingNight;
		this.gMeterReading = gMeterReading;
		this.days = days;
		this.billDate = billDate;
		this.email = email;
		this.due = due;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", eMeterReadingDay=" + eMeterReadingDay + ", eMeterReadingNight="
				+ eMeterReadingNight + ", gMeterReading=" + gMeterReading + ", days=" + days + ", billDate=" + billDate
				+ ", email=" + email + ", due=" + due + ", status=" + status + "]";
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
