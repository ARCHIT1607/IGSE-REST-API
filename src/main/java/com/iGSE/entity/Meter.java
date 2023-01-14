package com.iGSE.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Meter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "METER_SEQ")
	@SequenceGenerator(initialValue = 1, name = "METER_SEQ", sequenceName = "METER_SEQ", allocationSize = 1)
	private long id;

	private double eMeterPriceDay;

	private double eMeterPriceNight;

	private double gMeterPrice;
	
	private double standingCharge = 0.35;
	
	private String submissionDate;

	@Column(name = "isActive", unique = false)
	private String isActive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double geteMeterPriceDay() {
		return eMeterPriceDay;
	}

	public void seteMeterPriceDay(double eMeterPriceDay) {
		this.eMeterPriceDay = eMeterPriceDay;
	}

	public double geteMeterPriceNight() {
		return eMeterPriceNight;
	}

	public void seteMeterPriceNight(double eMeterPriceNight) {
		this.eMeterPriceNight = eMeterPriceNight;
	}

	public double getgMeterPrice() {
		return gMeterPrice;
	}

	public void setgMeterPrice(double gMeterPrice) {
		this.gMeterPrice = gMeterPrice;
	}

	public double getStandingCharge() {
		return standingCharge;
	}

	public void setStandingCharge(double standingCharge) {
		this.standingCharge = standingCharge;
	}

	public String isActive() {
		return isActive;
	}

	public void setActive(String isActive) {
		this.isActive = isActive;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	

	@Override
	public String toString() {
		return "Meter [id=" + id + ", eMeterPriceDay=" + eMeterPriceDay + ", eMeterPriceNight=" + eMeterPriceNight
				+ ", gMeterPrice=" + gMeterPrice + ", standingCharge=" + standingCharge + ", submissionDate="
				+ submissionDate + ", active=" + isActive + "]";
	}

	public Meter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meter(long id, double eMeterPriceDay, double eMeterPriceNight, double gMeterPrice, double standingCharge,
			String submissionDate, String isActive) {
		super();
		this.id = id;
		this.eMeterPriceDay = eMeterPriceDay;
		this.eMeterPriceNight = eMeterPriceNight;
		this.gMeterPrice = gMeterPrice;
		this.standingCharge = standingCharge;
		this.submissionDate = submissionDate;
		this.isActive = isActive;
	}

	


}
