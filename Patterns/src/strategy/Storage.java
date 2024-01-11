package strategy;

import java.util.List;

public interface Storage {

    // CRUDs

    boolean write(Storage storage, String s);

    Storage read(String s);

    void setStrategy(StorageStrategy strategy);
}
