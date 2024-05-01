package com.durgesh.onlydevs.responses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private HttpStatus status;
    private int statusCode;
    private String message;
    private String path;
    private LocalDateTime timestamp;
    private Object data;
    private boolean success;

    public ApiResponse(HttpStatus status, String message, String path, Object data,boolean success) {
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
        this.data = data;
        this.success = success;
    }


}
