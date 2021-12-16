package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="prices")
public class Price {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id", nullable = false)
    private Integer id;

    @Column(name = "price_model_id")
    private Integer priceModelId;

    @ManyToOne
    @JoinColumn(name = "price_type_repair_id")
    private TypeRepair priceTypeRepair;

    @Column(name = "price_price")
    private Double pricePrice;

    public Double getPricePrice() {
        return pricePrice;
    }

    public void setPricePrice(Double pricePrice) {
        this.pricePrice = pricePrice;
    }

    public TypeRepair getPriceTypeRepair() {
        return priceTypeRepair;
    }

    public void setPriceTypeRepair(TypeRepair priceTypeRepair) {
        this.priceTypeRepair = priceTypeRepair;
    }

    public Integer getPriceModelId() {
        return priceModelId;
    }

    public void setPriceModelId(Integer priceModelId) {
        this.priceModelId = priceModelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
