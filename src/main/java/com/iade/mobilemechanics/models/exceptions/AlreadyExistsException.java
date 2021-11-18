package com.iade.mobilemechanics.models.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String name, String emlType, String idname) {
        super(emlType + " with " + idname+" " + name + " already exist ");
    }

    public AlreadyExistsException(String numberplate) {
        super("The numberplate '"+numberplate+"' already exists");
    }
    public AlreadyExistsException(String email, String a) {
        super("The email '"+email+"' is not valid.");
    }
}