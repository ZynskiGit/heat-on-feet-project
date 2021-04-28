package com.example.springtemplate.footwears.repositories;

import com.example.springtemplate.footwears.models.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialRepository extends CrudRepository<Material, Integer> {
    @Query(value = "SELECT * FROM materials",
            nativeQuery = true)
    public List<Material> findAllMaterials();
    @Query(value = "SELECT * FROM materials WHERE id=:mat_id",
            nativeQuery = true)
    public Material findMaterialById(@Param("materialId") Integer id);
    @Query(value = "REMOVE * FROM materials WHERE id=:mat_id",
            nativeQuery = true)
    public Material deleteById(@Param("materialId") Integer id);
    public Material findById(@Param("materialId") Integer id);
}
