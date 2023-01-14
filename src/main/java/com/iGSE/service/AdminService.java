package com.iGSE.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iGSE.entity.Bill;
import com.iGSE.entity.Meter;
import com.iGSE.entity.MeterReading;
import com.iGSE.mapper.AdminMapper;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;

	public int setMeterPrice(Meter meter) {
		Meter lastActiveMeter = adminMapper.getLastActiveMeterPrice();
		adminMapper.updateMeterPrice(lastActiveMeter);
		meter.setSubmissionDate(LocalDate.now().toString());
		meter.setActive("Y");
		return adminMapper.addMeterPrice(meter);
	}

	public List<MeterReading> getAllMeterReading() {
		return adminMapper.getAllMeterReading();
	}
	
	public List<Bill> getAllBills() {
		return adminMapper.getAllBills();
	}

	public Meter getMeterReading() {
		return adminMapper.getLastActiveMeterPrice();
	}

	public long getUserCount() {
		return adminMapper.getUserCount();
	}

	public long getMeterReadingCount() {
		return adminMapper.getMeterReadingCount();
	}

	public List<MeterReading> meterReadings() {
		return adminMapper.meterReadings();
	}

	public HashMap<String, Object> getAllCounts() {
		HashMap<String, Object> getAllCounts = new HashMap<String, Object>();
		getAllCounts.put("userCount",adminMapper.getUserCount());
		getAllCounts.put("meterReadingCount",adminMapper.getMeterReadingCount());
		getAllCounts.put("billCount",adminMapper.getBillCount());
		return getAllCounts;
	}

}
