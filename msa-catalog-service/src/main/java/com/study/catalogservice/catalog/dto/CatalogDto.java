package com.study.catalogservice.catalog.dto;

import java.io.Serializable;

//NOTE 추후에 삭제해도 될듯
public class CatalogDto implements Serializable {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private String orderId;
    private String userId;
}
