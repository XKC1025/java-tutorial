package com.xkc.learn.mybatis;

import com.alibaba.fastjson.JSON;
import com.xkc.learn.mybatis.dao.OrderMapper;
import com.xkc.learn.mybatis.domain.UserModel;
import com.xkc.learn.mybatis.vo.OrdersExt;
import com.xkc.learn.mybatis.vo.OrdersVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderMain {
    private SqlSession sqlSession;
    private OrderMapper mapper;

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

        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void destroy() {
        // 关闭Session
        sqlSession.close();
    }


    /**
     * 订单对用户  一对一
     */
    @Test
    public void testFindOrderExtById() {
        OrdersExt orderInfo = mapper.findOrderExtById(9);

        System.out.println(orderInfo);
    }

    @Test
    public void testFindOrderVOById() {
        OrdersVO orderInfo = mapper.findOrderVOById(9);

        System.out.println(orderInfo);
    }

    /**
     * 订单对商品  一对多
     */
    @Test
    public void testOrderDetail() {
        List<OrdersVO> orderInfo = mapper.findOrderDetailById(3);

        System.out.println(orderInfo);
    }

    /**
     * 用户信息及商品信息   多对多
     * UserModel中封装List<OrderModel>
     * OrderModel中封装items商品信息
     */
    @Test
    public void testFindUserAndOrder() {
        List<UserModel> userAndOrder = mapper.findUserAndOrder(1);

        System.out.println(JSON.toJSON(userAndOrder));
    }
}
