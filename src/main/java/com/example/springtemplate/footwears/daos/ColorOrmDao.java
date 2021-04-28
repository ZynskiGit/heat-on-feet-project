package com.example.springtemplate.footwears.daos;

import com.example.springtemplate.footwears.models.Color;
import com.example.springtemplate.footwears.models.Footwear;
import com.example.springtemplate.footwears.repositories.ColorRepository;
import com.example.springtemplate.footwears.repositories.FootwearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ColorOrmDao {
    @Autowired
    ColorRepository colorRepository;

    @Autowired
    FootwearRepository footwearRepository;

    @PostMapping("/api/colors")
    public Color createColor(@RequestBody Color color) {
        return colorRepository.save(color);
    }

    @PostMapping("/api/footwears/{footwearId}/colors")
    public Color createColorForFootwear(
            @PathVariable("footwearId") Integer fid,
            @RequestBody Color color) {
        color = colorRepository.save(color);
        Footwear footwear = footwearRepository.findById(fid).get();
        color.setFootwear(footwear);
        return colorRepository.save(color);
    }

    @GetMapping("/api/footwears/{fid}/colors")
    public List<Color> findColorsForFootwear(
            @PathVariable("fid") Integer footwearId) {
        Footwear footwear = footwearRepository.findById(footwearId).get();
        return footwear.getColors();
    }

    @GetMapping("/api/colors")
    public List<Color> findAllColors() {
        return (List<Color>) colorRepository.findAll();
    }

    @GetMapping("/api/colors/{colorId}")
    public Color findColorById(
            @PathVariable("colorId") Integer id) {
        return colorRepository.findById(id).get();
    }

    @PutMapping("/api/colors/{colorId}")
    public Color updateColor(
            @PathVariable("colorId") Integer id,
            @RequestBody() Color newColor) {
        Color color = this.findColorById(id);
        color.setColor(newColor.getColor());
        return colorRepository.save(color);
    }

    @DeleteMapping("/api/colors/{colorId}")
    public void deleteSection(
            @PathVariable("colorId") Integer id) {
        colorRepository.deleteById(id);
    }
}
