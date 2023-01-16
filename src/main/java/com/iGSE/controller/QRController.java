package com.iGSE.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iGSE.entity.EVC;
import com.iGSE.service.QRService;

@RestController
@RequestMapping("/qr")
public class QRController {

	@Autowired
	private QRService qrService;

	@PostMapping("/upload/image")
	public ResponseEntity<Object> uplaodQr(@RequestParam("image") MultipartFile file, @RequestParam("evc") String evc)
			throws Exception {
		try {
			Object qr = qrService.uplaodQr(file, evc);
			return new ResponseEntity<Object>(qr, HttpStatus.OK);
		} catch (Exception e) {
e.printStackTrace();
			HashMap<Object, Object> map = new HashMap<>();
			if (e.getMessage().equals("EVC with similar context exists. Try with different one")) {
				map.put("errorMsg", e.getMessage());
				map.put("errorType", "admin_evc_exists");
			} else {
				map.put("errorMsg", e.getMessage());
			}
			return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}

	@GetMapping(path = { "/get/image/info/{evc}" })
	public EVC getQrDetails(@PathVariable("evc") String evc) throws Exception {

		return qrService.getQrDetails(evc);
	}

	@GetMapping(path = { "/get/image/{name}" })
	public ResponseEntity<byte[]> getQr(@PathVariable("name") String name) throws IOException {

		return qrService.getQr(name);

//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.valueOf(dbImage.get().getType()))
//                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
	}
}
