package com.study.designpattern.abstractfactory.factory;

import com.study.designpattern.abstractfactory.domain.product.dao.ProductDao;
import com.study.designpattern.abstractfactory.domain.product.dao.oracle.ProductOracleDao;
import com.study.designpattern.abstractfactory.domain.userinfo.dao.UserInfoDao;
import com.study.designpattern.abstractfactory.domain.userinfo.dao.oracle.UserInfoOracleDao;

public class OracleDaoFactory implements DaoFactory {

    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoOracleDao();
    }

    @Override
    public ProductDao createProductDao() {
        return new ProductOracleDao();
    }
}
