package com.jacaranda.primerSpring.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.jacaranda.primerSpring.model.Users;
import com.jacaranda.primerSpring.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository repository;

	@Autowired
	Cloudinary cloudinaryConfig;
	
	public Users getUser(String id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Users> getUsers() {
		return repository.findAll();
	}
	
	public Users addUser(Users user) {
		user.setPassword(getMD5(user.getPassword()));
		user.setAdmin(false);
		user.setRole("USER");
		user.setEnabled(false);
		user.setVerificationCode("code_example");
		
		

		return repository.save(user);
	}
	
	public Users updateUser(Users modUser) {
		Users user = this.getUser(modUser.getUsername());
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(modUser.getPassword());
		if(!modUser.getPassword().isEmpty() && !modUser.getPassword().equals(user.getPassword())) {
			user.setPassword(encodedPassword);
		}
		user.setFirst_name(modUser.getFirst_name());
		user.setEmail(modUser.getEmail());
		user.setImage(modUser.getImage());
		return repository.save(user);
	}
	

	public String uploadFile(MultipartFile file) {
		try {
			File uploadedFile = convertMultiPartToFile(file);
			Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
			boolean isDeleted = uploadedFile.delete();
			if (isDeleted) {
				System.out.println("File successfully deleted");
			} else
				System.out.println("File doesn't exist");
			return uploadResult.get("url").toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	public Users updateAdmin(Users modUser) {
		Users user = this.getUser(modUser.getUsername());
		if(modUser.isAdmin()==true) {
			user.setRole("ADMIN");			
		}else {
			user.setRole("USER");	
		}
		return repository.save(user);
	}

	public void deleteUser(String id) {
		repository.deleteById(id);
	}

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
