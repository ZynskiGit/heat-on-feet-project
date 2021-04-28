package com.example.springtemplate.footwears.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "footwears")
public class Footwear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean active;
    private Integer price;
    private String name;
    private String style;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "footwear")
    private List<Color> colors;

    @OneToMany(mappedBy = "footwear")
    private List<Brand> brands;

    @OneToMany(mappedBy = "footwear")
    private List<Material> materials;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
