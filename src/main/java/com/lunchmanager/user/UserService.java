package com.lunchmanager.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lunchmanager.customer.Customer;
import com.lunchmanager.customer.CustomerService;
import com.lunchmanager.restaurant.Restaurant;
import com.lunchmanager.restaurant.RestaurantService;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<RequiredUserInfo> getAllUsers(){
//		List<User> users= new ArrayList<>();
//		userRepository.findAllProjetedBy()
//		.forEach(users::add);
		return userRepository.findAllProjetedBy();
	}
	
	public Optional<User> getUser(Long id){
		return userRepository.findById(id);
	}
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private CustomerService customerService;

	//@Override
	public void registerUser(User user, String name, String surname){
		if(!user.getPassword().equals(user.getPasswordConfirm())) {
			System.out.println("Lozinke nisu iste!");
		}
		else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setPasswordConfirm(passwordEncoder.encode(user.getPasswordConfirm()));
			userRepository.save(user);
			
			if(user.getRole().equals("Restaurant")) {
				Restaurant restaurant= new Restaurant(user.getId(), name);
				restaurantService.addRestaurant(restaurant);
				
			}
			else {
				Customer customer=new Customer(user.getId(), name, surname);
				customerService.addCustomer(customer);
			}
		}
	}
		
	public void updateUserInfo(User user) {
		userRepository.save(user);
	}
	
	public User userLogin(String email, String password) {
		String dbPassword=(userRepository.findByEmail(email)).getPassword();  //dbPassword-password from database
		if(passwordEncoder.matches(password, dbPassword)) {
			return userRepository.findByEmail(email);
	}
		else
			return null;
	}
	
	public void changePassword(User user) {
		User oldUser= userRepository.findUserById(user.getId());
		String dbPassword=oldUser.getPassword();  //dbPassword-password from database
		if(passwordEncoder.matches(user.getPassword(), dbPassword)) {
			oldUser.setPassword(passwordEncoder.encode(user.getPasswordConfirm()));
			oldUser.setPasswordConfirm(passwordEncoder.encode(user.getPasswordConfirm()));
			userRepository.save(oldUser);
		}
	}
	
	public User getUserByEmail( String email ){
		return userRepository.findByEmail(email);
	}
	
	public User getUserById( Long id) {
		return userRepository.findUserById(id);
	}
	
}
