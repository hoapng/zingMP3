package com.zingmp3.rest;

import com.zingmp3.entity.*;
import com.zingmp3.repository.FavoriteRepository;
import com.zingmp3.repository.MusicAndMvRepository;
import com.zingmp3.repository.MusicSingerRepository;
import com.zingmp3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MusicAndMvRest {

    @Autowired
    private MusicAndMvRepository musicAndMvRepository;

    @Autowired
    private MusicSingerRepository musicSingerRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/public/nextMusic")
    public MusicAndMv nextMusic(@RequestParam("id") Long id) throws Exception {
        try {
            User user = userService.getUserWithAuthority();
            Optional<MusicAndMv> musicAndMv = musicAndMvRepository.nextMvByUser(id, user.getId());
            if(musicAndMv.isPresent()){
                return musicAndMv.get();
            }
            musicAndMv =  musicAndMvRepository.nextMv(id);
            if(musicAndMv.isPresent()){
                return musicAndMv.get();
            }
            throw new Exception("da het music");
        }catch (Exception e){
            Optional<MusicAndMv> musicAndMv = musicAndMvRepository.nextMv(id);
            if(musicAndMv.isPresent() == false){
                throw new Exception("da het music");
            }
            return musicAndMv.get();
        }
    }

    @GetMapping("/public/preMusic")
    public MusicAndMv preMusic(@RequestParam("id") Long id) throws Exception {
        try {
            User user = userService.getUserWithAuthority();
            Optional<MusicAndMv> musicAndMv = musicAndMvRepository.preMvByUser(id, user.getId());
            if(musicAndMv.isPresent()){
                return musicAndMv.get();
            }
            musicAndMv =  musicAndMvRepository.preMv(id);
            if(musicAndMv.isPresent()){
                return musicAndMv.get();
            }
            throw new Exception("da het music");
        }catch (Exception e){
            Optional<MusicAndMv> musicAndMv = musicAndMvRepository.preMv(id);
            if(musicAndMv.isPresent() == false){
                throw new Exception("da het music");
            }
            return musicAndMv.get();
        }
    }

    @GetMapping("/public/getFirstMusic")
    public MusicAndMv getFirstMusic() throws Exception {
        return musicAndMvRepository.firstMusic();
    }


    @GetMapping("/public/getAllMusic")
    public Page<MusicAndMv> getAllMusic(Pageable pageable){
        return musicAndMvRepository.findAllsMusic(pageable);
    }

    @GetMapping("/public/getAllMusicAdmin")
    public List<MusicAndMv> getAllMusic(){
        return musicAndMvRepository.findAll();
    }

    @GetMapping("/public/getAllMv")
    public Page<MusicAndMv> getAllMv(Pageable pageable){
        return musicAndMvRepository.findAllsMv(pageable);
    }

    @GetMapping("/public/searchAllMusic")
    public List<MusicAndMv> searchAllMusic(@RequestParam("search") String s){
        return musicAndMvRepository.searchMusic("%"+s+"%");
    }

    @GetMapping("/public/searchAllMusicByCate")
    public List<MusicAndMv> searchAllMusicByCate(@RequestParam("id") Long id){
        return musicAndMvRepository.findMusicByCategory(id);
    }

    @GetMapping("/public/searchAllMV")
    public Page<MusicAndMv> searchAllMV(Pageable pageable, @RequestParam("search") String s){
        return musicAndMvRepository.searchMV("%"+s+"%",pageable);
    }

    @GetMapping("/public/findMusicByCategory")
    public Page<MusicAndMv> findMusicByCategory(Pageable pageable, @RequestParam("id") Long id){
        return musicAndMvRepository.findMusicByCategory(id ,pageable);
    }

    @GetMapping("/public/findMvByCategory")
    public Page<MusicAndMv> findMvByCategory(Pageable pageable, @RequestParam("id") Long id){
        return musicAndMvRepository.findMvByCategory(id ,pageable);
    }

    @GetMapping("/public/findMusicByCountry")
    public Page<MusicAndMv> findMusicByCountry(Pageable pageable, @RequestParam("id") Long id){
        return musicAndMvRepository.findMusicByCountry(id ,pageable);
    }

    @GetMapping("/public/findMvByCountry")
    public Page<MusicAndMv> findMvByCountry(Pageable pageable, @RequestParam("id") Long id){
        return musicAndMvRepository.findMvByCountry(id ,pageable);
    }

    @GetMapping("/public/getMusicAndMvById")
    public MusicAndMv findById(@RequestParam("id") Long id){
        return musicAndMvRepository.findById(id).get();
    }

    @PostMapping("/admin/addMusicAndMv")
    public MusicAndMv addMusicAndMv(@RequestBody MusicAndMv musicAndMv){
        if(musicAndMv.getId() != null){
            List<MusicSinger> list = musicSingerRepository.findByMusicId(musicAndMv.getId());
            for(MusicSinger m : list){
                musicSingerRepository.deleteById(m.getId());
            }
        }
        musicAndMv.setBlock(0);
        musicAndMv.setCreatedDate(new Date(System.currentTimeMillis()));
        musicAndMv.setNumViews(0);
        MusicAndMv result = musicAndMvRepository.save(musicAndMv);
        return result;
    }

    @PostMapping("/admin/updateMusicAndMv")
    public MusicAndMv updateMusicAndMv(@RequestBody MusicAndMv musicAndMv){
        MusicAndMv m = musicAndMvRepository.findById(musicAndMv.getId()).get();
        musicAndMv.setBlock(m.getBlock());
        musicAndMv.setCreatedDate(m.getCreatedDate());
        musicAndMv.setNumViews(m.getNumViews());
        MusicAndMv result = musicAndMvRepository.save(musicAndMv);
        return result;
    }

    @DeleteMapping("/admin/deleteMusicAndMv")
    public void deleteMusicAndMv(@RequestParam("id") Long id){
        List<MusicSinger> list = musicSingerRepository.findByMusicId(id);
        for(MusicSinger m : list){
            musicSingerRepository.deleteById(m.getId());
        }
        List<Favorites> l = favoriteRepository.findByMusicId(id);
        for(Favorites f : l){
            favoriteRepository.deleteById(f.getId());
        }
        musicAndMvRepository.deleteById(id);
    }
}
