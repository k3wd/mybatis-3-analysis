package com.k3wd.mybatis.mapper;

import com.k3wd.mybatis.model.Users;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UsersMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> listByPrimaryKey(RowBounds rowBounds);
}
