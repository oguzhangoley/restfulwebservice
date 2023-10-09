package net.oguz.springboot.mapper;

import net.oguz.springboot.dto.UserDto;
import net.oguz.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    // @Mapping(source = "email",target = "emailAddress") // field isimleri farklı olursa !!
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
