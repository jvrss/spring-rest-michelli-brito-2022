package com.api.springrest.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;

    @Column(nullable = false, length = 70)
    private String brandCar;

    @Column(nullable = false, length = 70)
    private String modelCar;

    @Column(nullable = false, length = 70)
    private String colorCar;

    @Column(nullable = false)
    private LocalDateTime resgistrationDate;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String apartment;

    @Column(nullable = false, length = 30)
    private String block;

    public ParkingSpotModel() {
    }

    public ParkingSpotModel(UUID id, String parkingSpotNumber, String licensePlateCar, String brandCar, String modelCar, String colorCar, LocalDateTime resgistrationDate, String responsibleName, String apartment, String block) {
        this.id = id;
        this.parkingSpotNumber = parkingSpotNumber;
        this.licensePlateCar = licensePlateCar;
        this.brandCar = brandCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.resgistrationDate = resgistrationDate;
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpotModel that = (ParkingSpotModel) o;
        return Objects.equals(id, that.id) && Objects.equals(parkingSpotNumber, that.parkingSpotNumber) && Objects.equals(licensePlateCar, that.licensePlateCar) && Objects.equals(brandCar, that.brandCar) && Objects.equals(modelCar, that.modelCar) && Objects.equals(colorCar, that.colorCar) && Objects.equals(resgistrationDate, that.resgistrationDate) && Objects.equals(responsibleName, that.responsibleName) && Objects.equals(apartment, that.apartment) && Objects.equals(block, that.block);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parkingSpotNumber, licensePlateCar, brandCar, modelCar, colorCar, resgistrationDate, responsibleName, apartment, block);
    }

    @Override
    public String toString() {
        return "ParkingSpotModel{" +
                "id=" + id +
                ", parkingSpotNumber='" + parkingSpotNumber + '\'' +
                ", licensePlateCar='" + licensePlateCar + '\'' +
                ", brandCar='" + brandCar + '\'' +
                ", modelCar='" + modelCar + '\'' +
                ", colorCar='" + colorCar + '\'' +
                ", resgistrationDate=" + resgistrationDate +
                ", responsibleName='" + responsibleName + '\'' +
                ", apartment='" + apartment + '\'' +
                ", block='" + block + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public LocalDateTime getResgistrationDate() {
        return resgistrationDate;
    }

    public void setResgistrationDate(LocalDateTime resgistrationDate) {
        this.resgistrationDate = resgistrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
