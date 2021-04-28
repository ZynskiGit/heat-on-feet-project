package com.example.springtemplate.footwears.repositories;

import com.example.springtemplate.footwears.models.Brand;
import com.example.springtemplate.footwears.models.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    @Query(value = "SELECT * FROM brands",
            nativeQuery = true)
    public List<Brand> findAllBrands();
    @Query(value = "SELECT * FROM materials WHERE id=:b_id",
            nativeQuery = true)
    public Brand findBrandById(@Param("brandId") Integer id);
    @Query(value = "REMOVE * FROM brands WHERE id=:b_id",
            nativeQuery = true)
    public Brand deleteById(@Param("brandId") Integer id);
    public Brand findById(@Param("brandId") Integer id);
}
