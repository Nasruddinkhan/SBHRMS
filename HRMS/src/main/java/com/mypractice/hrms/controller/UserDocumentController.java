/**
 * nasru
 * UserDocumentController.java
 * Jan 4, 2020
 */
package com.mypractice.hrms.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mypractice.hrms.bean.DropDownBean;
import com.mypractice.hrms.bean.UserUploadDocBean;
import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.DocumentMaster;
import com.mypractice.hrms.model.Education;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.model.UserDocument;
import com.mypractice.hrms.repository.DocumentRepository;
import com.mypractice.hrms.repository.EducationRepository;
import com.mypractice.hrms.repository.UserDocRepository;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.util.CommonUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

/**
 * @author nasru
 *
 */
@RestController
@RequestMapping("/hrms/api/")
public class UserDocumentController {

	@Autowired
	private EducationRepository educationRepository;
	@Autowired 
	private UserRepository userRepository;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private UserDocRepository userDocRepo;
	
	@GetMapping("userdoc/{userId}/onloaddata")
	public ResponseEntity<?> getOnLoadDropDowns(@PathVariable("userId") Integer userID){
		User user = userRepository.findById(userID).get();
		List<Education> education = educationRepository.findByuser(user);	
		if(education.isEmpty())
			throw new ResourceNotFoundException("Please upload first your education details");
		List<DropDownBean> objList = education.stream().map((Function<? super Education, ? extends DropDownBean>)obj->{
			DropDownBean bean = new DropDownBean();
			bean.setId(obj.getEducationMst().getCourseID());
			bean.setCode(obj.getEducationMst().getCourseName());
			return bean;
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(objList);
	}
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", 
	                      required = true, dataType = "string", paramType = "header") })
	@GetMapping("userdoc/{userId}/uploaddocs")
	
	public ResponseEntity<?> findAll(@PathVariable("userId") Integer userID){
		User user = userRepository.findById(userID).get();
		List<UserDocument> education = userDocRepo.findByuser(user);	
		if(education.isEmpty())
			throw new ResourceNotFoundException("Please upload first your education details");
		List<UserUploadDocBean> objList = education.stream().map((Function<? super UserDocument, ? extends UserUploadDocBean>)obj->{
			Integer userid=obj.getUser().getUserID();
			String docName = obj.getDocuentName();
			UserUploadDocBean bean = new UserUploadDocBean();
			bean.setUserDocID(obj.getUserDocID());
			bean.setContentType(obj.getDoccumentContentType());
			bean.setUserId(userid);
			bean.setFileName(docName);
			bean.setDocID(obj.getUsrDocuments().getDocumentID());
			bean.setFile(CommonUtils.readFileOnDisk(userid+"_"+docName));
			bean.setDocumentID(obj.getUsrDocuments().getDocumentName());
			return bean;
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(objList);
	}

	/**
	 * @param string
	 * @return
	 */
	
	@PostMapping(value = "userdoc/upload" )
	public ResponseEntity<?> saveDocs(@RequestBody UserUploadDocBean userDocBean) throws IOException {
		User user = userRepository.findById(userDocBean.getUserId()).get();
		if (CommonUtils.checkFileOnDisk(userDocBean.getUserId() + "_" + userDocBean.getFileName()))
			throw new RuntimeException("file allready uplaoad");
		DocumentMaster docMst = documentRepository.findById(userDocBean.getDocumentID()).get();

		UserDocument userDoc = new UserDocument();
		userDoc.setUser(user);
		userDoc.setDocuentName(userDocBean.getFileName());
		userDoc.setDoccumentContentType(userDocBean.getContentType().substring(1));
		userDoc.setUsrDocuments(docMst);
		System.out.println(userDocBean.getUserId() + "_" + userDocBean.getFileName());
		userDoc.setDocument(CommonUtils.writeFileOnDisk(userDocBean.getFile(),
				userDocBean.getUserId() + "_" + userDocBean.getFileName()));
		UserDocument userDocm = userDocRepo.save(userDoc);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userDocID}")
				.buildAndExpand(userDocm.getUserDocID()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping("userdoc/{userDocID}/{userID}/deletedocs")
	public void deleteUserDocID(@PathVariable  Integer userDocID, @PathVariable  Integer userID) {
		Optional<UserDocument> userDoc = userDocRepo.findById(userDocID);
		if(!userDoc.isPresent())
			throw new ResourceNotFoundException("Document is not present");
		UserDocument usrDoc = userDoc.get();
		CommonUtils.deleFileOnDisk(userID+"_"+usrDoc.getDocuentName());
		userDocRepo.delete(usrDoc);
	}
	
}
