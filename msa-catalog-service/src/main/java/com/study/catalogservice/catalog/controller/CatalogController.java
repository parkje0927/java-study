package com.study.catalogservice.catalog.controller;

import com.study.catalogservice.catalog.domain.CatalogEntity;
import com.study.catalogservice.catalog.dto.response.CatalogResponse;
import com.study.catalogservice.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/health-check")
    public String status() {
        return "health-check";
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<CatalogResponse>> getCatalogs() {
        Iterable<CatalogEntity> catalogs = catalogService.getAllCatalogs();

        List<CatalogResponse> result = new ArrayList<>();
        catalogs.forEach(catalogEntity -> result.add(CatalogResponse.from(catalogEntity)));

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
