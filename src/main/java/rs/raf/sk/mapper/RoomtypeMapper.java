package rs.raf.sk.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import rs.raf.sk.dto.RoomtypeDto;
import rs.raf.sk.models.Roomtype;

@Repository
@Mapper(componentModel = "spring")
public interface RoomtypeMapper extends EntityMapper<RoomtypeDto, Roomtype> {
}