package com.zingmp3.rest;

import com.zingmp3.entity.Favorites;
import com.zingmp3.entity.User;
import com.zingmp3.repository.FavoriteRepository;
import com.zingmp3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FavoriteRest {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/user/addFavosites")
    public Favorites save(@RequestBody Favorites favorites){
        User user = userService.getUserWithAuthority();
        favorites.setUser(user);
        Favorites result = favoriteRepository.save(favorites);
        return result;
    }

    @GetMapping("/user/myfavorite")
    public List<Favorites> findMusicByUser(){
        User user = userService.getUserWithAuthority();
        return favoriteRepository.findByUser(user.getId());
    }

    @GetMapping("/user/myfavoriteMv")
    public List<Favorites> findMvByUser(){
        User user = userService.getUserWithAuthority();
        return favoriteRepository.findMvByUser(user.getId());
    }

    @DeleteMapping("/user/deletefavorite")
    public void dleteByUser(@RequestParam("id") Long id) throws Exception {
        User user = userService.getUserWithAuthority();
        Favorites favorites = favoriteRepository.findById(id).get();
        if(favorites.getUser().getId() != user.getId()){
            throw new Exception(("access deneid"));
        }
        favoriteRepository.deleteById(id);
    }
}
