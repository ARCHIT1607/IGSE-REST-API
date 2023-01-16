package com.iGSE.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<Bill> billStatistics() {
		return adminMapper.billStatistics();
	}

	public HashMap<String, Object> getAllCounts() {
		HashMap<String, Object> getAllCounts = new HashMap<String, Object>();
		getAllCounts.put("userCount", adminMapper.getUserCount());
		getAllCounts.put("meterReadingCount", adminMapper.getMeterReadingCount());
		getAllCounts.put("billCount", adminMapper.getBillCount());
		return getAllCounts;
	}

	public Meter getMeterPrice() {
		return adminMapper.getLastActiveMeterPrice();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List energyStatistic() {
		List<Map<Object,Object>> maxDates = adminMapper.getMaxDates();
		List<Bill> bills = new ArrayList<>();
		List<Map<Object,Object>> result = new ArrayList<>();
		for( Map date : maxDates) {
			bills.add(adminMapper.getLatestBill(date));
		}
		for(Bill bill : bills) {
			Map<Object,Object> map = new HashMap<>();
			map.put("customer",bill.getEmail());
			map.put("data", (bill.geteMeterReadingDay()+bill.geteMeterReadingNight()+bill.getgMeterReading())/bill.getDays());
			result.add(map);
		}
		return result;
	}

}
