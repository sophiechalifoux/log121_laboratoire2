import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();
    
    public void notifier(){
        for (Observer observer : observers) {
            observer.update();
        }}
    public void attacher(Observer observer){observers.add(observer);}
    public void detacher(Observer observer){observers.remove(observer);}
    
}
