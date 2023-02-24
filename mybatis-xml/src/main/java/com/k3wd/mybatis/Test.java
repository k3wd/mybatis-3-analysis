package com.k3wd.mybatis;

import com.k3wd.mybatis.mapper.UsersMapper;
import com.k3wd.mybatis.model.Users;
import lombok.extern.slf4j.Slf4j;
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
        //InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml");

        //第二步：构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第三步：打开SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        //第四步：获取Mapper接口对象
        // targetProxy.getProxy()
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        
        //第五步：调用Mapper接口对象的方法操作数据库；
//        List<Users> usersList = usersMapper.listByPrimaryKey(new RowBounds(2,3));
        // proxy.selectByPrimaryKey
        Users user = usersMapper.selectByPrimaryKey(1);

        //第六步：业务处理
//        log.info("查询结果: " + user.getId() + "--" + user.getPhone());
        
        //session提交并关闭
        session.commit();
        session.close();
    }
}
