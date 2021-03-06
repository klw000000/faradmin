package org.bgadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class HelloSpringController {
    String message = "Welcome to Spring MVC!";
 
    @RequestMapping("/hello")
    public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "Spring") String name) {
 
        ModelAndView mv = new ModelAndView("sys/index");//指定视图
        mv.addObject("message", message);
        mv.addObject("name", name);
        mv.addObject("CREATE_HTML",false);
        return mv;
    }
}