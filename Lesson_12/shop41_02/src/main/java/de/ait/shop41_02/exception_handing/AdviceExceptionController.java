package de.ait.shop41_02.exception_handing;


import de.ait.shop41_02.exception_handing.exceptions.ProductNotFoundException2;
import de.ait.shop41_02.exception_handing.exceptions.ProductNotFoundException3;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class AdviceExceptionController {

    @ExceptionHandler(ProductNotFoundException3.class)
    public ResponseEntity<ApiExceptionInfo> productNotFound(Exception e){
        System.out.println("333333333333333333333333");
        return new ResponseEntity<ApiExceptionInfo>(new ApiExceptionInfo(e.getMessage()), HttpStatus.NOT_FOUND);
    }




}
