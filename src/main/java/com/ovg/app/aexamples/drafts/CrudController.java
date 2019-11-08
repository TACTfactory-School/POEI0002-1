package com.ovg.app.aexamples.drafts;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ovg.app.exceptions.HttpException;
import com.ovg.app.exceptions.NotFoundException;


public class CrudController<T extends Entity, R extends OvgRepository<T>> {

    @Autowired
    private R repository;

    @GetMapping
    public List<T> getAll() throws SQLException {
        return this.repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public T create(@RequestBody T event) throws HttpException {
        return this.repository.save(event);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) throws HttpException {
        this.repository.delete(id);
    }

    @GetMapping("{id}")
    public T getOne(@PathVariable int id) throws HttpException {
        final T result = this.repository.find(id);

        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }

    @PutMapping("{id}")
    public T update(@PathVariable int id, @RequestBody T event) throws HttpException {
        event.setId(id);

        return this.repository.save(event);
    }

    // Injection de la reponse generee par spring
//    @PostMapping
//    public T create(HttpServletResponse response) {
//        response.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
//
//        return null;
//    }

    // Par le retour de la fonction
//    @PostMapping
//    public ResponseEntity<T> create() {
//
//        return ResponseEntity.of(null).status(HttpStatus.NOT_IMPLEMENTED).build();
//    }

    // Par exception re-ecrite
//    @PostMapping
//    public T create() throws Exception {
//        throw new Exception("Coucou");
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public Map<String, String> errors(Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.BAD_REQUEST.value());
//        return Collections.singletonMap("error", e.getMessage());
//    }

    // Par custom exception
//    @PostMapping
//    public T create() throws Exception {
//      throw new MyException("Coucou");
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public static class MyException extends Exception {
//        private static final long serialVersionUID = 1L;
//
//        public MyException(final String msg) {
//            super(msg);
//        }
//    }

}
