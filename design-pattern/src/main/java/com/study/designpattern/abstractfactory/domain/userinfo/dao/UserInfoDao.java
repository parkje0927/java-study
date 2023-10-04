package com.study.designpattern.abstractfactory.domain.userinfo.dao;

import com.study.designpattern.abstractfactory.domain.userinfo.UserInfo;

public interface UserInfoDao {

    void insertUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void deleteUserInfo(UserInfo userInfo);
}
