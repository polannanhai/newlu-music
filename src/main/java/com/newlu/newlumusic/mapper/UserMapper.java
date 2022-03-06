package com.newlu.newlumusic.mapper;

import com.newlu.newlumusic.dto.UserDto;
import com.newlu.newlumusic.entity.User;
import com.newlu.newlumusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);
}
