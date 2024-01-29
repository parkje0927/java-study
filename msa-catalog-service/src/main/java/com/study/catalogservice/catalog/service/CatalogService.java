package com.study.catalogservice.catalog.service;

import com.study.catalogservice.catalog.domain.CatalogEntity;

public interface CatalogService {

    Iterable<CatalogEntity> getAllCatalogs();
}
