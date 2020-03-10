/**
* 
*/
package com.mypractice.hrms.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.hrms.bean.DropDownBean;
import com.mypractice.hrms.bean.LoginBO;
import com.mypractice.hrms.bean.ResponseMessage;
import com.mypractice.hrms.model.InOutTime;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.InOutTimeRepo;
import com.mypractice.hrms.repository.MenuAccessRoleRepo;
import com.mypractice.hrms.repository.SubMenuRepo;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.security.JwtUtil;
import com.mypractice.hrms.serviceimpl.UserServiceDetails;
import com.mypractice.hrms.util.CommonUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Nasruddin Khan 10-Jun-2019 - 2:42:56 am LoginController.java
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Value("${app.approve.status}")
	private String approved;
	@Autowired
	private MenuAccessRoleRepo menuRepo;
	@Autowired
	private SubMenuRepo subMenuRepo;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private UserServiceDetails userServiceDtl;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InOutTimeRepo inOutTimeRepo;
	
	@Autowired
	private JwtUtil JwtUtil;

	
	@PostMapping(value = "/validateUser")
	@ApiOperation(value = "LoginBO Bo.", notes = "validate the login user.")
	public ResponseEntity<?> validate(
			@ApiParam(value = "LoginBO Bo is required", required = true) @RequestBody LoginBO loginBO) {
		System.out.println("[" + loginBO.getUsername() + "] [" + loginBO.getPassword() + "]");
		authManager.authenticate(new UsernamePasswordAuthenticationToken(loginBO.getUsername(), loginBO.getPassword()));

		final UserDetails userDetails = userServiceDtl.loadUserByUsername(loginBO.getUsername());
		ResponseMessage msg = new ResponseMessage();
		// TODO Auto-generated method stub
		User details = userRepository.findUserByEmailID(loginBO.getUsername());
		List<DropDownBean> accessMenus = null;
			Predicate<String> checkStatus = s -> approved.intern() == s.intern();
			System.out.println(details.getStatusMaster().getStatusID() + " " + approved);
			if (checkStatus.test(details.getStatusMaster().getStatusID())) {
				Function<String, Integer> errorApply = t -> t.intern() == "FTL" ? 205 : 200;
				msg.setErrorCode(errorApply.apply(details.getUserType()));
				msg.setErrorMessage("Success");
				msg.setToken(JwtUtil.genrateToken(userDetails));
				Map<String, List<DropDownBean>> acceessMenu = new HashMap<String, List<DropDownBean>>();
				List<String> suBmenus = menuRepo.findAllSubMenus(details).stream().map(c -> c.getMenu().getSubMenuId())
						.collect(Collectors.toList());
				if (suBmenus != null && suBmenus.size() > 0)
					accessMenus = subMenuRepo.findAll(suBmenus).stream().map(o -> {
						DropDownBean drop = new DropDownBean();
						drop.setId(o.getSubMenuId());
						drop.setCode(o.getSubMenuName());
						return drop;
					}).collect(Collectors.toList());
				LocalDateTime locDate = LocalDateTime.now();
				LocalDate  localDate = LocalDate.of(locDate.getYear(), locDate.getMonth(), locDate.getDayOfMonth());
				System.out.println("LocalDate "+localDate);
				InOutTime inTime = inOutTimeRepo.finByInOutTime(details,  localDate.toString());
				 System.out.println(inTime);
				if(inTime == null) {
					inTime = new InOutTime();
					inTime.setInTime(LocalDateTime.now());
					inTime.setDay(LocalDateTime.now().getDayOfWeek().name());
					inTime.setUser(details);
				}else {
					inTime.setInOutTime(LocalDateTime.now());
					//inTime.setTotalSpendHours();
					LocalDateTime time = inTime.getInTime();
					LocalDateTime from = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), time.getHour(), time.getMinute(), time.getSecond());
					LocalDateTime to = LocalDateTime.now();
					LocalDateTime fromTemp = LocalDateTime.from(from);
					LocalTime timeDiff = CommonUtils.getTimeDiffrent(fromTemp, to);
					inTime.setTotalSpendHours(timeDiff);
					inTime.setInOutTime(LocalDateTime.now());
				}
				inOutTimeRepo.save(inTime);
				acceessMenu.put("menus", accessMenus);
				msg.setMap(acceessMenu);
				msg.setUser(details);
				return new ResponseEntity<>(msg, HttpStatus.OK);
			}
			throw new RuntimeException("Inactive user! Application is pending for registration");
	}


	
}
