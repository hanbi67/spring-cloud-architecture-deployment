package com.example.cloudarchitecturedeployment.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Valid 검증 실패 시 발생하는 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException e,
            HttpServletRequest request) {

        log.error("입력값 검증 실패: path={}", request.getRequestURI(), e);

        ErrorResponse response = ErrorResponse.of(
                HttpStatus.BAD_REQUEST,
                "입력값을 확인해주세요",
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    // CustomException 처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(
            CustomException e,
            HttpServletRequest request) {

        log.error("CustomException 발생: errorCode={}, message={}, path={}",
                e.getErrorCode().getCode(),
                e.getMessage(),
                request.getRequestURI(),
                e);

        ErrorResponse response = ErrorResponse.of(
                e.getErrorCode().getHttpStatus(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(response);
    }
}
