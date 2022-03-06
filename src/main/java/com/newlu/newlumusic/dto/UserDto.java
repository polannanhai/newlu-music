package com.newlu.newlumusic.dto;

import com.newlu.newlumusic.vo.RoleVo;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String id;

    private String username;

    private String nickname;

    private List<RoleVo> roles;

}
