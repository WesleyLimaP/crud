package crud.projeto.master.controller.handlers;
import crud.projeto.master.dto.CustomError;
import crud.projeto.master.dto.FildMessage;
import crud.projeto.master.dto.ValidationError;
import crud.projeto.master.services.exceptions.RessousesNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RessousesNotFoundException.class)
    public ResponseEntity<CustomError> ressoussesNotFound(RessousesNotFoundException e, HttpServletRequest request ){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI() );
        return  ResponseEntity.status(status).body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request ){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError validationError = new ValidationError(Instant.now(), status.value(), "erro de validação", request.getRequestURI() );
        for(FieldError error: e.getFieldErrors()){
            validationError.getFildMessages().add(new FildMessage(error.getField(), error.getDefaultMessage()));
        }
        return  ResponseEntity.status(status).body(validationError);
    }

}
