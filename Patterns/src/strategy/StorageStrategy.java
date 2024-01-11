package strategy;

public interface StorageStrategy {
    ListStorage read(String fileName);
    boolean write(Object obj, String fileName);
}
