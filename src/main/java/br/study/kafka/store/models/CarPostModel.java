package br.study.kafka.store.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "car_post")
@NoArgsConstructor
@Getter
@Setter
public class CarPostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "brand")
    private String brand;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;
    @Column(name = "engineVersion")
    private String engineVersion;
    @Column(name = "city")
    private String city;
    @Column(name = "createdDate")
    private String createdDate;
    @Column(name = "ownerId")
    private Long ownerId;
    @Column(name = "contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", referencedColumnName = "id", nullable = false)
    private OwnerPostModel ownerPostModel;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public OwnerPostModel getOwnerPostModel() {
        return ownerPostModel;
    }

    public void setOwnerPostModel(OwnerPostModel ownerPostModel) {
        this.ownerPostModel = ownerPostModel;
    }
}
