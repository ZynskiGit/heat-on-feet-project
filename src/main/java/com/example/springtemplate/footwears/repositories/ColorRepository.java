package com.example.springtemplate.footwears.repositories;

import com.example.springtemplate.footwears.models.Color;
import com.example.springtemplate.footwears.models.Footwear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColorRepository extends CrudRepository<Color, Integer> {
    @Query(value = "SELECT * FROM colors",
            nativeQuery = true)
    public List<Color> findAllColors();
    @Query(value = "SELECT * FROM colors WHERE id=:c_id",
            nativeQuery = true)
    public Color findColorById(@Param("colorId") Integer id);
    @Query(value = "REMOVE * FROM colors WHERE id=:c_id",
            nativeQuery = true)
    public Color deleteById(@Param("colorId") Integer id);
    public Footwear findById(@Param("footwearId") Integer id);
}
