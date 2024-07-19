package de.ait.shop41_02.exception_handing;


import com.sun.net.httpserver.HttpServer;
import de.ait.shop41_02.exception_handing.exceptions.ProductNotFoundException2;
import de.ait.shop41_02.exception_handing.exceptions.ProductNotFoundException3;
import de.ait.shop41_02.exception_handing.exceptions.ValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class AdviceExceptionController {

    @ExceptionHandler(ProductNotFoundException3.class)
    public ResponseEntity<ApiExceptionInfo> productNotFound(Exception e) {
        System.out.println("333333333333333333333333");
        return new ResponseEntity<>(new ApiExceptionInfo(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> validateExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request) {

        List<ValidationError> list = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> (FieldError) objectError)
                .map(ValidationError::of)
                .toList();
        ValidationErrorResponse validationError = new ValidationErrorResponse(request.getServletPath(), "Validation Error", list);

        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);

//        System.out.println(e.getMessage()+"-----------------------");
//      return  new ResponseEntity<>(e.getMessage().toString(), HttpStatus.I_AM_A_TEAPOT);


    }


}
