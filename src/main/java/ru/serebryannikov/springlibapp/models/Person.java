package ru.serebryannikov.springlibapp.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Neil Alishev
 */
public class Person {
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов")
    private String fullName;


    @Min(value = 1900, message = "Год рождения должен быть больше 1900")
    private int yearOfBirth;

    public Person() {}

    public Person(String full_name, int yearOfBirth) {
        this.fullName = full_name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
