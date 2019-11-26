/* Controller Configuration Class
 * @author Colin Cerveaux @C-ambium
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.configurations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fr.dta.ovg.exceptions.NotFoundException;


@ControllerAdvice
public class ControllerConfiguration {

    @ExceptionHandler(NotFoundException.class)
    public Map<String, Object> errorsRewrite(final NotFoundException e) {

        final Map<String, Object> result = new HashMap<>();

        result.put("date", LocalDateTime.now());
        result.put("error", e.getMessage());

        return result;
    }
}
