package com.example.demo.Models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UID;

    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 150, message="Длина значения должна быть в диапозоне от 4 до 150")
    private String productName;

    @NotNull(message = "Данное поле не должно быть пустым")
    @Min(value = 200, message = "Укажите год не ниже 1")
    @Max(value = 50000, message = "Укажитегод не выше 2024")
    private Integer productPrice;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    public TypeProduct typeProduct;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    public SizeProduct sizeProduct;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    public ColorProduct colorProduct;

    @OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
    public Set<Delivery> delivery = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    public Set<Order> order = new HashSet<>();

    public Product() {

    }

    public Product(String productName, Integer productPrice, TypeProduct typeProduct, SizeProduct sizeProduct, ColorProduct colorProduct, Set<Delivery> delivery, Set<Order> order) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.typeProduct = typeProduct;
        this.sizeProduct = sizeProduct;
        this.colorProduct = colorProduct;
        this.delivery = delivery;
        this.order = order;
    }

    public Set<Delivery> getDelivery() {
        return delivery;
    }

    public void setDelivery(Set<Delivery> delivery) {
        this.delivery = delivery;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public SizeProduct getSizeProduct() {
        return sizeProduct;
    }

    public void setSizeProduct(SizeProduct sizeProduct) {
        this.sizeProduct = sizeProduct;
    }

    public ColorProduct getColorProduct() {
        return colorProduct;
    }

    public void setColorProduct(ColorProduct colorProduct) {
        this.colorProduct = colorProduct;
    }
}
