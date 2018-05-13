package org.bgadmin.system.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bgadmin.system.dao.UserDao;
import org.bgadmin.system.entity.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统主控制器
 * @author klw 20171122
 * */
@Controller
@RequestMapping("/sys")
public class SystemAction {

	@Autowired
	private UserDao userDao;

    
    @RequestMapping("/list")
    @ResponseBody
    public List<TestModel> list(TestModel t, HttpServletRequest request, HttpServletResponse response) {
    	
       return userDao.list(t);
    }
    
    //读取
    @RequestMapping("/load")
    @ResponseBody
    public TestModel load(HttpServletRequest request, HttpServletResponse response) {
    	
       TestModel tt= userDao.get("aa");
       return tt;
    }
    
  //增加
    @RequestMapping("/add")
    @ResponseBody
    public TestModel add(TestModel m, HttpServletRequest request, HttpServletResponse response) {
    	
       m.setUserName("丁伊雪");
       userDao.add(m);
       return m;
    }
    
    //删除
    @RequestMapping("/del")
    @ResponseBody
    public boolean del(TestModel t, HttpServletRequest request, HttpServletResponse response){
    	return userDao.del(t.getId());
    }
    
    //修改
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(TestModel t, HttpServletRequest request, HttpServletResponse response){
    	return userDao.update(t);
    }
}
