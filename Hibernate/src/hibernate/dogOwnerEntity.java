package hibernate;

import javax.persistence.*;

/**
 * Created by gvh57 on 10/24/2016.
 */
@Entity
@Table(name = "dog_owner", schema = "hibernate", catalog = "")
public class dogOwnerEntity {

    private String idNumber;
    private String purchaseDate;
    private int currentOwner;

    @Id
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dog_id")
    private dogEntity dogEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private OwnerEntity ownerEntity;

    public dogEntity getDogEntity() {
        return dogEntity;
    }

    public void setdogEntity(dogEntity dogEntity) {
        this.dogEntity = dogEntity;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }

    @Basic
    @Column(name = "idNumber")
    public String getidNumber() {
        return idNumber;
    }

    public void setidNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "purchaseDate")
    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Basic
    @Column(name = "currentOwner")
    public int getIsCurrentOwner() {
        return currentOwner;
    }

    public void setIsCurrentOwner(int isCurrentOwner) {
        this.currentOwner = isCurrentOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        dogOwnerEntity that = (dogOwnerEntity) o;

        if (id != that.id) return false;
        if (currentOwner != that.currentOwner) return false;
        if (idNumber != null ? !idNumber.equals(that.idNumber) : that.idNumber != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + currentOwner;
        return result;
    }
}


