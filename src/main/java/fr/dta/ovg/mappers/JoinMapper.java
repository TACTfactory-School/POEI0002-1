package fr.dta.ovg.mappers;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.dta.ovg.dtos.JoinDto;
import fr.dta.ovg.entities.Event;
import fr.dta.ovg.entities.Join;
import fr.dta.ovg.exceptions.NotFoundException;
import fr.dta.ovg.services.EventCrudService;

@Component
public class JoinMapper {

    private static final String ERR_ID_TO_EVENT = "Error during convertion, impossible to retrieve event from id {}";

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EventCrudService service;

    private static final Logger log = LoggerFactory.getLogger(JoinMapper.class);

    @PostConstruct
    public void init() {

        this.mapper.typeMap(JoinDto.class, Join.class).addMappings(mapper -> {
            mapper.using((final MappingContext<Long, Event> ctx) -> {
                Event result = null;

                try {
                    result = this.service.getOne(ctx.getSource());
                } catch (NotFoundException e) {
                    log.error(ERR_ID_TO_EVENT, ctx.getSource());
                }

                return result;
            }).map(JoinDto::getEventId, Join::setUser);
        });
    }

    public Join createFrom(@Valid JoinDto dto) {
        return this.mapper.map(dto, Join.class);
    }
}
