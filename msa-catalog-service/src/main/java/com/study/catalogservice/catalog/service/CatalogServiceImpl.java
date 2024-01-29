package com.study.catalogservice.catalog.service;

import com.study.catalogservice.catalog.domain.CatalogEntity;
import com.study.catalogservice.catalog.domain.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
