package com.gabrieldev.userms.app.exception;

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
