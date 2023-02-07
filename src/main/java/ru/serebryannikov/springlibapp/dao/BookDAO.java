package ru.serebryannikov.springlibapp.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.serebryannikov.springlibapp.models.Book;
import ru.serebryannikov.springlibapp.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(person_id, titlebook, author, year) VALUES (null,?,?,?)", book.getTitleBook(), book.getAuthor(), book.getYear());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET titlebook=?, author=?, year=? WHERE id=?", updatedBook.getTitleBook(),
                updatedBook.getAuthor(),updatedBook.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }

    public Optional <Person> getBookPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM book JOIN person ON book.person_id = person.id WHERE book.id=?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void appointBookPerson(int id, Person person){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", person.getId(), id);
    }

    public void releaseBook(int id){
        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?", id);
    }
}
