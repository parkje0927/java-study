package com.study.designpattern.abstractfactory.factory;

import com.study.designpattern.abstractfactory.domain.product.dao.ProductDao;
import com.study.designpattern.abstractfactory.domain.userinfo.dao.UserInfoDao;

public interface DaoFactory {

    UserInfoDao createUserInfoDao();

    ProductDao createProductDao();
}
