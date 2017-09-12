package com.lapots.breed.platform.cloud.boot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Basic application exception.
 */
@AllArgsConstructor
@Data
public class ApplicationException extends RuntimeException {
    private String code;
    private Throwable ex;
}

