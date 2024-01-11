import java.io.*;
import java.util.Scanner;

public class ReadWrite {
    public static void main(String[] args) {
        //Printf eksempel:
        String navn = "Jønke";
        int alder = 52;
        double gennemsnit = 69.420;

        System.out.printf("Navn: %s, Alder: %d, Gennemsnit: %.2f%n", navn, alder, gennemsnit);
        /*
        %s: Streng
        %d: Heltal
        %f: floating point
        %n: Ny linje
        %t: Tids- og datoformatering (f.eks. %tH:%tM for time og minut)
        %b: Bool
        %c: Tegn
         */

        writeToFile("C:\\Users\\lhass\\IdeaProjects\\SEM.2_Repetition\\FileReadWrite\\src\\output");
        readFromFile("C:\\Users\\lhass\\IdeaProjects\\SEM.2_Repetition\\FileReadWrite\\src\\output");

    }

    static void writeToFile(String fileAddress) {

        File file = new File(fileAddress);

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            //Print til fil

            if (printWriter.checkError()) {
                throw new IOException("File not found or not valid target");
            }

            printWriter.println("print med linjeskift");
            printWriter.print("Print uden linjeskift \n");
            printWriter.printf("Print i %s, med tal %f", new String("format"), 420.69);



            System.out.println("Data skrevet til filen: " + "\""+fileAddress+"\"");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println();
            e.printStackTrace();
        } finally {
            // PrintWriter close() kaldes automatisk grundet try-with-resources
        }

    }

    static void readFromFile(String fileAddress) {

        try (Scanner scanner = new Scanner(new File(fileAddress))) {

            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

