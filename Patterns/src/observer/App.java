package observer;

public class App {
    public static void main(String[] args) {

        Audience a1 = new Audience("Elton");
        Audience a2 = new Audience("John");

        CatVideo c1 = new CatVideo("Bufas");

        System.out.println();
        System.out.println("Before adding");
        System.out.println(c1);

        System.out.println();
        System.out.println("Adding observers");
        c1.addObserver(a1);
        c1.addObserver(a2);

        System.out.println();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println();
        System.out.println(c1);

        System.out.println();
        System.out.println("After adding");
        System.out.println();
        System.out.println("Running video");
        for (int i = 0; i < 10; i++) {
            c1.play("Bufas");
        }
        System.out.println();
        System.out.println("After playing video");
        System.out.println(c1);
        System.out.println();
        System.out.println(a1);
        System.out.println(a2);
    }
}
