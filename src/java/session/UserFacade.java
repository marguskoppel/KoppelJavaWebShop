
package session;

import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "KoppelJavaWebShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    public User findByLogin(String login) {
        try {
            return (User) em.createQuery("SELECT u FROM User u WHERE u.login = :login")
                .setParameter("login", login)
                .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<User> findAllExceptAdmin(){
        return em.createQuery("SELECT u FROM User u WHERE u.login != 'admin'")
                .getResultList();
}
    
  
    
    public List<User> findActivedExceptAdmin(boolean status) {
        try {
            return em.createQuery("SELECT b FROM User b WHERE b.status = :status AND b.login !='admin'")
                .setParameter("status", status)
                .getResultList();
        } catch (Exception e) {
            return null;
        }
        
    }
}