package strategy;

import java.io.Serializable;

public class StoreJBDC implements StorageStrategy, Serializable {
    @Override
    public ListStorage read(String fileName) {
        throw new RuntimeException("You're not supposed to be here");
    }

    @Override
    public boolean write(Object obj, String fileName) {
        return false;
    }

    @Override
    public String toString() {
        return "MySQL";
    }
}
