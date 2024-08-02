package Framework;

public class PatException extends Exception {

    public PatException (String e, String clase, String metodo){
        System.out.println("[Error ]" + clase + "."+ metodo + ":" + e);
    }

}
