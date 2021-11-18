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

    @Column(name = "price_type_repair_id")
    private Integer priceTypeRepairId;

    @Column(name = "price_price")
    private Double pricePrice;

    public Double getPricePrice() {
        return pricePrice;
    }

    public void setPricePrice(Double pricePrice) {
        this.pricePrice = pricePrice;
    }

    public Integer getPriceTypeRepairId() {
        return priceTypeRepairId;
    }

    public void setPriceTypeRepairId(Integer priceTypeRepairId) {
        this.priceTypeRepairId = priceTypeRepairId;
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

}
