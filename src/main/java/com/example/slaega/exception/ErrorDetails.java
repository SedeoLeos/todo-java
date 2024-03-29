package com.example.slaega.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
@Data
public class ErrorDetails {

    private HttpStatus code;

    private List<String> message;

}
