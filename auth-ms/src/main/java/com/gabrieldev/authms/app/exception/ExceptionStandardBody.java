package com.gabrieldev.authms.app.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExceptionStandardBody {

    private int httpStatusCode;
    private String messageError;
}
