package com.example.kkalanhw2.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORY")
public class Category  implements Serializable {

    public Category(Long id, String name, Long level, Category parentLevel) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.parentLevel = parentLevel;
    }

    public Category() {
    }

    @SequenceGenerator(name = "generator", sequenceName = "KATEGORI_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "LEVEL")
    private Long level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PARENT_LEVEL")
    private Category parentLevel;

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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Category getParentLevel() {
        return parentLevel;
    }

    public void setParentLevel(Category parentLevel) {
        this.parentLevel = parentLevel;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
