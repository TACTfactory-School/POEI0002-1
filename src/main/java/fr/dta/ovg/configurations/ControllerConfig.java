/* Controller Configuration Class.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.configurations;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fr.dta.ovg.contracts.ConfigurationContract;
import fr.dta.ovg.exceptions.NotFoundException;

/** Controller Configuration Class.*/
@ControllerAdvice
public class ControllerConfig {

    /**
     * Rewrite Error Exception Handler.<br>
     * @param e NotFoundException.<br>
     * @return HashMap contains errors messages and date.
     */
    @ExceptionHandler(NotFoundException.class)
    public Map<String, Object> errorsRewrite(final NotFoundException e) {

        final Map<String, Object> result = new HashMap<>();

        result.put(ConfigurationContract.CONTROLLER_404_DATE, ZonedDateTime.now());
        result.put(ConfigurationContract.CONTROLLER_404_ERROR, e.getMessage());

        return result;
    }
}
