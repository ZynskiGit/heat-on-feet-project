package com.example.springtemplate.footwears.daos;

import com.example.springtemplate.footwears.models.Footwear;
import com.example.springtemplate.footwears.repositories.FootwearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FootwearOrmDao {
    @Autowired
    FootwearRepository footwearRepository;

    @PostMapping("/api/footwears")
    public Footwear createFootwear(@RequestBody Footwear footwear) {
        return footwearRepository.save(footwear);
    }

    @GetMapping("/api/footwears")
    public List<Footwear> findAllFootwears() {
        return (List<Footwear>) footwearRepository.findAll();
    }

    @GetMapping("/api/footwears/{footwearId}")
    public Footwear findFootwearById(
            @PathVariable("footwearId") Integer id) {
        return footwearRepository.findById(id).get();
    }

    @GetMapping("/api/update/footwear/{footwearId}/{password}")
    public Footwear updateFootwear(
            @PathVariable("footwearId") Integer id,
            @PathVariable("name") String newName) {
        Footwear footwear = this.findFootwearById(id);
        footwear.setName(newName);
        return footwearRepository.save(footwear);
    }

    @PutMapping("/api/footwears/{footwearId}")
    public Footwear updateFootwear(
            @PathVariable("footwearId") Integer id,
            @RequestBody() Footwear newFootwear) {
        Footwear footwear = this.findFootwearById(id);
        footwear.setName(newFootwear.getName());
        return footwearRepository.save(footwear);
    }

    @DeleteMapping("/api/footwears/{footwearId}")
    public void deleteCourse(
            @PathVariable("courseId") Integer id) {
        footwearRepository.deleteById(id);
    }

}
