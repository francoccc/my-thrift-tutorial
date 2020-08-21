package com.franco.service;

import com.franco.bean.User;
import com.franco.mapper.UserMapper;
import com.thrift.user.service.RpcUserService;
import com.thrift.user.service.UserDto;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author chenxy
 */
@Service
public class RpcUserServiceImpl implements RpcUserService.Iface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto getUserById(long id) throws TException {
        User user = userMapper.getUserById(id);
        UserDto userDto = new UserDto();
        userDto.setId(user.getUserId());
        userDto.setName(user.getUserName());
        userDto.setPassword("123456");
        return userDto;
    }
}
