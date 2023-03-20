package br.org.sesisc.sim.backend.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public final class ErrorResponse {
	
	/**
 	* Default Constructor
 	*/
	private ErrorResponse() {
    	//Default Constructor
    }

    @SuppressWarnings("rawtypes")
	public static ResponseEntity<HashMap> handle(Errors e, HttpStatus status) {
        final List<MessageError> errors = new ArrayList<MessageError>();

        for (final FieldError error : e.getFieldErrors()) {
            errors.add(new MessageError(error.getField(), "field", error.getDefaultMessage()));
        }

        for (final ObjectError error : e.getGlobalErrors()) {
            errors.add(new MessageError(error.getObjectName(), "global", error.getDefaultMessage()));
        }

        HashMap<String, List<MessageError>> result = new HashMap<String, List<MessageError>>();
        result.put("errors", errors);

        return new ResponseEntity<HashMap>(result, status);
    }

    @SuppressWarnings("rawtypes")
	public static ResponseEntity<HashMap> handle(String[] messages, Class<?> klass, HttpStatus status) {
        final List<MessageError> errors = new ArrayList<MessageError>();

        for (final String message : messages) {
            errors.add(new MessageError(klass.getSimpleName(), "global", message));
        }

        HashMap<String, List<MessageError>> result = new HashMap<String, List<MessageError>>();
        result.put("errors", errors);

        return new ResponseEntity<HashMap>(result, status);
    }

    @SuppressWarnings("rawtypes")
	public static ResponseEntity<HashMap> handle(String message, Class<?> klass, HttpStatus status) {
        final List<MessageError> errors = new ArrayList<MessageError>();

        errors.add(new MessageError(klass.getSimpleName(), "global", message));

        HashMap<String, List<MessageError>> result = new HashMap<String, List<MessageError>>();
        result.put("errors", errors);

        return new ResponseEntity<HashMap>(result, status);
    }

}
