package rs.raf.sk.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import rs.raf.sk.dto.RankDto;
import rs.raf.sk.models.Rank;

@Repository
@Mapper(componentModel = "spring")
public interface RankMapper extends EntityMapper<RankDto, Rank> {
}