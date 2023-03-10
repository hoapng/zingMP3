package com.zingmp3.repository;

import com.zingmp3.entity.Favorites;
import com.zingmp3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorites,Long> {

    @Query("select f from Favorites f where f.user.id = ?1 and f.musicAndMv.type = 1")
    public List<Favorites> findByUser(Long userId);

    @Query("select f from Favorites f where f.user.id = ?1 and f.musicAndMv.type = 0")
    public List<Favorites> findMvByUser(Long userId);

    @Query("select f from Favorites f where f.musicAndMv.id = ?1")
    public List<Favorites> findByMusicId(Long MusicId);
}
