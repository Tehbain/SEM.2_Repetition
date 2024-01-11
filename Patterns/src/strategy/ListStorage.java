package strategy;

//import controller.Storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Serializable, Storage {

    private StorageStrategy strategy = new StoreSerialized(); // Default Storage Behavior
    private final List<? extends Runnable> runnables = new ArrayList<>();
    //Sekundær type ---------------------------------- Primær type

    //Strategy
    public void setStrategy(StorageStrategy strategy) {
        this.strategy = strategy;
    }

    //Persistence
    public ListStorage read(String s) {
        return strategy.read(s);
    }
    public boolean write(Storage storage, String s) {
        return strategy.write(storage, s);
    }


    //Gets & Reads

}
