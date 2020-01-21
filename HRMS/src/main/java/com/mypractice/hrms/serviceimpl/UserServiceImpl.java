/**
* 
*/
package com.mypractice.hrms.serviceimpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.bean.AddressBean;
import com.mypractice.hrms.bean.ApplicationBean;
import com.mypractice.hrms.bean.ApplicationPreviewBean;
import com.mypractice.hrms.bean.ResponseMessage;
import com.mypractice.hrms.bean.UserBean;
import com.mypractice.hrms.model.CityMaster;
import com.mypractice.hrms.model.DocumentMaster;
import com.mypractice.hrms.model.Education;
import com.mypractice.hrms.model.MenuAccessRole;
import com.mypractice.hrms.model.SubMenus;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.AddressDetails;
import com.mypractice.hrms.repository.AddressRepository;
import com.mypractice.hrms.repository.CityRepository;
import com.mypractice.hrms.repository.DocumentRepository;
import com.mypractice.hrms.repository.EducationRepository;
import com.mypractice.hrms.repository.MenuAccessRoleRepo;
import com.mypractice.hrms.repository.SubMenuRepo;
import com.mypractice.hrms.repository.UserDocRepository;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.service.UserService;
import com.mypractice.hrms.util.CommonUtils;

/**
 * @author Nasruddin Khan 30-Aug-2019 - 1:27:18 am UserServiceImpl.java
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MenuAccessRoleRepo menuRepo;
	@Autowired
	private SubMenuRepo subMenuRepo;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private EducationRepository educationRepo;
	@Autowired
	private UserDocRepository userDocRepo;
	
	@Autowired 
	private DocumentRepository docmtRepo;
	
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User checkEmail(String email) {
		return userRepo.findUserByEmailID(email);
	}

	@Override
	public ResponseMessage genrateRoleAccessMenu(User user) {
		// TODO Auto-generated method stub
		ResponseMessage responseMessage = new ResponseMessage();
		List<SubMenus> subMenus = subMenuRepo.findAllSubMenu(user.getUserRole());
		if (subMenus.isEmpty()) {
			throw new RuntimeException("please asign the menu access on below user");
		}
		List<MenuAccessRole> menUAccessList = new ArrayList<MenuAccessRole>();
		subMenus.forEach(obj -> {
			MenuAccessRole meAccessRole = new MenuAccessRole();
			meAccessRole.setActiveStatus(1);
			meAccessRole.setMenu(obj);
			meAccessRole.setUser(user);
			meAccessRole.setComments("Default Access");
			menUAccessList.add(meAccessRole);
		});
		System.out.println(subMenus.size());
		List<MenuAccessRole> menuAccess = menuRepo.saveAll(menUAccessList);
		if (menuAccess != null && menuAccess.size() > 0) {
			responseMessage.setErrorCode(200);
			responseMessage.setErrorMessage("Aproved Successfully");
		}
		return responseMessage;
	}

	@Override
	public Optional<User> findOne(Integer userid) {
		// TODO Auto-generated method stub
		return userRepo.findById(userid);
	}

	/**
	 * @param userID
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public ApplicationPreviewBean findUserDetails(Integer userID) {
		// TODO Auto-generated method stub
	
		ApplicationPreviewBean applicationBean = new ApplicationPreviewBean();
		User user = userRepo.findByuserID(userID);
		applicationBean = setUserDetails(applicationBean, user);
		AddressDetails addDtl =addressRepo.getUserDetails(user);
		applicationBean  = setAddressDetails(applicationBean, addDtl);
		applicationBean = setEducationDetails(applicationBean, user);
		DocumentMaster docMaster= docmtRepo.findById("PHT").get();
		String docName = userDocRepo.findByuserandusrDocuments(user, docMaster);
		String ecodeString = CommonUtils.readFileOnDisk( userID+"_"+docName);
		applicationBean.setEncodePhoto(ecodeString);
		return applicationBean;
	}

	/**
	 * @param applicationBean
	 * @param user
	 * @return
	 */
	private ApplicationPreviewBean setEducationDetails(ApplicationPreviewBean applicationBean, User user) {
		// TODO Auto-generated method stub
	    List<ApplicationBean> appBean = new ArrayList<ApplicationBean>();
		List<Education> educations= educationRepo.findByuser(user);
		appBean = educations.stream().map((Function<? super Education, ? extends ApplicationBean>) obj->{
			ApplicationBean app = new ApplicationBean();
			app.setCollegeName(obj.getCollegeName());
			app.setCourse(obj.getEducationMst().getCourseID());
			app.setDuration(obj.getFromDate()+" "+obj.getToDate());
			app.setUnivercityName(obj.getUniversityMst().getUnivercityName());
			app.setPercentage(String.valueOf(obj.getPercentage()));
			return app;
		}).collect(Collectors.toList());
		
		applicationBean.setApplicationBean(appBean);
		return applicationBean;
	}

	/**
	 * @param applicationBean
	 * @param addDtl
	 * @return
	 */
	private ApplicationPreviewBean setAddressDetails(ApplicationPreviewBean applicationBean, AddressDetails addDtl) {
		// TODO Auto-generated method stub
		AddressBean addBean = new AddressBean();
		CityMaster citymst = cityRepo.findById(addDtl.getCityID()).get();
		addBean.setCountry("India");
		addBean.setState(citymst.getStateMst().getStateName());
		addBean.setPinCode(String.valueOf(addDtl.getPinCode()));
		addBean.setAddress(addDtl.getAddressDetails());
		addBean.setCity(citymst.getCityName());
		applicationBean.setAddressBean(addBean);
		return applicationBean;
	}

	/**
	 * @param applicationBean
	 * @param user
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private ApplicationPreviewBean setUserDetails(ApplicationPreviewBean applicationBean, User user) {
		// TODO Auto-generated method stub
		UserBean userBean =new  UserBean();
		userBean.setFirstName(user.getFirstName()+" "+user.getLastName());
		userBean.setLastName(userBean.getLastName());
		userBean.setFatherName(user.getFatherName()+" "+user.getLastName());
		userBean.setAadhaarno(user.getAadhaarDetails());
		userBean.setGender(user.getGender()=="M"?"Male":"Female");
		userBean.setMaritial(user.getMaritialStatus()=="U"?"Unmarried":"Married");
		userBean.setDob(user.getDob());
		userBean.setDoj(user.getDoj());
		userBean.setAadhaarno( user.getAadhaarDetails());
		userBean.setPancard(user.getPanCard());
		userBean.setEmail(user.getEmail());
		userBean.setContactno(user.getContactNo());
		userBean.setRefererContact(user.getRefererContact());
		userBean.setRefererName(user.getRefererName());
		userBean.setRefererEmail(user.getRefererEmail());
		userBean.setGuardian(user.getGurdianContactNo());
		userBean.setLastName(user.getLastName());
		userBean.setIsPersonalFlag(user.getIsPersonalFlag());
		applicationBean.setUserBean(userBean);
		return applicationBean;
	}
}
