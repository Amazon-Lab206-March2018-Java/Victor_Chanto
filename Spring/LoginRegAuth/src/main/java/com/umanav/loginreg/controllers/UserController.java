package com.umanav.loginreg.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umanav.loginreg.models.Role;
import com.umanav.loginreg.models.User;
import com.umanav.loginreg.services.UserService;
import com.umanav.loginreg.validator.UserValidator;

@Controller
public class UserController {
    private UserService userService;
    private UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user, 
    		BindingResult result) {
        return "index.jsp";
    }
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, 
    		BindingResult result, Model model, 
    		HttpSession session,
    		HttpServletRequest request) {
    	userValidator.validate(user, result);
        if (result.hasErrors() || userService.foundEmail(user.getEmail()) != null) { // validates that the email is not in the DB
    	   if(userService.foundEmail(user.getEmail()) != null) { // adds the error message
    		   result.rejectValue("email", "error.user", "An account already exists for this email.");
    	   }
            return "index.jsp";
        }
        if (userService.findRoleByName("ROLE_ADMIN").getUsers().size() == 0) {
        	userService.saveUserWithAdminRole(user);
		} 
		userService.saveWithUserRole(user);
		try {
			request.login(user.getEmail(), user.getPasswordConfirmation());
		} catch (ServletException e) {
			System.out.println("IT DID NOT WORK :C");
		}
        return "redirect:/";
    }
    
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, BindingResult result,
    		@RequestParam(value="error", required=false) String error, 
    		@RequestParam(value="logout", required=false) String logout,
    		Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "index.jsp";
    }
    //handler
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("admin_role", userService.findRoleByName("ROLE_ADMIN"));
        return "homePage.jsp";
    }
    //handler for admin role
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("all_Users", userService.all());
        model.addAttribute("adminRole", userService.findRoleByName("ROLE_ADMIN"));
        return "adminPage.jsp";
    }
    @RequestMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
    	userService.deleteById(id);
    	return "redirect:/admin";
    }
    
    @RequestMapping("/admin/mkAdmin/{id}")
    public String mkAdmin(@PathVariable("id") Long id) {
    	User user = userService.findWithId(id);
    	List<Role> roles = user.getRoles();
    	roles.clear();
    	roles.add(userService.findRoleByName("ROLE_ADMIN"));
    	user.setRoles(roles);
    	userService.save(user);
    	return "redirect:/admin";
    }

}