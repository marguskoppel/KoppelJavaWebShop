
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import secure.Role;


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
    public Role findRoleByName(String name){
        Role role = (Role) em.createQuery("SELECT r FROM Role r WHERE r.name=:name")
                .setParameter("name", name)
                .getSingleResult();
        return role;
    }
}
