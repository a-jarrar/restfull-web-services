package com.shopingcart.rest.services.restfullwebservices.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BrandResource {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandServices brandServices;

    @GetMapping("/brands")
    public List<BrandModel> retrieveAllBrands(Pageable pageable) {
        return brandRepository.findAll(pageable).stream().map(BrandMapper.INSTANCE::entityToModel).collect(Collectors.toList());
    }

    @GetMapping("/brands/{brandId}")
    public Optional<BrandModel> retrieveBrand(@PathVariable Integer brandId) {

        return brandRepository.findById(brandId).map(BrandMapper.INSTANCE::entityToModel);
    }

    @PostMapping("/brands")
    public BrandModel createBrand(@RequestBody BrandModel brandModel) {
        return BrandMapper.INSTANCE
                .entityToModel(brandRepository.save(BrandMapper.INSTANCE.modelToEntity(brandModel)));
    }

    @DeleteMapping("/brands/{brandId}")
    public void deleteBrand(@PathVariable Integer brandId) {
        brandRepository.deleteById(brandId);
    }

    @PutMapping("/brands/{brandId}")
    public BrandModel updateBrand(@PathVariable Integer brandId, @RequestBody BrandModel brandModel) {
        return brandServices.updateBrand(brandId, brandModel);
    }
}
