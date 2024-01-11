import java.util.ArrayList;
import java.util.Collections;

public class PersonComparison {
    /*
    Opgave 1
a) Program a generic class Person<T> with a name field of type T and constructor and
toString() method (Person<T> is a generic class).

    Make another class FullName with fields firstname and lastname (both strings) and
    constructor and toString() method (FullName is an ordinary class).

    Test the class Person<T>, first with String as type argumnet, and then with FullName as type
    argument (i.e. Person<String> and Person<FullName>).

b) Modify the class Person<T> so that it implements the interface Comparable<Person<T>>
with persons ordered according to the value of the name field. This will require that the type
parameter T implements Comparable<T>.

    Test the compareTo() method with Person<String> objects, and with Person<FullName>
    objects.

    Add some persons to an ArrayList<Person<FullName>>. Print the list before and after sorting
    it with Collections.sort().

c) Extra exercise (extra now; you will learn about lambda expressions later):
    Add an age field to the Person class (update the constructor and the toString() method, add a
    getAge() method).
    Sort the list on age with the sort() method in the List class using a lambda expression.
     */

    public static void main(String[] args) {

        Person<Double> p0 = new Person<>(15.5);
        Person<Double> pt = new Person<>(11.5);
        System.out.println("Person<Double>");
        System.out.println(p0);
        System.out.println(pt);
        System.out.println(p0.compareTo(pt));


        Person<String> p1 = new Person<>("Yeet Yeetus");
        Person<String> p2 = new Person<>("Slambert Beigmann");
        Person<FullName> p3 = new Person<>(new FullName("Hot", "Diggety"));
        Person<FullName> p4 = new Person<>(new FullName("Skidd", "Diggety"));

        System.out.println("Person<String>: ");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println();

        System.out.println("Person<FullName>: ");
        System.out.println(p3);
        System.out.println(p4);
        System.out.println();

        System.out.println("Comparison, Person<String>:");
        System.out.println(p1.compareTo(p2));
        System.out.println(p2.compareTo(p1));
        System.out.println();

        System.out.println("Comparison, Person<FullName>:");
        System.out.println(p3.compareTo(p4));
        System.out.println(p4.compareTo(p3));

        ArrayList<Person<FullName>> list = new ArrayList<>();
        list.add(p3);
        list.add(p4);
        list.add(new Person</*Type Inference?*/>(new FullName("Æder", "Mâme")));
        list.add(new Person<>(new FullName("Edda", "Mamme")));
        list.add(new Person<>(new FullName("Smægam", "Iloihne")));

        System.out.println();
        System.out.println("Før sortéring: ");
        for (Person<FullName> fullNamePerson : list) {
            System.out.println(fullNamePerson);
        }

        Collections.sort(list);

        System.out.println();
        System.out.println("Efter sortéring: ");
        for (Person<FullName> fullNamePerson : list) {
            System.out.println(fullNamePerson);
        }
    }
}

class Person<T extends Comparable<T>> implements Comparable<Person<T>> {
    private T name;

    public Person(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+"";
    }

    @Override
    public int compareTo(Person<T> o) {
        return this.name.compareTo(o.getName());
    }
}

class FullName implements Comparable<FullName> {
    private String firstName;
    private String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(FullName o) {
        if (this.lastName.compareTo(o.lastName) == 0) {
            return this.firstName.compareTo(o.firstName);
        } else return this.lastName.compareTo(o.lastName);
    }
}