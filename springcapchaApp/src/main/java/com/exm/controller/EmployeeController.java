package com.exm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exm.captcha.CaptchaUtils;
import com.exm.model.Employee;
import com.exm.service.IEmployeeService;

import cn.apiclub.captcha.Captcha;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	private void setupCaptcha(Employee e) {
		Captcha captcha = CaptchaUtils.createCaptcha(200, 50);//This line generates a new CAPTCHA image using the CaptchaUtils.createCaptcha method
		e.setHidden(captcha.getAnswer());//This line sets the "hidden" attribute of the Employee object (e) with the answer to the CAPTCHA. The answer is what the user needs to provide to pass the CAPTCHA challenge.
		e.setCaptcha("");//used to store the user's input for the CAPTCHA challenge, allowing you to compare it with the actual answer later.
		e.setImage(CaptchaUtils.encodeBase64(captcha));
		//This line encodes the generated CAPTCHA image as a base64-encoded string and sets it as the "image" attribute of the Employee object. Storing the CAPTCHA image as base64 allows you to include it directly in your HTML or responses
	}

	@GetMapping("/register")
	public String showRegister(Model model) {//This method takes a Model object as a parameter, which is used to pass data from the controller to the view
		Employee e  = new Employee();//instance of the Employee class is created
		setupCaptcha(e);//This sets up the CAPTCHA challenge for this employee, including generating the CAPTCHA image and storing the answer.
		model.addAttribute("employee", e);//The Employee object is added to the model with the attribute name "employee". This makes the Employee object available to the view, allowing you to access its properties.

		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String saveEmployee(
			@ModelAttribute("employee") Employee employee,Model model) // This method takes two parameters. The @ModelAttribute annotation binds the submitted form data to an Employee object. The Model object is used to pass data from the controller to the view.
	{
		String page="";// A string variable page is declared to store the name of the view to redirect to.
		if(employee.getCaptcha().equals(employee.getHidden()))//This condition checks if the value entered by the user for the CAPTCHA challenge (in the employee object) matches the hidden answer stored in the employee object. If the CAPTCHA is successfully validated, the following actions are taken:
		{
			service.createEmployee(employee);
			page ="redirect:all";
		} else {
			setupCaptcha(employee);
			return "EmployeeRegister";
		}
		return page;
	}

	@GetMapping("/all")
	public String getAllEmployees(Model model) 
	{
		model.addAttribute("list", service.getAllEmployees());
		return "EmployeeData";
	}


	@GetMapping("/edit/{id}")
	public String editEmployees(@PathVariable Integer id,Model model) //This method takes two parameters. The @PathVariable annotation binds the value of the "id" variable from the URL to the id parameter. The Model object is used to pass data from the controller to the view.
	{
		String page = null;
		Optional<Employee> opt = service.getOneEmployee(id);
		if(opt.isPresent()) {// If the employee exists, the following actions are taken:
			Employee e = opt.get(); //The employee object is extracted from the Optional
			setupCaptcha(e);
			model.addAttribute("employee", e);//: The employee object is added to the model with the attribute name "employee". This makes the employee's data available to the view for pre-filling the form fields.
			page = "EmployeeRegister";//The page variable is set to the view name "EmployeeRegister". This likely indicates that the form for editing employee information should be displayed.
		}else {
			page ="redirect:all";
		}

		return page;
	}
}
