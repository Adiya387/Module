package M01Homework1;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private int copiesTotal;
    private int copiesAvailable;

    public Book(String title, String author, String isbn, int copies) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title is required");
        if (author == null || author.isBlank()) throw new IllegalArgumentException("author is required");
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("isbn is required");
        if (copies < 0) throw new IllegalArgumentException("copies must be >= 0");
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copiesTotal = copies;
        this.copiesAvailable = copies;
    }

    public void addCopies(int count) {
        if (count <= 0) throw new IllegalArgumentException("count must be > 0");
        copiesTotal += count;
        copiesAvailable += count;
    }

    public void removeCopies(int count) {
        if (count <= 0) throw new IllegalArgumentException("count must be > 0");
        if (count > copiesAvailable) {
            throw new IllegalStateException("cannot remove more than available (some copies are on loan)");
        }
        copiesTotal -= count;
        copiesAvailable -= count;
    }

    public void borrowOne() {
        if (copiesAvailable <= 0) throw new IllegalStateException("no available copies");
        copiesAvailable--;
    }

    public void returnOne() {
        if (copiesAvailable >= copiesTotal) {
            throw new IllegalStateException("all copies are already in library");
        }
        copiesAvailable++;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getCopiesTotal() { return copiesTotal; }
    public int getCopiesAvailable() { return copiesAvailable; }

    @Override
    public String toString() {
        return "Book{title='%s', author='%s', isbn='%s', total=%d, available=%d}"
                .formatted(title, author, isbn, copiesTotal, copiesAvailable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
