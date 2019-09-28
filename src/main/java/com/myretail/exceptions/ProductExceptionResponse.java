package com.myretail.exceptions;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductExceptionResponse {
 private int code;
 private String description;

}
