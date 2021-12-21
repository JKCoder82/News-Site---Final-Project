package claim.newssite.controllers;

import claim.newssite.entities.User;
import claim.newssite.repositories.UserRepository;
import org.slf4j.LoggerFactory; // To help reduce runtime problems.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger; // To help reduce runtime problems.

// *Note: Attempting to implement a Registration page somewhat similar to what can be seen
// here ===> https://dzone.com/articles/spring-mvc-example-for-user-registration-and-login-1  


@Controller
@SessionAttributes("user")
public class UserController { 
	
	
	//Note: I added the following code below.....
	// Got this idea here: https://stackoverflow.com/questions/33779127/loggerfactory-getloggerclassname-class-vs-loggerfactory-getloggerthis-getclas

	public static final Logger LOG = LoggerFactory.getLogger(UserController.class); 
	
	
	
        @Autowired
        UserRepository userRepository;

        @GetMapping(value="register")
        public ModelAndView getRegisterPage() {
            ModelAndView registerPage = new ModelAndView("register");
            registerPage.addObject("user",new User());
            return registerPage;
        }

        // Problem here with saving user info, and getting error message when trying to 
        // Register new users. 
        @PostMapping(value="register")
        public String postRegister(@ModelAttribute("user") User user) {
            ModelAndView postRegisterPage = new ModelAndView("blogs");
            User newUser = new User();
            newUser.setEmail(newUser.getEmail());
            newUser.setPassword(newUser.getPassword());
            userRepository.save(newUser);
            postRegisterPage.addObject("user",newUser);
            LOG.info("User saved!"); 
              
            return "redirect:/blogs/createblogs";
        }
}

