package com.example.springtemplate.footwears.daos;

import com.example.springtemplate.footwears.models.Brand;
import com.example.springtemplate.footwears.models.Footwear;
import com.example.springtemplate.footwears.repositories.BrandRepository;
import com.example.springtemplate.footwears.repositories.FootwearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BrandOrmDao {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    FootwearRepository footwearRepository;

    @PostMapping("/api/brands")
    public Brand createBrand(@RequestBody Brand brand) {
        return brandRepository.save(brand);
    }

    @PostMapping("/api/footwears/{footwearId}/brands")
    public Brand createBrandForFootwear(
            @PathVariable("footwearId") Integer fid,
            @RequestBody Brand brand) {
        brand = brandRepository.save(brand);
        Footwear footwear = footwearRepository.findById(fid).get();
        brand.setFootwear(footwear);
        return brandRepository.save(brand);
    }

    @GetMapping("/api/footwears/{fid}/brands")
    public List<Brand> findBrandsForFootwear(
            @PathVariable("fid") Integer footwearId) {
        Footwear footwear = footwearRepository.findById(footwearId).get();
        return footwear.getBrands();
    }

    @GetMapping("/api/brands")
    public List<Brand> findAllBrands() {
        return (List<Brand>) brandRepository.findAll();
    }

    @GetMapping("/api/brands/{brandId}")
    public Brand findBrandById(
            @PathVariable("brandId") Integer id) {
        return brandRepository.findById(id).get();
    }

    @PutMapping("/api/brands/{brandId}")
    public Brand updateBrand(
            @PathVariable("brandId") Integer id,
            @RequestBody() Brand newBrand) {
        Brand brand = this.findBrandById(id);
        brand.setName(newBrand.getName());
        return brandRepository.save(brand);
    }

    @DeleteMapping("/api/brands/{brandId}")
    public void deleteSection(
            @PathVariable("brandId") Integer id) {
        brandRepository.deleteById(id);
    }
}
