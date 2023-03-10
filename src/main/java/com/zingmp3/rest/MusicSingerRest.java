package com.zingmp3.rest;


import com.zingmp3.entity.MusicSinger;
import com.zingmp3.repository.MusicSingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MusicSingerRest {

    @Autowired
    private MusicSingerRepository musicSingerRepository;

    @PostMapping("/admin/addMusicSinger")
    public void save(@RequestBody MusicSinger musicSinger){
        musicSingerRepository.save(musicSinger);
    }

    @GetMapping("/public/musicSingerByMusicId")
    public List<MusicSinger> findByMusicId(@RequestParam("id") Long id){
        return musicSingerRepository.findByMusicId(id);
    }


}
