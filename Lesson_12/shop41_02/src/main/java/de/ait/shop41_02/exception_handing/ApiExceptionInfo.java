package de.ait.shop41_02.exception_handing;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class ApiExceptionInfo {
    private String message;
}
