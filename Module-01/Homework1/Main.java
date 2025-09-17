package M01Homework1;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        Book b1 = new Book("Clean Code", "Robert C. Martin", "9780132350884", 3);
        Book b2 = new Book("Effective Java", "Joshua Bloch", "9780134685991", 2);
        Book b3 = new Book("Domain-Driven Design", "Eric Evans", "9780321125217", 1);

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        lib.addBook(new Book("Clean Code", "Robert C. Martin", "9780132350884", 1));

        System.out.println("\nКаталог книг:");
        lib.listBooks().forEach(System.out::println);

        Reader r1 = new Reader("Иван Иванов", "R001");
        Reader r2 = new Reader("Марина Петрова", "R002");
        lib.registerReader(r1);
        lib.registerReader(r2);

        System.out.println("\nСписок читателей:");
        lib.listReaders().forEach(System.out::println);

        System.out.println("\nВыдачи:");
        lib.issueBook("9780132350884", "R001");
        lib.issueBook("9780132350884", "R001");
        lib.issueBook("9780134685991", "R001");
        lib.issueBook("9780134685991", "R002");
        lib.issueBook("9780134685991", "R002");

        System.out.println("\nКниги у Ивана: " + lib.listLoansOf("R001"));
        System.out.println("Книги у Марины: " + lib.listLoansOf("R002"));

        System.out.println("\nКаталог после выдач:");
        lib.listBooks().forEach(System.out::println);

        System.out.println("\nВозвраты:");
        lib.returnBook("9780132350884", "R001");
        lib.returnBook("0000000000000", "R001");
        lib.returnBook("9780134685991", "R002");

        System.out.println("\nКаталог после возвратов:");
        lib.listBooks().forEach(System.out::println);

        System.out.println("\nУдаление читателей:");
        lib.unregisterReader("R001");
        lib.unregisterReader("R002");

        System.out.println("\nСписание книг:");
        lib.removeBook("9780132350884", 10);
        lib.removeBook("9780321125217", 1);

        System.out.println("\nИтоговый каталог:");
        lib.listBooks().forEach(System.out::println);

        System.out.println("\nИтоговые читатели:");
        lib.listReaders().forEach(System.out::println);
    }
}
