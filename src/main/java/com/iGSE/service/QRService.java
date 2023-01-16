package com.iGSE.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iGSE.entity.EVC;
import com.iGSE.repository.ImageRepository;
import com.iGSE.util.ImageUploadResponse;
import com.iGSE.util.ImageUtility;

@Service
public class QRService {

	@Autowired
	ImageRepository imageRepository;

	public Object uplaodQr(MultipartFile file, String evc) throws Exception {
		try {
			EVC existingEvc = imageRepository.findByEvc(evc);
			if(existingEvc.getId()!=null) {
				throw new Exception("EVC with similar context exists. Try with different one");
			}
			EVC img = new EVC();
	    	img.setImage(ImageUtility.compressImage(file.getBytes()));
	    	img.setName(file.getOriginalFilename());
	    	img.setType(file.getContentType());
	    	img.setEvc(evc);
	        imageRepository.save(img);
			return new ImageUploadResponse("Image uploaded successfully: " +
	              file.getOriginalFilename());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public EVC getQrDetails(String evc) throws Exception {
		EVC dbImage = imageRepository.findByEvc(evc);

		if(dbImage!=null) {
			EVC img = new EVC();
	        img.setId(dbImage.getId());
	    	img.setImage(ImageUtility.decompressImage(dbImage.getImage()));
	    	img.setName(dbImage.getName());
	    	img.setType(dbImage.getType());
	    	img.setEvc(dbImage.getEvc());
	    	img.setExpired(dbImage.isExpired());
			return img;
		}else {
			throw new Exception("EVC is not present");
		}
		
	}

	public ResponseEntity<byte[]> getQr(String name) {
		final Optional<EVC> dbImage = imageRepository.findByName(name);
		return ResponseEntity
              .ok()
              .contentType(MediaType.valueOf(dbImage.get().getType()))
              .body(ImageUtility.decompressImage(dbImage.get().getImage()));
	}

}
