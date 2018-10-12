package com.niit.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("HomeController  bean is created ");
	}

	@RequestMapping(value = "/home") // /home - KEY in Handler Map
	public String homePage() { // getHomePage() is the Value in Handler map

		return "homepage"; // logical view name
	}

	@RequestMapping(value = "/aboutus")
	public String aboutUs() {
		return "aboutus";
	}

	public static void main(String[] args) {
		System.out.println("Product Controller bean is created");
	}
}
