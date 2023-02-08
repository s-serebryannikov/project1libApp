package ru.serebryannikov.springlibapp.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Название книги не должно быть пустым")
    @Size(min = 2, max = 30, message = "Название книги должно быть от 2 до 100 символов")
    private String titleBook;

    @NotEmpty(message = "Поле автор не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя автора должно быть от 2 до 100 символов")
    private String author;

    @Min(value = 1500, message = "Год должен быть больше 1500")
    private int year;

    public Book() {
    }

    public Book(String name, String author, int year) {
        this.titleBook = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
