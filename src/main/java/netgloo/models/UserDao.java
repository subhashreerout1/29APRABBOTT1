package netgloo.models;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(User user) {
    getSession().save(user);
    return;
  }
  
  public void delete(User user) {
    getSession().delete(user);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Category> getAll() {
	  
	  
	  List<Category> list = new ArrayList<Category>();
		try {
			Query query = getSession().createQuery(
					"select  cat_ID, category_Desc FROM " + "Category");
			list = query.list();

		} catch (Exception e) {
			   System.out.println("list"+list);
		}
    return list;
  }
  
  public User getByEmail(String email) {
    return (User) getSession().createQuery(
        "from User where email = :email")
        .setParameter("email", email)
        .uniqueResult();
  }

  public User getById(long id) {
    return (User) getSession().load(User.class, id);
  }

  public void update(User user) {
    getSession().update(user);
    return;
  }

} // class UserDao
