import java.util.Arrays;
import java.util.Comparator;

public class Book implements Comparable<Book>{
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return title + ": " + price;
    }

    @Override
    public int compareTo(Book other) {
        // Sammenligner bøger baseret på pris
        if (this.price < other.price) {
            return -1;
        } else if (this.price == other.price) {
            return 0;
        } else return 1;
    }

        private static class TitleComparator implements Comparator<Book> {
            @Override
            public int compare(Book o1, Book o2) {
                //Sammenligner på titel
                if (o1.title.compareTo(o2.title) < 0) {
                    return -1;
                } else if (o1.title.compareTo(o2.title) == 0) {
                    return 0;
                } else return 1;
            }
    }

    // Test
    public static void main(String[] args) {
        Book b1 = new Book("Abemad", 100);                                          //1 - compare
        Book b2 = new Book("Lær din baby Krav Maga", 150);                          //2
        Book b3 = new Book("The Gang of Four", 250);                                //3
        Book b4 = new Book("Zen, og kunsten at vedligeholde en motorcykel", 150);   //4

        Book[] arr = new Book[]{b4,b2,b3,b1};

        System.out.println();
        System.out.println("Før sortering");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println("Efter sortering, baseret på pris");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println("Efter sortering, baseret på titel");
        Arrays.sort(arr, new TitleComparator());
        System.out.println(Arrays.toString(arr));
    }
}