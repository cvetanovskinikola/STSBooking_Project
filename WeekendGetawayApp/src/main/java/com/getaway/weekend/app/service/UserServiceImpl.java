package com.getaway.weekend.app.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.getaway.weekend.app.dto.UserRegistrationDto;
import com.getaway.weekend.app.entity.Role;
import com.getaway.weekend.app.entity.User;
import com.getaway.weekend.app.repository.RoleRepo;
import com.getaway.weekend.app.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService{
	
	
	private UserRepo userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired RoleRepo roleRepo;
	
	public UserServiceImpl(UserRepo userRepository) {
		super();
		this.userRepository = userRepository;
	}

    @Override
	public User saveUser(UserRegistrationDto registrationDto) {
    	
    	Set<Role> roles = new HashSet<>();
    	//Role role_admin = new Role("ROLE_ADMIN");
		Role role_user = roleRepo.findByRole("USER");
		roles.add(role_user);
		//roles.add(role_admin);

		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(), registrationDto.getAge()
				,registrationDto.getCredit_card(),300.0,registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), roles);
		return userRepository.save(user);
	}
    public User updateUserFunds(User user) {
    	return userRepository.save(user);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
}
