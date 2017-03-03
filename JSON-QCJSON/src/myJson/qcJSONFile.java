package myJson;


import json.JSONException;
import json.JSONInputStream;
import json.JSONOutputStream;
import json.JSONUtilities;

import java.io.*;
import java.util.*;

public class qcJSONFile {
    public static void main(String[] args) {
        JSONPets lily = new JSONPets("lily", "Pug", "10 lbs", "02/2012");

        try {
            String jUtilities = JSONUtilities.stringify(lily);
            System.out.println(jUtilities);
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        JSONPets osiris = new JSONPets("osiris", "Pug", "5 lbs", "03/2014");

        File petFile = new File("petFile.json");

        try {
            FileOutputStream fileOutput = new FileOutputStream(petFile);
            JSONOutputStream jsonOutput = new JSONOutputStream(fileOutput);
            jsonOutput.writeObject(osiris);
            jsonOutput.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInput = new FileInputStream(petFile);
            JSONInputStream jsonInput = new JSONInputStream(fileInput);

            HashMap myMap = (HashMap)jsonInput.readObject();
            jsonInput.close();

            JSONPets osiris2 = new JSONPets();
            osiris2.setName((String)myMap.get("name"));
            osiris2.setBreed((String)myMap.get("breed"));
            osiris2.setWeight((String)myMap.get("weight"));
            osiris2.setBirthDate((String)myMap.get("birthDate"));

            String pet2 =  JSONUtilities.stringify(osiris2);
            System.out.println(pet2);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        /* Nasty paths start here*/
        try {
            FileInputStream fileInput = new FileInputStream("noPermission.json");
            JSONInputStream jsonInput = new JSONInputStream(fileInput);

            jsonInput.close();

        }
        catch(Exception e)
        {
            System.out.println("You can't read the file without permission, silly!");
        }

        try {

            FileOutputStream fileOutput = new FileOutputStream("noWrite.json");
            JSONOutputStream jsonOutput = new JSONOutputStream(fileOutput);
            jsonOutput.writeObject(osiris);
            jsonOutput.close();

        }
        catch(Exception e)
        {
            System.out.println("You can't write to the file wihout permission, silly!");
        }

        try {
            FileInputStream fileInput = new FileInputStream("nullText.txt");
            JSONInputStream jsonInput = new JSONInputStream(fileInput);

            HashMap myMap = (HashMap)jsonInput.readObject();
            jsonInput.close();


        }
        catch(Exception e)
        {
            System.out.println("You can't read an empty file, silly!");
        }

    }
}

