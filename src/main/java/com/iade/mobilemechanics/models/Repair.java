package com.iade.mobilemechanics.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="repairs")
public class Repair {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_id", nullable = false)
    private Integer id;

    @Column(name = "repair_date", nullable = false)
    private LocalDate repairDate;

    @Column(name = "repair_price", length = 69)
    private String repairPrice;

    @ManyToOne
    @JoinColumn(name = "repair_mechanic_id")
    private Mechanic repairMechanic;

    @ManyToOne
    @JoinColumn(name = "repair_car_id")
    private Car repairCar;

    public Car getRepairCar() {
        return repairCar;
    }

    public void setRepairCar(Car repairCar) {
        this.repairCar = repairCar;
    }

    public Mechanic getRepairMechanic() {
        return repairMechanic;
    }

    public void setRepairMechanic(Mechanic repairMechanic) {
        this.repairMechanic = repairMechanic;
    }

    public String getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(String repairPrice) {
        this.repairPrice = repairPrice;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
