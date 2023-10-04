package com.study.designpattern.abstractfactory.domain.product.dao;

import com.study.designpattern.abstractfactory.domain.product.Product;

public interface ProductDao {

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);
}
