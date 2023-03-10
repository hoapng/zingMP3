package com.zingmp3.repository;

import com.zingmp3.entity.Country;
import com.zingmp3.entity.MusicSinger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicSingerRepository extends JpaRepository<MusicSinger,Long> {

    @Query("select m from MusicSinger m where m.musicAndMv.id = ?1")
    public List<MusicSinger> findByMusicId(Long id);
}
