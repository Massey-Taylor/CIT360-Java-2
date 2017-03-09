package hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dog", schema = "hibernate", catalog = "")
public class dogEntity {

    private String breed;
    private String temperment;
    private int dateOfBirth;
    private String color;
    private String idNumber;

    @Id
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "dogEntity")
    private List<dogOwnerEntity> dogOwnerEntity;

    public List<dogOwnerEntity> getdogOwnerEntity() {
        return dogOwnerEntity;
    }

    public void setdogOwnerEntity(List<dogOwnerEntity> dogOwnerEntity) {
        this.dogOwnerEntity = dogOwnerEntity;
    }

    @Basic
    @Column(name = "breed")
    public String getBreed() {
        return breed;
    }

    public void setbreed(String breed) {
        this.breed = breed;
    }

    @Basic
    @Column(name = "temperment")
    public String getTemperment() {
        return temperment;
    }

    public void settemperment(String temperment) {
        this.temperment = temperment;
    }

    @Basic
    @Column(name = "dateOfBirth")
    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "idNumber")
    public String getidNumber() {
        return idNumber;
    }

    public void setidNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        dogEntity dogEntity = (dogEntity) o;

        if (id != dogEntity.id) return false;
        if (dateOfBirth != dogEntity.dateOfBirth) return false;
        if (breed != null ? !breed.equals(dogEntity.breed) : dogEntity.breed != null) return false;
        if (temperment != null ? !temperment.equals(dogEntity.temperment) : dogEntity.temperment != null) return false;
        if (color != null ? !color.equals(dogEntity.color) : dogEntity.color != null) return false;
        if (idNumber != null ? !idNumber.equals(dogEntity.idNumber) : dogEntity.idNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        result = 31 * result + (temperment != null ? temperment.hashCode() : 0);
        result = 31 * result + dateOfBirth;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        return result;
    }
}


