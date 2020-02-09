/**
 * nasru
 * InOutController.java
 * Feb 9, 2020
 */
package com.mypractice.hrms.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.hrms.model.InOutTime;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.InOutTimeRepo;
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
public class InOutController {
	@Autowired
	private InOutTimeRepo inOutTimeRepo;
	@Autowired
	private UserRepository userRepository;
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", 
	                      required = true, dataType = "string", paramType = "header") })
	@GetMapping("inouttime/{userId}/{pageNo}/times")
	public Page<InOutTime> findAllInOutTime(@PathVariable Integer userId, @PathVariable Integer pageNo){
		System.out.println(pageNo);
		Pageable  firstPageWithTwoElements  = PageRequest.of(pageNo-1, 10, Sort.by("inOutTimeID").descending());
		return  inOutTimeRepo.findAllByuser(userRepository.findById(userId).get(), firstPageWithTwoElements );
	}
	
	@GetMapping("inouttime/{userId}/logout")
	public InOutTime logOutTime(@PathVariable Integer userId){
		LocalDateTime locDate = LocalDateTime.now();
		LocalDate  localDate = LocalDate.of(locDate.getYear(), locDate.getMonth(), locDate.getDayOfMonth());
		User user = userRepository.findById(userId).get();
		InOutTime inTime = inOutTimeRepo.finByInOutTime(user,  localDate.toString());
		inTime.setInOutTime(LocalDateTime.now());
		//inTime.setTotalSpendHours();
		LocalDateTime time = inTime.getInTime();
		LocalDateTime from = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), time.getHour(), time.getMinute(), time.getSecond());
		LocalDateTime to = LocalDateTime.now();
		LocalDateTime fromTemp = LocalDateTime.from(from);
		LocalTime timeDiff = CommonUtils.getTimeDiffrent(fromTemp, to);
		inTime.setTotalSpendHours(timeDiff);
		inTime.setInOutTime(LocalDateTime.now());
		return  inOutTimeRepo.save(inTime);
	}
}
