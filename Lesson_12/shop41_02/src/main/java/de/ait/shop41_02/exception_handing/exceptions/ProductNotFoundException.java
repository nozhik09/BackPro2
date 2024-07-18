package de.ait.shop41_02.exception_handing.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "product not found")
public class ProductNotFoundException extends GeneralApiException{

    public ProductNotFoundException(String message){
        super(message);
    }

}
