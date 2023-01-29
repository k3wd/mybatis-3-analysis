package com.k3wd;

import com.k3wd.mapper.UsersMapper;
import com.k3wd.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author k3wd
 * @date 2023/1/29
 */
@Slf4j
public class Test {
    public static void main(String[] args) throws IOException {
        //第一步：读取mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //第二步：构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第三步：打开SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        //第四步：获取Mapper接口对象
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);

        //第五步：调用Mapper接口对象的方法操作数据库；
        Users user = usersMapper.selectByPrimaryKey(1);

        //第六步：业务处理
        log.info("查询结果: " + user.getId() + "--" + user.getPhone());
    }
}
