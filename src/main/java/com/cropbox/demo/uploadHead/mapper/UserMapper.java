package com.cropbox.demo.uploadHead.mapper;

import com.cropbox.demo.uploadHead.model.User;
import org.apache.ibatis.annotations.*;
/**
 * user表的sql操作
 *
 * @author xie
 * @version 1.0
 * @Date 2017/5/27
 */
@Mapper
public interface UserMapper {
    /** 操作的表名 */
    String TABLE_NAME = "user";
    /** 数据库需要插入的列*/
    String INSET_FIELDS = "username, head";

    /**
     * 插入用户的所有信息
     *
     * @param user 添加的用户对象
     * @return 是否插入成功，成功返回1，失败返回0，其实是数据库被改变的行数
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSET_FIELDS,
            ") values (#{username},#{head})"})
    int insertUser(User user);

    /**
     * 由用户名查询用户的所有信息，
     *
     * @param username 用户名
     * @return 查询的用户对象
     */
    @Select({"select * from ", TABLE_NAME, " where username=#{username}"})
    User selectByUsername(@Param("username") String username);

    /**
     * 由用户名查询用户的所有信息，
     *
     * @param userId 用户名
     * @return 查询的用户对象
     */
    @Select({"select * from ", TABLE_NAME, " where user_id=#{userId}"})
    User selectByUserId(@Param("userId") String userId);


    /**
     * 更新用户信息
     * @param userId 用户主键
     * @param head 用户头像
     * @return
     */
    @Update({"update ", TABLE_NAME, " set head = #{head} where user_id=#{userId}"})
    int updateHead(@Param("userId") int userId, @Param("head") byte[] head);
}
