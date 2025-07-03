package in.rahulojha.bookbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookNotFoundException extends ResponseStatusException {
    public BookNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Book with given id not found in the database");
    }


}
