package app.error;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    private ErrorAttributes errorAttributes = new DefaultErrorAttributes();

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Map<String,String>> handleMethodArgumentNotValid(
            MethodArgumentTypeMismatchException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("errorField",ex.getParameter().getParameterName());
        error.put("errorMessage",this.getRootCause(ex));
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    private String getRootCause(MethodArgumentTypeMismatchException ex){
        Throwable e = ex;
        System.out.println(ex.getParameter().getParameterName());
        while(e.getCause() != null){
            e = e.getCause();
        }
        return e.getMessage();
    }


}
