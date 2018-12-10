
package session;

import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "KoppelJavaWebShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public Product findById(String id) {
        try {
            return (Product) em.createQuery("SELECT p FROM Product p WHERE p.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    

    public List<Product> findActived(boolean active) {
        try {
            return em.createQuery("SELECT b FROM Product b WHERE b.active = :active")
                .setParameter("active", active)
                .getResultList();
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
}
