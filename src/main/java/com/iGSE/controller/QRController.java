package com.iGSE.controller;

import java.io.IOException;

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
			throws IOException {

		return new ResponseEntity<Object>(qrService.uplaodQr(file, evc), HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ImageUploadResponse("Image uploaded successfully: " +
//                        file.getOriginalFilename()));
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
