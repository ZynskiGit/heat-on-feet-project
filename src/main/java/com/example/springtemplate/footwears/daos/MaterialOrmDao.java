package com.example.springtemplate.footwears.daos;


import com.example.springtemplate.footwears.models.Footwear;

import com.example.springtemplate.footwears.models.Material;
import com.example.springtemplate.footwears.repositories.FootwearRepository;
import com.example.springtemplate.footwears.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MaterialOrmDao {
    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    FootwearRepository footwearRepository;

    @PostMapping("/api/materials")
    public Material createMaterial(@RequestBody Material material) {
        return MaterialRepository.save(material);
    }

    @PostMapping("/api/footwears/{footwearId}/materials")
    public Material createMaterialForFootwear(
            @PathVariable("footwearId") Integer fid,
            @RequestBody Material material) {
        material = materialRepository.save(material);
        Footwear footwear = footwearRepository.findById(fid).get();
        material.setFootwear(footwear);
        return materialRepository.save(material);
    }

    @GetMapping("/api/footwears/{fid}/materials")
    public List<Material> findMaterialsForFootwear(
            @PathVariable("fid") Integer footwearId) {
        Footwear footwear = footwearRepository.findById(footwearId).get();
        return footwear.getMaterials();
    }

    @GetMapping("/api/materials")
    public List<Material> findAllMaterials() {
        return (List<Material>) materialRepository.findAll();
    }

    @GetMapping("/api/materials/{materialId}")
    public Material findMaterialById(
            @PathVariable("materialId") Integer id) {
        return materialRepository.findById(id).get();
    }

    @PutMapping("/api/materials/{materialId}")
    public Material updateMaterial(
            @PathVariable("materialId") Integer id,
            @RequestBody() Material newMaterial) {
        Material material = this.findMaterialById(id);
        material.setMaterial(newMaterial.getMaterial());
        return materialRepository.save(material);
    }

    @DeleteMapping("/api/materials/{materialId}")
    public void deleteSection(
            @PathVariable("materialId") Integer id) {
        materialRepository.deleteById(id);
    }
}
