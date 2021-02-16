package ua.aser.carshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String brand;
    private String model;
    private String engineType;
    private double engineVolume;
    private double fuelConsumption;
    private double price;
    private int horsePower;
    private int cargoSpace;
    private int seats;
    private int length;
    private int width;
    private int height;
    private int clearance;
    private LocalDateTime dateReceiving;

    public Car() {
    }

    public Car(Long id, String brand, String model, String engineType, double engineVolume,
               double fuelConsumption, double price, int horsePower, int cargoSpace, int seats,
               int length, int width, int height, int clearance, LocalDateTime dateReceiving) {
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.engineVolume = engineVolume;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.horsePower = horsePower;
        this.cargoSpace = cargoSpace;
        this.seats = seats;
        this.length = length;
        this.width = width;
        this.height = height;
        this.clearance = clearance;
        this.dateReceiving = dateReceiving;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    public LocalDateTime getDateReceiving() {
        return dateReceiving;
    }

    public void setDateReceiving(LocalDateTime dateReceiving) {
        this.dateReceiving = dateReceiving;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", engineVolume=" + engineVolume +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", horsePower=" + horsePower +
                ", cargoSpace=" + cargoSpace +
                ", seats=" + seats +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", clearance=" + clearance +
                ", dateReceiving=" + dateReceiving +
                '}';
    }
}
