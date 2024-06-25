package com.fdm.service.service.exceptions;

import com.fdm.service.service.exceptions.piese.PiesaAlreadyExistsException;
import com.fdm.service.service.exceptions.piese.PiesaNotFoundException;
import com.fdm.service.service.exceptions.user.UserAlreadyExistsException;
import com.fdm.service.service.exceptions.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(userNotFoundException.getMessage());
    }

    @ExceptionHandler({UserAlreadyExistsException.class})
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(userAlreadyExistsException.getMessage());
    }
    @ExceptionHandler({PiesaNotFoundException.class})
    public ResponseEntity<Object> handlePiesaNotFoundException(PiesaNotFoundException piesaNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(piesaNotFoundException.getMessage());
    }

    @ExceptionHandler({PiesaAlreadyExistsException.class})
    public ResponseEntity<Object> handlePiesaAlreadyExistsException(PiesaAlreadyExistsException piesaAlreadyExistsException) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(piesaAlreadyExistsException.getMessage());
    }
}
