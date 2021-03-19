package com.zhitar.springboot_mybatis.mapper;

import com.zhitar.springboot_mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<User> findAll();

    @Select("select * from users where name = #{name}")
    List<User> findByName(final String name);

    @Update("update users set name = #{name}, surname = #{surname}, email = #{email}, password = #{password} " +
            "where id = #{id}")
    void update(User user);

    @Insert("insert into users(name, surname, email, password) values (#{name}, #{surname}, #{email}, #{password})")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
//            before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Delete("delete from users where id = #{id}")
    void deleteById(Long id);

    List<User> search(@Param("name") String name,
                      @Param("surname") String surname,
                      @Param("password") String password);
}
