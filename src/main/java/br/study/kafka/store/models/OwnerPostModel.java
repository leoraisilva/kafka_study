package br.study.kafka.store.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "owner_post")
@Entity
@Data
@NoArgsConstructor
public class OwnerPostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_type")
    private String ownerType;

    @Column(name = "owner_contact" )
    private String ownerContact;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }
}
