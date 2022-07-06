package com.senpiper.liv2train2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class TrainingCenterValidations {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    String handleConstraintViolation(ConstraintViolationException exception){

        String[] violationMessages = exception.getMessage().split(",");
        StringBuilder violationMessage = new StringBuilder();
        for(String temp : violationMessages){
            violationMessage.append(temp.trim()).append(" \n");
        }
        return violationMessage.toString();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    String exceptionHandler(HttpMessageNotReadableException exception) {
        return "JSON parse error: Incorrect Json Format";
    }
}
