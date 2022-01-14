package rs.raf.sk.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import rs.raf.sk.dto.UserDto;
import rs.raf.sk.models.User;

@Repository
@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {
}