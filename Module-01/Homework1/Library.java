package M01Homework1;

import java.util.*;

public class Library {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Reader> readers = new HashMap<>();
    private final Map<String, List<String>> loans = new HashMap<>();

    public void addBook(Book book) {
        Objects.requireNonNull(book, "book is null");
        Book existing = books.get(book.getIsbn());
        if (existing == null) {
            books.put(book.getIsbn(), book);
            System.out.println("Добавлена новая книга: " + book);
        } else {
            if (!existing.getTitle().equals(book.getTitle()) ||
                    !existing.getAuthor().equals(book.getAuthor())) {
                throw new IllegalArgumentException("ISBN conflict: different book metadata for same ISBN");
            }
            existing.addCopies(book.getCopiesAvailable());
            System.out.println("Увеличено количество экземпляров: " + existing);
        }
    }

    public void removeBook(String isbn, int count) {
        Book b = books.get(isbn);
        if (b == null) {
            System.out.println("Книга с ISBN " + isbn + " не найдена.");
            return;
        }
        try {
            b.removeCopies(count);
            System.out.println("Списано " + count + " экз.: " + b);
            if (b.getCopiesTotal() == 0) {
                books.remove(isbn);
                System.out.println("Книга удалена из каталога: " + isbn);
            }
        } catch (IllegalStateException ex) {
            System.out.println("Невозможно списать: " + ex.getMessage());
        }
    }

    public void registerReader(Reader r) {
        Objects.requireNonNull(r, "reader is null");
        if (readers.containsKey(r.getReaderId())) {
            System.out.println("Читатель уже зарегистрирован: " + r);
            return;
        }
        readers.put(r.getReaderId(), r);
        System.out.println("Зарегистрирован читатель: " + r);
    }

    public void unregisterReader(String readerId) {
        Reader r = readers.get(readerId);
        if (r == null) {
            System.out.println("Читатель не найден: " + readerId);
            return;
        }
        List<String> borrowed = loans.getOrDefault(readerId, Collections.emptyList());
        if (!borrowed.isEmpty()) {
            System.out.println("Нельзя удалить читателя — есть невозвращённые книги: " + borrowed);
            return;
        }
        readers.remove(readerId);
        loans.remove(readerId);
        System.out.println("Читатель удалён: " + r);
    }

    public void issueBook(String isbn, String readerId) {
        Book b = books.get(isbn);
        if (b == null) {
            System.out.println("Книга с ISBN " + isbn + " не найдена.");
            return;
        }
        Reader r = readers.get(readerId);
        if (r == null) {
            System.out.println("Читатель не найден: " + readerId);
            return;
        }
        try {
            b.borrowOne();
            loans.computeIfAbsent(readerId, k -> new ArrayList<>()).add(isbn);
            System.out.println("Выдано: '%s' читателю %s".formatted(b.getTitle(), r.getName()));
        } catch (IllegalStateException ex) {
            System.out.println("Выдача невозможна: " + ex.getMessage());
        }
    }

    public void returnBook(String isbn, String readerId) {
        Book b = books.get(isbn);
        if (b == null) {
            System.out.println("Книга с ISBN " + isbn + " не найдена в каталоге.");
            return;
        }
        Reader r = readers.get(readerId);
        if (r == null) {
            System.out.println("Читатель не найден: " + readerId);
            return;
        }
        List<String> borrowed = loans.get(readerId);
        if (borrowed == null || !borrowed.remove(isbn)) {
            System.out.println("У читателя нет на руках книги с ISBN " + isbn);
            return;
        }
        b.returnOne();
        System.out.println("Возврат: '%s' от читателя %s".formatted(b.getTitle(), r.getName()));
    }

    public Optional<Book> findBook(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public Optional<Reader> findReader(String readerId) {
        return Optional.ofNullable(readers.get(readerId));
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Reader> listReaders() {
        return new ArrayList<>(readers.values());
    }

    public List<String> listLoansOf(String readerId) {
        return Collections.unmodifiableList(loans.getOrDefault(readerId, Collections.emptyList()));
    }
}
