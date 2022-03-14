package repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.code.entities.User;


@Component
public class AdminRepositoryImp implements IntAdminRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public boolean checkAdmin(String email, String password) {
		User user = new User();
		Session session=sessionFactory.getCurrentSession();
		user = (User) session.createQuery("SELECT * FROM user WHERE email ="+email);
		if(user!= null) {
			return true;
		}
		return false;
	}

}
