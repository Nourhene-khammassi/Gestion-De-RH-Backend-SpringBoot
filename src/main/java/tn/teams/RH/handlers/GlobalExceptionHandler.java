package tn.teams.RH.handlers;


import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tn.teams.RH.exceptions.ObjectValidationException;


@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ObjectValidationException.class)
  public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception) {
    ExceptionRepresentation exp = ExceptionRepresentation.builder()
        .errorMessage("Object not valid exception has occurred")
        .errorSource(exception.getValidationSource())
        .validationErrors(exception.getErrorMessages())
        .build();
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exp);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExceptionRepresentation> handleException(EntityNotFoundException exception) {
    ExceptionRepresentation exp = ExceptionRepresentation.builder()
        .errorMessage(exception.getMessage())
        .build();
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exp);
  }

  @ExceptionHandler(DisabledException.class)
  public ResponseEntity<ExceptionRepresentation> handleException() {
    ExceptionRepresentation exp = ExceptionRepresentation.builder()
        .errorMessage("The user is disabled, please contact an ADMIN to activate your account")
        .build();
    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body(exp);
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ExceptionRepresentation> handleBadCredentialsException() {
    ExceptionRepresentation exp = ExceptionRepresentation.builder()
        .errorMessage("Email and / or password is incorrect")
        .build();
    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body(exp);
  }

}
