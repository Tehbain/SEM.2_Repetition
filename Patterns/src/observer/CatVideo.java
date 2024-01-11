package observer;

import java.util.ArrayList;
import java.util.List;

public class CatVideo implements Observable {
    private String currentHost = "";
    private float elapsedRuntime = 0;
    private final List<Observer> observers = new ArrayList<>();

    public CatVideo(String currentHost) {
        this.currentHost = currentHost;
    }

    @Override
    public boolean addObserver(Observer observer) {
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers(float timeAdded) {
        for (Observer o : observers) {
            o.update(timeAdded);
        }
    }

    @Override
    public String toString() {
        return "CatVideo, hosted by " + currentHost + ". \n" +
                "Current audience: " + observers.toString() + ". \n" +
                "Runtime: " + elapsedRuntime;

    }

    public void play(String host) {
        currentHost = host;
        int timeAdded = 1;
        elapsedRuntime += timeAdded;
        notifyObservers(timeAdded);
    }
}
