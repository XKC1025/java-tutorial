package com.xkc.learn.mybatis;

import com.xkc.learn.mybatis.dao.EmpMapper;
import com.xkc.learn.mybatis.dao.UserMapper;
import com.xkc.learn.mybatis.domain.EmpModel;
import com.xkc.learn.mybatis.domain.OrderModel;
import com.xkc.learn.mybatis.domain.UserModel;
import com.xkc.learn.mybatis.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MyBatisMain {
    private SqlSession sqlSession;

    @Before
    public void init() { // 初始化sqlSession
        // 读取配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 创建Session
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void destroy() {
        // 关闭Session
        sqlSession.close();
    }

    @Test
    public void testSelectOne() {
        // 调用SqlSession操作数据库的方法
        UserModel user = sqlSession.selectOne("findUserById", 1);
        System.out.println(user);
    }

    @Test
    public void testSelectList() {
        // 查找集合
        List<UserModel> users = sqlSession.selectList("findUserByUserName", "00");
        System.out.println(users);
    }

    @Test
    public void testInsert() {
        // 插入
        UserModel userModel = new UserModel("Xukechen", "male", new Date(), "Nanjing");
        int insert = sqlSession.insert("insertUser", userModel);
        System.out.println(insert);

        // 提交事务
        sqlSession.commit();
    }

    @Test
    public void testDelete() {
        // 删除
        int delete = sqlSession.delete("deleteUser", "Xukechen");
        sqlSession.commit();
        System.out.println(delete);
    }

    @Test
    public void testUpdate() {
        // 更新
        UserModel userModel = new UserModel(20, "XUKECHEN", "male", new Date(), "Nanjing");
        int update = sqlSession.update("updateUser", userModel);
        sqlSession.commit();
        System.out.println(update);
    }

    @Test
    public void testPrimaryKey() {
        // 返回自增长主键
        // 两种方式
        UserModel userModel = new UserModel("Xukechen", "male", new Date(), "Nanjing");

        int count = sqlSession.insert("getPrimaryKey1", userModel);
        System.out.println(count);

        sqlSession.commit();

        System.out.println("用户id: " + userModel.getId());
    }

    // 使用动态代理对象会导致testPrimaryKey()方法命名空间发生冲突
    @Test
    public void testMapper() {
        // 获取Proxy动态代理对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        System.out.println(mapper.getClass());

        EmpModel emp = mapper.findEmpById(1);
        System.out.println(emp);

        emp = new EmpModel("empTest", "f", 12356D, new Date(), 1);
        int i = mapper.insertEmp(emp);

        sqlSession.commit();
        System.out.println(i);
        System.out.println(emp.getId());

        List<EmpModel> emps = mapper.findEmpByEmpName("emp");
        System.out.println(emps);
    }

    @Test
    public void testUserQueryVO() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVO userQueryVO = new UserQueryVO(
                new UserModel(32, "", "", new Date(), ""),
                new OrderModel(5, 1, 5000, new Date()));

        List<UserModel> users = mapper.findByUserQueryVO(userQueryVO);

        System.out.println(users);
    }

    @Test
    public void testMap() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 通过Map查询
        Map<String, Object> map = new HashMap<>();
        map.put("username", "x");
        map.put("sex", "male");

        List<UserModel> users = mapper.findByMap(map);
        System.out.println(users);
    }

    @Test
    public void testCount() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int userCount = mapper.findUserCount();

        System.out.println(userCount);
    }

    @Test
    public void testResultMap() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserModel user = mapper.findByResultMap(20);

        System.out.println(user);
    }

    @Test
    public void testIfWhere() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserModel user = new UserModel("xu", "fe", new Date(), "");
        OrderModel order = new OrderModel();

        List<UserModel> users = mapper.findByIfWhere(new UserQueryVO(user, order));

        System.out.println(users);
    }

    @Test
    public void testForEach() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVO userQueryVO = new UserQueryVO();

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(31);
        integers.add(32);
        integers.add(33);
        integers.add(34);
        integers.add(35);

        userQueryVO.setIds(integers);
        List<UserModel> users = mapper.findByForEach(userQueryVO);

        System.out.println(users);
    }

    @Test
    public void testForEach2() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(31);
        integers.add(32);
        integers.add(33);
        integers.add(34);
        integers.add(35);

        // 传入List集合
        List<UserModel> users = mapper.findByForEach2(integers);

        System.out.println(users);
    }

    /**
     * 懒加载
     */
    @Test
    public void testLazyLoading() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<OrderModel> orders = mapper.findOrderAndUserByLazyLoading();

        orders.forEach(System.out::println);

        System.out.println(orders.get(0).getUser());
    }
}
