package com.iGSE.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.iGSE.entity.Bill;
import com.iGSE.entity.Customer;
import com.iGSE.entity.Meter;
import com.iGSE.entity.MeterReading;

@Mapper
public interface CustomerMapper {
	
	public Customer findByEmail(String email);

	public Long register(Customer cus);

	public Customer getUserDetails(String email);

	public Long submitMeterReading(MeterReading mReading);

	public String getBalance(String email);

	public void topUp(Customer cus);

	public List<MeterReading> getMeterReadings(String email);

	public List<Bill> getBill(String email);
	
	public List<Bill> getUnPaidBill(String email);

	public void generateBill(Bill bill);

	public void payBill(Bill bill);

	public MeterReading checkSubmissionDate(Map<String, String> param);
	
	Meter getLastActiveMeterPrice();

	public void updateBalance(Customer customer);

}
