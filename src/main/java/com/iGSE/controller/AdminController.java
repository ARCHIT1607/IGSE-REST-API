package com.iGSE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iGSE.entity.Meter;
import com.iGSE.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("admin/setMeterPrice")
	public ResponseEntity<Object> setMeterPrice(@RequestBody Meter meter){
		try {
			if (meter.geteMeterPriceDay() == 0.0 ||meter.geteMeterPriceNight() == 0.0 ||
					meter.getgMeterPrice() == 0.0 || meter.getStandingCharge() ==0.0) {
				throw new Exception("Meter Price is invalid");
			} else {
				return new ResponseEntity<Object>(adminService.setMeterPrice(meter), HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("admin/getAllMeterReading")
	public ResponseEntity<Object> getAllMeterReading(){
		try {
				return new ResponseEntity<Object>(adminService.getAllMeterReading(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("admin/getAllBills")
	public ResponseEntity<Object> getAllBills(){
		try {
				return new ResponseEntity<Object>(adminService.getAllBills(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("admin/meterReadings")
	public ResponseEntity<Object> meterReadings(){
		try {
				return new ResponseEntity<Object>(adminService.meterReadings(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("admin/billStatistics")
	public ResponseEntity<Object> billStatistics(){
		try {
				return new ResponseEntity<Object>(adminService.billStatistics(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("admin/getAllCounts")
	public ResponseEntity<Object> getAllCounts(){
		try {
				return new ResponseEntity<Object>(adminService.getAllCounts(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("admin/getUserCount")
	public ResponseEntity<Object> getUserCount(){
		try {
				return new ResponseEntity<Object>(adminService.getUserCount(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("admin/getMeterReadingCount")
	public ResponseEntity<Object> getMeterReadingCount(){
		try {
				return new ResponseEntity<Object>(adminService.getMeterReadingCount(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/admin/getMeterPrice")
	public ResponseEntity<Object> getMeterReading() {
		try {
			return new ResponseEntity<Object>(adminService.getMeterPrice(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/admin/energyStatistic")
	public ResponseEntity<Object> energyStatistic() {
		try {
			return new ResponseEntity<Object>(adminService.energyStatistic(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
