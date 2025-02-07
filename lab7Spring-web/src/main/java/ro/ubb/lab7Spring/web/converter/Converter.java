package ro.ubb.lab7Spring.web.converter;

import ro.ubb.lab7Spring.core.model.BaseEntity;
import ro.ubb.lab7Spring.web.dto.BaseDto;

public interface Converter <Model extends BaseEntity<Long>, Dto extends BaseDto> {
    Model convertDtoToModel(Dto dto);
    Dto convertModelToDto(Model model);
}
