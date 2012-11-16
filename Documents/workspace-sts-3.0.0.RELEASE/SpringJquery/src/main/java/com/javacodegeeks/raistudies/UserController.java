package com.javacodegeeks.raistudies;

import java.util.ArrayList;
import java.util.List;

import com.javacodegeeks.raistudies.domain.JsonResponse;
import com.javacodegeeks.raistudies.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	private List<User> userList  = new ArrayList<User>();
	
	@RequestMapping(value="/AddUser.htm", method=RequestMethod.GET)
	public String showForm(){
		return "AddUser";
	}
	
	@RequestMapping(value="/AddUser.htm", method=RequestMethod.POST)
	public @ResponseBody JsonResponse addUser(@ModelAttribute(value="user") User user, BindingResult result){
		JsonResponse res = new JsonResponse();
		ValidationUtils.rejectIfEmpty(result, "name", "Name can not be empty.");
		ValidationUtils.rejectIfEmpty(result, "education", "Education not be empty");
		if(!result.hasErrors()){
			userList.add(user);
			res.setStatus("SUCCESS");
			res.setResult(userList);
		}else {
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
		}
		return res;
	}
	
	
}
