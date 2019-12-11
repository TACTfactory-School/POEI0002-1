/* Mapper Configuration Class.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.configurations;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mapper Config.<br>
 * Initialize the mapper(s) used in this application.
 */
@Configuration
public class MapperConfig {

    /**
     * Build Mapper.
     * @return ModelMapper.
     */
    @Bean
    public ModelMapper buildMapper() {
        return new ModelMapper();
    }
}
