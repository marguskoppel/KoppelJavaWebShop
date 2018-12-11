package session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import secure.Role;
import secure.UserRoles;

@Stateless
public class RoleFacade extends AbstractFacade<Role> {

    @PersistenceContext(unitName = "KoppelJavaWebShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }

    public Role findRoleByName(String name) {
        Role role = (Role) em.createQuery("SELECT r FROM Role r WHERE r.name=:name")
                .setParameter("name", name)
                .getSingleResult();
        return role;
    }

    public Role findRoleUser() {
        Role role = (Role) em.createQuery("SELECT r FROM Role r WHERE r.name = 'USER'")
                .getSingleResult();
        return role;

    }
    

    public List<Role> findAllExceptAdmin() {
        return em.createQuery("SELECT r FROM Role r WHERE r.name != 'ADMIN'")
                .getResultList();

    }

}
