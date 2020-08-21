namespace java com.thrift.user.service

struct UserDto {
        1:i64 id
        2:string name
        3:string password
}

service RpcUserService {

    UserDto getUserById(1:i64 id)
}