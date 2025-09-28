package net.java.banking_app.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import net.java.banking_app.errorResponse.BankingErrorResponse;
import net.java.banking_app.exception.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankingExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BankingErrorResponse> exceptionHandler(AccountNotFoundException exe, HttpServletRequest request) {
        BankingErrorResponse error = new BankingErrorResponse();

        error.setTimestamp(System.currentTimeMillis());
        error.setError(exe.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setPath(request.getRequestURI());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
