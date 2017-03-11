package mvc;

public class Model {

    boolean isPal;

    public Model(){

    }

    public void isPal(String pal){
        isPal = pal.equals(new StringBuilder(pal).reverse().toString());
    }

    public boolean isPal() {
        return isPal;
    }

}
