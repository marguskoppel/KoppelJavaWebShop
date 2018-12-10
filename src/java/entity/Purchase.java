
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    private Product product;
    @OneToOne
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBegin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReturn;
    
    private int quantity;
    private Long total;

    public Purchase() {
    }

    public Purchase(Product product, User user, Date dateBegin, Date dateReturn, int quantity) {
        this.product = product;
        this.user = user;
        this.dateBegin = dateBegin;
        this.dateReturn = dateReturn;
        this.quantity = quantity;
    }
    

    public Purchase(Product product, User user, Date dateBegin, Date dateReturn, int quantity, Long total) {
        this.product = product;
        this.user = user;
        this.dateBegin = dateBegin;
        this.dateReturn = dateReturn;
        this.quantity = quantity;
        this.total = total;
    }
    

   
    

    public Purchase(Long id, Product product, User user, Date dateBegin, Date dateReturn) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.dateBegin = dateBegin;
        this.dateReturn = dateReturn;
    }

    public Purchase(Product product, User user, Date dateBegin, Date dateReturn) {
        this.product = product;
        this.user = user;
        this.dateBegin = dateBegin;
        this.dateReturn = dateReturn;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.product);
        hash = 89 * hash + Objects.hashCode(this.user);
        hash = 89 * hash + Objects.hashCode(this.dateBegin);
        hash = 89 * hash + Objects.hashCode(this.dateReturn);
        hash = 89 * hash + this.quantity;
        hash = 89 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Purchase other = (Purchase) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.dateBegin, other.dateBegin)) {
            return false;
        }
        if (!Objects.equals(this.dateReturn, other.dateReturn)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }
    

    

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    

    @Override
    public String toString() {
        SimpleDateFormat sdm = new SimpleDateFormat("dd.mm.yyyy");
        if(dateReturn != null){
            return "Purchase{" + "id=" + id + ", book=" + product.getNameProduct() + ", user=" + user.getName()+" "+user.getSurname() + ", dateBegin=" + sdm.format(dateBegin) + ", dateReturn=" + sdm.format(dateReturn) + ", quantity=" + quantity + ", total=" + total + '}';
        }else{
            return "Purchase{" + "id=" + id + ", book=" + product.getNameProduct() + ", user=" + user.getName()+" "+user.getSurname() + ", dateBegin=" + sdm.format(dateBegin) + ", quantity=" + quantity + ", total=" + total + '}';
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    
    
    

    
    
}
