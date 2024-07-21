package convertor;

import model.dto.ToyDTO;
import model.entity.Toy;
import org.mapstruct.Mapper;

@Mapper
public interface ToyMapper {
    ToyDTO toDTO(Toy toy);
    Toy toEntity(ToyDTO toyDTO);
    ToyDTO[] toDTOs(Toy[] toys);
    Toy[] toEntities(ToyDTO[] toyDTOs);
}