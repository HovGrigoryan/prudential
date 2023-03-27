package com.epam.prudential.mapper;

import com.epam.prudential.model.User;
import lombok.Setter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper()
@Component
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUser(@Param("id") Long id);

    @Select("select * from users")
    List<User> findAll();

    @Insert("insert into users(name,surname) values(#{name},#{surname})")
    void insert(User user);
}
