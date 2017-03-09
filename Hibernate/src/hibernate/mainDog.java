package hibernate;

import javax.persistence.*;
import java.security.acl.Owner;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class mainDog {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        Scanner input = new Scanner(System.in);

        String userInput;


        String action = null;
        while(action != "0") {
            System.out.println("\nWhat is your command?");
            System.out.println("1 - See list of dogs\n" +
                                "2 - Add a dog\n" +
                                "3 - See list owners and their dogs\n" +
                                "4 - Add an owner\n" +
                                "5 - Add an owner to a dog\n" +
                                "6 - Remove a dog\n" +
                                "7 - Remove an owner\n" +
                                "8 - Remove an owner from a dog\n" +
                                "0 - Quit\n");

            userInput = input.nextLine();
            switch(userInput){
                case "1":
                    selectDogs(emf);
                    break;

                case "2":
                    addDog(emf, input);
                    break;

                case "3":
                    listOwnerAndDogs(emf);
                    break;

                case "4":
                    addOwner(emf, input);
                    break;

                case "5":
                    addOwnerToDog(emf, input);
                    break;

                case "6":
                    removeDog(emf, input);
                    break;

                case "7":
                    removeOwner(emf, input);
                    break;

                case "8":
                    removeOwnerFromDog(emf, input);
                    break;

                case "0":
                    return;

                default:
                    break;
            }
        }


    }

    public static void selectDogs(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("All dogs found in our database:");

        List<dogEntity> dogE = em.createQuery("from dogEntity").getResultList();

        for (dogEntity temp : dogE) {
            System.out.println(temp.getColor() + " " + temp.getDateOfBirth() + " " + temp.getBreed() + " " + temp.getTemperment());
        }
        em.close();

    }

    public static void addDog(EntityManagerFactory emf, Scanner input){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Please enter dog information in the following format:");
        System.out.println("<color> <dateOfBirth> <breed> <temperment>");

        String[]userInput = input.nextLine().split(" ");

        dogEntity newdog = new dogEntity();

        newdog.setColor(userInput[0]);
        newdog.setdateOfBirth(Integer.parseInt(userInput[1]));
        newdog.setbreed(userInput[2]);
        newdog.settemperment(userInput[3]);

        em.persist(newdog);
        em.flush();
        em.getTransaction().commit();

        System.out.println("Dog Added");

        em.close();


    }

    public static void listOwnerAndDogs(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Owner \\ Color \\ dateOfBirth \\ Breed \\ Temperment");

        List<dogOwnerEntity> dogOwners = em.createQuery("from dogOwnerEntity ").getResultList();

        for (dogOwnerEntity dogOwner: dogOwners) {
            System.out.println(dogOwner.getOwnerEntity().getfName() + " " + dogOwner.getOwnerEntity().getlName() + "\t" + dogOwner.getDogEntity().getColor() +
                                " " + dogOwner.getDogEntity().getDateOfBirth() + " " + dogOwner.getDogEntity().getBreed() + " " + dogOwner.getDogEntity().getTemperment());
        }
        em.close();
    }

    public static void addOwner(EntityManagerFactory emf, Scanner input){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        System.out.println("Please enter the owner's first and last name:");

        String[] name = input.nextLine().split(" ");

        OwnerEntity newOwner = new OwnerEntity();

        newOwner.setfName(name[0]);
        newOwner.setlName(name[1]);

        em.persist(newOwner);
        em.flush();
        em.getTransaction().commit();

        System.out.println("Owner Added");

        em.close();
    }

    public static void addOwnerToDog(EntityManagerFactory emf, Scanner input){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Pick the an owner from the list:");

        List<OwnerEntity> ownerList = em.createQuery("from OwnerEntity ").getResultList();

        int count = 0;

        for (OwnerEntity temp : ownerList) {
            System.out.println(count + ". " +temp.getfName() + " " + temp.getlName());
            count++;
        }

        int ownerNum = input.nextInt();

        OwnerEntity newOwner = new OwnerEntity();

        newOwner = ownerList.get(ownerNum);

        List<dogEntity> dogList = em.createQuery("from dogEntity").getResultList();

        System.out.println("Pick the dog the onwer needs to be added to: ");

        count = 0;

        for (dogEntity temp : dogList) {
            System.out.println(count + ". " + temp.getColor() + " " + temp.getDateOfBirth() + " " + temp.getBreed() + " " + temp.getTemperment());
            count++;
        }

        int dogNum = input.nextInt();

        dogEntity ownerdog = new dogEntity();

        ownerdog = dogList.get(dogNum);

        dogOwnerEntity newdogOwnerEntity = new dogOwnerEntity();

        newdogOwnerEntity.setOwnerEntity(newOwner); 
        newdogOwnerEntity.setdogEntity(ownerdog);
        newdogOwnerEntity.setIsCurrentOwner(1);
        Date date = new Date();
        newdogOwnerEntity.setPurchaseDate(date.toString());
        newdogOwnerEntity.setidNumber("4sad65sa54dsa465da");

        em.persist(newdogOwnerEntity);
        em.flush();
        em.getTransaction().commit();

        System.out.println("This doggy now has a new owner.");
        em.close();
    }


    public static void  removeDog(EntityManagerFactory emf, Scanner input){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<dogEntity> dogList = em.createQuery("from dogEntity").getResultList();

        System.out.println("Pick the dog you don't really like anymore:");

        int count = 0;
        for (dogEntity temp : dogList) {
            System.out.println(count + ". " + temp.getColor() + " " + temp.getDateOfBirth() + " " + temp.getBreed() + " " + temp.getTemperment());
            count++;
        }

        int dogNum = input.nextInt();

        Query q = em.createQuery("delete dogOwnerEntity where dogEntity.id=:p").setParameter("p", dogList.get(dogNum).getId());

        Query query = em.createQuery(
                "DELETE dogEntity c WHERE c.id = :p").setParameter("p", dogList.get(dogNum).getId());

        q.executeUpdate();
        query.executeUpdate();

        em.getTransaction().commit();

        System.out.println("The dog has been removed!");
    }

    public static void  removeOwner(EntityManagerFactory emf, Scanner input){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<OwnerEntity> ownerList = em.createQuery("from OwnerEntity").getResultList();

        System.out.println("Please pick the owner you want to remove:");

        int count = 0;
        for (OwnerEntity temp : ownerList) {
            System.out.println(count + ". " + temp.getfName() + " " + temp.getlName());
            count++;
        }

        int ownerNum = input.nextInt();

        Query q = em.createQuery("delete dogOwnerEntity where ownerEntity.id=:p").setParameter("p", ownerList.get(ownerNum).getId());

        Query query = em.createQuery(
                "DELETE OwnerEntity c WHERE c.id = :p").setParameter("p", ownerList.get(ownerNum).getId());

        q.executeUpdate();
        query.executeUpdate();

        em.getTransaction().commit();

        System.out.println("The owner has been removed");

        em.close();
    }

    public static void  removeOwnerFromDog(EntityManagerFactory emf, Scanner input){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<OwnerEntity> ownerList = em.createQuery("from OwnerEntity").getResultList();

        System.out.println("Pick the owner:");

        int count = 0;

        for (OwnerEntity temp : ownerList) {
            System.out.println(count + ". " + temp.getfName() + " " + temp.getlName());
            count++;
        }

        int ownerNum = input.nextInt();

        System.out.println("Pick the dog you would like to remove the owner from:");

        count = 0;

        List<dogOwnerEntity> dogOwnerList = em.createQuery("from dogOwnerEntity WHERE ownerEntity.id=:p").setParameter("p",ownerList.get(ownerNum).getId()).getResultList();

        for (dogOwnerEntity temp : dogOwnerList) {
            System.out.println(count + ". " + temp.getDogEntity().getColor() + " " + temp.getDogEntity().getDateOfBirth() + " " + temp.getDogEntity().getBreed() + " " + temp.getDogEntity().getTemperment());
            count++;
        }

        int dogNum = input.nextInt();

        Query query = em.createQuery("delete dogOwnerEntity where ownerEntity.id=:p AND dogEntity.id=:q").setParameter("p", ownerList.get(ownerNum).getId()).setParameter("q", dogOwnerList.get(dogNum).getDogEntity().getId());

        query.executeUpdate();
        em.getTransaction().commit();

        System.out.println("The owner has been removed from that dog");
        em.close();
    }

}


@JoinTable(
        name="Customer",
        joinColumns =
                @JoinColumn(name="homeAddress", referencedColumnName = "id"),
        inverseJoinColumns =
                @JoinColumn(name="phoneNum", referencedColumnName = "id")
)