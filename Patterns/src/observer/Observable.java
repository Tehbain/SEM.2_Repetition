package observer;

public interface Observable {

    public abstract boolean addObserver (Observer observer);
    public abstract boolean removeObserver (Observer observer);
    public abstract void notifyObservers(float timeAdded);

}
