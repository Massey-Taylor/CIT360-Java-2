package myJson;

import java.io.Serializable;

public class JSONPets implements Serializable {

    private String name;
    private String breed;
    private String weight;
    private String birthDate;

    public JSONPets(){}

    public JSONPets(String name, String breed, String weight, String birthDate)
    {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
