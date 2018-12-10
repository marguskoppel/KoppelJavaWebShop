

package entity;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String nameProduct;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(precision = 8, scale = 2)
    private Long price;
    private int count;
    private Boolean active;
    private String image;
  

    public Product() {
    }

    public Product(String nameProduct, String description, Long price, int count, String image) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.count = count;
        this.image = image;
        this.active = true;
    }
    

    public Product(String nameProduct, String description, Long price, int count) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.count = count;
        this.active = true;
    }
    

    public Product(String nameProduct, String description, Long price, int count, Boolean active) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.price = price;
        this.count = count;
        this.active = active;
    }

    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nameProduct);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.price);
        hash = 79 * hash + this.count;
        hash = 79 * hash + Objects.hashCode(this.active);
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
        final Product other = (Product) obj;
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.nameProduct, other.nameProduct)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", nameProduct=" + nameProduct + ", description=" + description + ", price=" + price + ", count=" + count + ", active=" + active + '}';
    }

    

    

    
    

    
}
