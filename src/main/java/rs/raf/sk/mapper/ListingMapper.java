package rs.raf.sk.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import rs.raf.sk.dto.ListingDto;
import rs.raf.sk.models.Listing;

@Repository
@Mapper(componentModel = "spring")
public interface ListingMapper extends EntityMapper<ListingDto, Listing> {
}