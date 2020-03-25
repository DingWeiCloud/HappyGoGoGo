package com.happy.dao;

import com.happy.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper2 {
    public User getUserById(Integer id);
    @Select("select * from user where id = #{id}")
    public User getUserById2(Integer id);
}
