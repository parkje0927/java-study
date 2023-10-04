package com.study.designpattern.abstractfactory;

import com.study.designpattern.abstractfactory.domain.product.Product;
import com.study.designpattern.abstractfactory.domain.product.dao.ProductDao;
import com.study.designpattern.abstractfactory.domain.userinfo.UserInfo;
import com.study.designpattern.abstractfactory.domain.userinfo.dao.UserInfoDao;
import com.study.designpattern.abstractfactory.factory.DaoFactory;
import com.study.designpattern.abstractfactory.factory.MysqlDaoFactory;

public class AbstractFactoryTest {

    /**
     * 틀이 있고, set 가 있어서 이 set 을 만들어주는 공장이 있다.
     * 여러 제품군을 한꺼번에 생성하는 패턴
     * ex) 위젯을 생성하여 보여줄 때 선택한 옵션에 따라 위젯의 set 이 달라질 수 있도록 한다.
     * ex) a 공장에서 b 공장으로 바뀌면 그에 딸린 set 가 다 바뀐다.
     * <p>
     * client 는 factory 만 선택
     * 이 클래스가 client 라고 가정!
     *
     * ---
     * 일반적으로 ConcreteFactory 클래스의 인스턴스는 실행할 때 만들어진다.
     * 구체적 팩토리는 어떤 특정 구현을 갖는 제품 객체를 생성한다. 서로 다른 제품 객체를 생성하기 위해서 사용자는 서로 다른 ConcreteFactory 를 사용한다.
     * AbstractFactory 는 ConcreteFactory 서브 클래스를 통해 필요한 제품 객체를 생성하는 책임을 위임한다.
     */

    public static void main(String[] args) {
        Product product = new Product();
        product.setProductId("123");
        product.setProductName("test");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("testUser");
        userInfo.setUsername("testUserName");
        userInfo.setPassword("testUserPassword");

        DaoFactory daoFactory = null;

        //yml 파일에 MYSQL 이라고 있다고 가정
        daoFactory = new MysqlDaoFactory();

        ProductDao productDao = daoFactory.createProductDao();

        UserInfoDao userInfoDao = daoFactory.createUserInfoDao();

        //비즈니스 로직 수행
    }

}
