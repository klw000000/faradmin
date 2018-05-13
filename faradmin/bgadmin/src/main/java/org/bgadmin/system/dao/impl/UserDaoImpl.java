package org.bgadmin.system.dao.impl;

import java.util.List;

import org.bgadmin.system.dao.UserDao;
import org.bgadmin.system.entity.TestModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;  
    
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
	@Override
	public TestModel get(String id) {
		String hql = "from TestModel u where u.id=?";  
        Query query = sessionFactory.openSession().createQuery(hql);//此时使用的是hql语句  
        query.setString(0, id);  
        return (TestModel) query.uniqueResult();  
	}
	@Override
	public String add(TestModel t) {
		Session s=sessionFactory.openSession();
		String id= (String)s.save(t);
		s.flush();
		return id;
	}
	@Override
	public boolean del(String id) {
		Session s=sessionFactory.openSession();
		String hql = "delete TestModel u where u.id=?";  
        Query query = s.createQuery(hql);  
        query.setString(0,id);  
        boolean res= (query.executeUpdate() > 0);  
        s.flush();
        return res;
	}
	@Override
	public boolean update(TestModel t) {
		Session s=sessionFactory.openSession();
		String hql = "update TestModel u set u.userName=? where u.id=?";  
        Query query = s.createQuery(hql);  
        query.setString(0, t.getUserName());  
        query.setString(1, t.getId());  
        boolean res=(query.executeUpdate() > 0);  
        s.flush();
        return res;
	}
	@Override
	public List<TestModel> list(TestModel t) {
		String hql = "from TestModel"; //此处可以添加删选条件 
        Query query = sessionFactory.openSession().createQuery(hql);  
          
        return query.list();  
	}  

 
  
}  