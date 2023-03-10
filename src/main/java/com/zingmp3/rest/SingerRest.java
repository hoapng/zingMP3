package com.zingmp3.rest;

import com.zingmp3.entity.Category;
import com.zingmp3.entity.Singer;
import com.zingmp3.repository.CategoryRepository;
import com.zingmp3.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SingerRest {

    @Autowired
    private SingerRepository singerRepository;

    @GetMapping("/public/singers")
    public List<Singer> findAll(){
        return singerRepository.findAll();
    }

    @GetMapping("/public/singersById")
    public Singer findById(@RequestParam("id") Long id){
        return singerRepository.findById(id).get();
    }

    @PostMapping("/admin/addsinger")
    public void addsinger(@RequestBody Singer singer){
        singerRepository.save(singer);
    }

    @DeleteMapping("/admin/deletesinger")
    public void deletesinger(@RequestParam("id") Long id){
        singerRepository.deleteById(id);
    }
}
