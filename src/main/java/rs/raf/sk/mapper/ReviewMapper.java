package rs.raf.sk.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import rs.raf.sk.dto.ReviewDto;
import rs.raf.sk.models.Review;

@Repository
@Mapper(componentModel = "spring")
public interface ReviewMapper extends EntityMapper<ReviewDto, Review> {
}