package blogapp.com.exception;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import blogapp.com.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){


    String message=ex.getMessage();
    ApiResponse apiResponse=new ApiResponse(message, false);
    return new ResponseEntity<ApiResponse>(apiResponse, org.springframework.http.HttpStatus.NOT_FOUND);
    
 }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    
Map<String, String> resp = new java.util.HashMap<>();
ex.getBindingResult().getFieldErrors().forEach(error -> {
    String fieldName = error.getField();
    String errorMessage = error.getDefaultMessage();
    resp.put(fieldName, errorMessage);
});
return new ResponseEntity<Map<String, String>>(resp, org.springframework.http.HttpStatus.BAD_REQUEST);


 
}

}
