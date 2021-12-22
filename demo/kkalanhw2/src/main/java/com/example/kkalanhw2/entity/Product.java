package com.example.kkalanhw2.entity;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * id
 * adi
 * fiyat
 * kayitTarihi
 * KategoriId
 */
@Entity
@Table(
        name = "URUN"
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "category"})
@JsonFilter("ProductFilter")
public class Product implements Serializable {

    public static final String ENTITY_NAME = "Product";

    @SequenceGenerator(name = "generator", sequenceName = "URUN_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(length = 50, name = "ADI")
    private String name;

    @Column(name = "FIYAT" , precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "KAYIT_TARIHI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KATEGORI",
            foreignKey = @ForeignKey(name = "FK_URUN_KATEGORI_ID")
    )
    private Category category;



    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, Date recordDate, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.recordDate = recordDate;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date kayitTarihi) {
        this.recordDate = kayitTarihi;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category kategori) {
        this.category = kategori;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
