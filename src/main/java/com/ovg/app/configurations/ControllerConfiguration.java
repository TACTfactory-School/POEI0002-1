package com.ovg.app.configurations;

import java.time.LocalDateTime;
import java.util.Map;

import javax.xml.ws.http.HTTPException;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ovg.app.exceptions.NotFoundException;

public class ControllerConfiguration {

/*    public ControllerConfiguration() {

        @ExceptionHandler(NotFoundException.class)
        public Map<String, String> errorsRewrite(final NotFoundException e) {

            final Map<String, String> result = new HashMap<>();

            result.put("date", LocalDateTime.now())
            result.put("error", e.getMessage())

        }*/
}
