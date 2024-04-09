package com.example.demo.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "sizesProduct")
public class SizeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UID;


    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 150, message="Длина значения должна быть в диапозоне от 4 до 150")
    private String sizeName;

    @OneToMany(mappedBy = "sizeProduct", fetch = FetchType.EAGER)
    public List<Product> product;

    public SizeProduct() {

    }

    public SizeProduct(String sizeName, List<Product> product) {
        this.sizeName = sizeName;
        this.product = product;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
