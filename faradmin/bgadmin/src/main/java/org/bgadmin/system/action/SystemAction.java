package org.bgadmin.system.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统主控制器
 * @author klw 20171122
 * */
@Controller
@RequestMapping("/sys")
public class SystemAction {

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "name", required = false, defaultValue = "Spring") String name) {
 
        ModelAndView mv = new ModelAndView("sys/login");//指定视图
        //mv.addObject("message", message);
        Map<String,String> map=new HashMap<String,String>();
        map.put("title", "admin Manger login");
        map.put("login", "login");
        mv.addObject("sys", map);
        mv.addObject("CREATE_HTML",false);
        return mv;
    }
    
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "name", required = false, defaultValue = "Spring") String name) {
 
        ModelAndView mv = new ModelAndView("sys/index");//指定视图
        //mv.addObject("message", message);
        Map<String,String> map=new HashMap<String,String>();
        map.put("title", "admin Manger login");
        map.put("login", "login");
        mv.addObject("sys", map);
        mv.addObject("CREATE_HTML",false);
        return mv;
    }
}
