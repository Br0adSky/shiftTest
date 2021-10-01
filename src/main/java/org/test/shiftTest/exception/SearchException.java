package org.test.shiftTest.exception;

import lombok.Data;

@Data
public class SearchException extends RuntimeException {
    public SearchException(Long id) {
        super("Id not found: " + id);
    }
}
