package observer;

public class Audience implements Observer{

    private String name = "";
    private float totalTimeWatched = 0;

    public Audience(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + totalTimeWatched;
    }

    @Override
    public void update(float timeAdded) {
        totalTimeWatched += timeAdded;
    }
}
