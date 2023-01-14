package com.iGSE.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class MeterReading {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "METER_READING_SEQ")
	@SequenceGenerator(initialValue=1, name="METER_READING_SEQ", sequenceName="METER_READING_SEQ", allocationSize=1)
	private long id;

	private int eMeterReadingDay;

	private int eMeterReadingNight;

	private int gMeterReading;

	private String submissionDate;
	
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MeterReading() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeterReading(long id, int eMeterReadingDay, int eMeterReadingNight, int gMeterReading, String submissionDate,
			String email) {
		super();
		this.id = id;
		this.eMeterReadingDay = eMeterReadingDay;
		this.eMeterReadingNight = eMeterReadingNight;
		this.gMeterReading = gMeterReading;
		this.submissionDate = submissionDate;
		this.email = email;
	}

	@Override
	public String toString() {
		return "MeterReading [id=" + id + ", eMeterReadingDay=" + eMeterReadingDay + ", eMeterReadingNight="
				+ eMeterReadingNight + ", gMeterReading=" + gMeterReading + ", submissionDate=" + submissionDate
				+ ", email=" + email + "]";
	}

	

}
