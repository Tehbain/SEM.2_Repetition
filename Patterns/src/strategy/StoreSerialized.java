package strategy;

import java.io.*;

public class StoreSerialized implements StorageStrategy, Serializable {

    /**
     * Reads/deserializes file on path fileName to restore
     * system content to a last known written state.
     * PRE: Object toRead must be of Storage.class
     */
    @Override
    public ListStorage read(String fileName) {
        ListStorage listStorage;

        try (FileInputStream fileIN = new FileInputStream(fileName);
             ObjectInputStream objIN = new ObjectInputStream(fileIN)
        ) {
            Object obj = objIN.readObject();
            listStorage = (ListStorage) obj;
            return listStorage;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserializing Storage:");
            System.out.println(ex);

        }
        throw new RuntimeException("Read failed");
    }

    /**
     * Checks if object is of Storage.class. Tries to write
     * file on path fileName. Returns the outcome.
     * @Precondition  Object toWrite must be of Storage.class
     */
    @Override
    public boolean write(Object obj, String fileName) {

         if (!obj.getClass().isInstance(ListStorage.class)){
             throw new RuntimeException("Object to write is not ListStorage");
         }


        ListStorage listStorage = (ListStorage) obj;
        boolean succes;

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)
        ) {
            objOut.writeObject(listStorage);
            System.out.println("Changes in: " + listStorage.getClass().getSimpleName() + " has been saved");
            succes = true;
        } catch (IOException ex) {
            System.out.println("Error serializing Storage");
            System.out.println(ex);
            succes = false;
        }
        return succes;
    }

    public String toString() { // Class-Wins-Reglen, interfaces må ikke override Object.method();
        return "Serialized";
    }
}
