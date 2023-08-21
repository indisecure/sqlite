package indi;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class HomeController {
@Autowired
private DAO dao;
private ModelAndView mv= new ModelAndView();
@GetMapping("/")
public ModelAndView get() {	
	mv.addObject("key", dao.findAll());
	mv.setViewName("index");
	return mv;
}
@RequestMapping("/model")
public ModelAndView getByModel(@RequestParam String model) {	
	List<Car> car=dao.findAll();
	List<Car> k=new ArrayList<>();
	for (Car c:car) {
		if(c.getModel().equalsIgnoreCase(model)) {
			k.add(c);
			 mv.addObject("key", c);
		}}	
	mv.setViewName("index");
	return mv;
}
@RequestMapping("/make")
public ModelAndView getByMake(@RequestParam String make) {	
	List<Car> car=dao.findAll();
	List<Car> k=new ArrayList<>();
	for (Car c:car) {
		if(c.getMake().equalsIgnoreCase(make)) {	
			k.add(c);
			mv.addObject("key", k);		
		}}	
	mv.setViewName("index");
	return mv;
}
@PostMapping("/save")
public ModelAndView saveData(Car car) {				
	dao.save(car);	
	mv.addObject("message", "Model and Make Saved");
	mv.setViewName("index");
	return mv;
}
}