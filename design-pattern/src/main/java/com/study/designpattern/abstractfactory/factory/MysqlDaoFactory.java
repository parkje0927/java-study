package com.study.designpattern.abstractfactory.factory;

import com.study.designpattern.abstractfactory.domain.product.dao.ProductDao;
import com.study.designpattern.abstractfactory.domain.product.dao.mysql.ProductMysqlDao;
import com.study.designpattern.abstractfactory.domain.userinfo.dao.UserInfoDao;
import com.study.designpattern.abstractfactory.domain.userinfo.dao.mysql.UserInfoMysqlDao;

public class MysqlDaoFactory implements DaoFactory {

    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoMysqlDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new ProductMysqlDao();
    }
}
