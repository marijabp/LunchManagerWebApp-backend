package com.lunchmanager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lunchmanager.security.JwtGenerator;
import com.lunchmanager.security.JwtValidator;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@Autowired
	private JwtValidator jwtValidator;
	
	@RequestMapping("/users")
	public List<RequiredUserInfo> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registration")
	public void registerUser(@RequestBody IncomingRequestBody body) {
		userService.registerUser(body.getUser(), body.getName(), body.getSurname()); 
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	//@PreAuthorize("hasAuthority('ADMIN_USER')")
	public User userLogin(@RequestBody User user) {
		User u=userService.userLogin(user.getEmail(), user.getPassword()); 
		String token=jwtGenerator.generate(u);
		return jwtValidator.validate(token);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/{id}")
	public void updateUserInfo(@RequestBody User user, @PathVariable String id) {
		userService.updateUserInfo(user);
	}
	
	@RequestMapping (method=RequestMethod.POST, value="/changepassword/{id}")
	public void changePassword(@PathVariable Long id,@RequestBody User user) {
		userService.changePassword(user);
	}
	
	@RequestMapping("/user")
	public User findByEmail(String email){
		return userService.getUserByEmail(email);
	}
	
	@RequestMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		return userService.getUserById(id);
	}
	
}
