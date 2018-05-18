package com.umanav.loginreg.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.umanav.loginreg.models.Role;
import com.umanav.loginreg.models.User;
import com.umanav.loginreg.repositories.RoleRepository;
import com.umanav.loginreg.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }
    //4
	public Role findRoleByName(String name) {
		if (roleRepository.findByName(name).size() == 0) {
			return null;
		} else {
			return roleRepository.findByName(name).get(0);
		}
	}
	//5
	public User foundEmail(String email) {
		return userRepository.findOneByEmail(email);
	}
	//6
	public List<User> all(){
		return (List<User>) userRepository.findAll();
	}
	//7
	public void save(User user) {
		userRepository.save(user);
	}
	//8
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	//9 
	public User findWithId(Long id) {
		return userRepository.findById(id).get();
	}
}