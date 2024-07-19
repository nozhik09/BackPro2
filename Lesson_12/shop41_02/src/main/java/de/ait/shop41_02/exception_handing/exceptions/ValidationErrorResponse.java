package de.ait.shop41_02.exception_handing.exceptions;

import de.ait.shop41_02.exception_handing.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationErrorResponse {


    private String message;
    private String url;
    private List<ValidationError> validationErrors;
}
