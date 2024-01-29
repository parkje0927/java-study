package com.study.catalogservice.catalog.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.study.catalogservice.catalog.domain.CatalogEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CatalogResponse(

        String productId,
        String productName,
        Integer unitPrice,
        Integer stock,
        LocalDateTime createdAt
) {

    public static CatalogResponse from(CatalogEntity catalogEntity) {
        return CatalogResponse.builder()
                .productId(catalogEntity.productId())
                .productName(catalogEntity.productName())
                .unitPrice(catalogEntity.unitPrice())
                .stock(catalogEntity.stock())
                .createdAt(catalogEntity.getCreatedAt())
                .build();
    }
}
