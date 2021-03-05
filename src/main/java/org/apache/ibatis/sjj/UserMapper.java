package org.apache.ibatis.sjj;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sunjiajie
 * @date 2021/3/5
 */
public interface UserMapper {
  List<User> listAllUser();

  @Select("select * from user where id=#{userId,jdbcType=INTEGER}")
  User getUserById(@Param("userId") String userId);
}
