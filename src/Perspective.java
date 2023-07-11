public class Perspective {

    public static Perspective instance;

    public Perspective(){

        if(instance == null){

            instance = new Perspective();

        }
    }
    
}
