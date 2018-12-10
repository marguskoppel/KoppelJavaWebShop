
package session;

import entity.Product;
import entity.Purchase;
import entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PurchaseFacade extends AbstractFacade<Purchase> {

    @EJB ProductFacade productFacade;
    

    @PersistenceContext(unitName = "KoppelJavaWebShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseFacade() {
        super(Purchase.class);
    }
    
    public List<Purchase> findBoughtProducts(){
        return em.createQuery("SELECT p FROM Purchase p WHERE p.dateReturn=NULL")
                .getResultList();
    }
    
    public List<Purchase> find(Product product){
        return em.createQuery("SELECT p FROM Purchase p WHERE p.product = :product")
                .setParameter("product", product)
                .getResultList();
    }
    public List<Purchase> findUserById(Object id){
        return em.createQuery("SELECT u FROM Purchase u WHERE u.user.id = :id")
                .setParameter("id", id)
                .getResultList();
    }
    
    
    
}
