package org.studyeasy.spring;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.studyeasy.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.studyeasy.spring.DAO.AppDAO;
import org.studyeasy.spring.DAO.AppDAOImple;
import org.studyeasy.spring.config.AppConfig;

@Controller
public class AppController {

	@RequestMapping("/")
	public ModelAndView homePage() {
		System.out.println("Started");

		ModelAndView model = new ModelAndView("index");
		List<User> users =  new ArrayList<User>();
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/org/studyeasy/spring/DAO/Spring-AppDAO.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Started_2");
		AppDAO DAO = context.getBean("DAOBean",AppDAO.class);
		users = DAO.listUsers();
		System.out.println("Output");
		System.out.println(users.size());
		model.addObject("users",users);
		
		return model;
	}
	@RequestMapping("/addUser")
	public String addUser(Model model,@Valid User user,BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "addUser";
		}
		else {
			if(user.getName()!=null && user.getEmail()!=null) {
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
				
				AppDAO DAO = context.getBean("DAOBean",AppDAOImple.class);
				DAO.addUser(user);
				context.close();
				
				return "forward:/";
			}else {
				return "addUser";
			}
			
		}
		
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
}