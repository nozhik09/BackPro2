package de.ait.shop41_02.exception_handing;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationError {
    private String field;
    private String rejectedValue;
    private String message;

    public static ValidationError of(FieldError error) {
        return ValidationError.builder()
                .field(error.getField())
                .message(error.getDefaultMessage())
                .rejectedValue(error.getRejectedValue() != null ? error.getRejectedValue().toString() : "")
                .build();

    }


}
