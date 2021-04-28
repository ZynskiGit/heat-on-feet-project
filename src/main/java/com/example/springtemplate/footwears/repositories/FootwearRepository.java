package com.example.springtemplate.footwears.repositories;

import com.example.springtemplate.footwears.models.Footwear;
import com.example.springtemplate.footwears.models.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FootwearRepository extends CrudRepository<Footwear, Integer> {
    @Query(value = "SELECT * FROM footwears",
            nativeQuery = true)
    public List<Footwear> findAllFootwears();
    @Query(value = "SELECT * FROM footwears WHERE id=:f_id",
            nativeQuery = true)
    public Footwear findFootwearById(@Param("footwearId") Integer id);
    @Query(value = "REMOVE * FROM footwears WHERE id=:f_id",
            nativeQuery = true)
    public Footwear deleteById(@Param("footwearId") Integer id);
    public Footwear findById(@Param("footwearId") Integer id);
}
