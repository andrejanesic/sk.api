package rs.raf.sk.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import rs.raf.sk.dto.HotelDto;
import rs.raf.sk.models.Hotel;

@Repository
@Mapper(componentModel = "spring")
public interface HotelMapper extends EntityMapper<HotelDto, Hotel> {
}