package uz.boom.citizens.mapper.file;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.citizens.dto.file.ResourceDto;
import uz.boom.citizens.entity.file.Resource;

/**
 * @author D4uranbek ср. 10:46. 23.02.2022
 */

@Component
@Mapper(componentModel = "spring")
public interface ResourceMapper {

    ResourceDto toDto(Resource resource);

    Resource fromDto(ResourceDto resourceDto);


}
