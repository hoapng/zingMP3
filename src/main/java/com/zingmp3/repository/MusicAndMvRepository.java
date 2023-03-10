package com.zingmp3.repository;

import com.zingmp3.entity.MusicAndMv;
import com.zingmp3.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MusicAndMvRepository extends JpaRepository<MusicAndMv,Long> {

    @Query("select m from MusicAndMv m where m.type = 1 order by m.id desc")
    Page<MusicAndMv> findAllsMusic(Pageable pageable);

    @Query("select m from MusicAndMv m where m.type = 0 order by m.id desc")
    Page<MusicAndMv> findAllsMv(Pageable pageable);

    @Query(value = "select DISTINCT m.* from music_mv m inner join music_singer ms on ms.music_and_mv_id = m.id inner join category c on c.id = m.category_id\n" +
            "inner join singer s on s.id = ms.singer_id where m.name like ?1 or s.name like ?1 or c.name like ?1 order by m.id desc", nativeQuery = true)
    List<MusicAndMv> searchMusic(String param);

    @Query("select m from MusicAndMv m where m.type = 0 and (m.category.name like ?1 or m.name like ?1 or m.country.name like ?1) order by m.id desc")
    Page<MusicAndMv> searchMV(String param,Pageable pageable);

    @Query("select m from MusicAndMv m where m.type = 1 and m.category.id = ?1 order by m.id desc")
    Page<MusicAndMv> findMusicByCategory(Long cateId, Pageable pageable);

    @Query("select m from MusicAndMv m where m.category.id = ?1 order by m.id desc")
    List<MusicAndMv> findMusicByCategory(Long cateId);

    @Query("select m from MusicAndMv m where m.type = 0 and m.category.id = ?1 order by m.id desc")
    Page<MusicAndMv> findMvByCategory(Long cateId, Pageable pageable);

    @Query("select m from MusicAndMv m where m.type = 1 and m.country.id = ?1 order by m.id desc")
    Page<MusicAndMv> findMusicByCountry(Long countryId, Pageable pageable);

    @Query("select m from MusicAndMv m where m.type = 0 and m.country.id = ?1 order by m.id desc")
    Page<MusicAndMv> findMvByCountry(Long countryId, Pageable pageable);

    @Query(value = "SELECT * from music_mv where id > ?1 and type = 1 limit 1",nativeQuery = true)
    Optional<MusicAndMv> nextMv(Long id);

    @Query(value = "SELECT * from music_mv where id < ?1 and type = 1 order by id desc limit 1",nativeQuery = true)
    Optional<MusicAndMv> preMv(Long id);

    @Query(value = "SELECT m.* from favorites f INNER join music_mv m on m.id = f.music_and_mv_id\n" +
            "where f.music_and_mv_id > ?1 and f.user_id = ?2 and m.type = 1 limit 1",nativeQuery = true)
    Optional<MusicAndMv> nextMvByUser(Long id, Long userId);

    @Query(value = "SELECT m.* from favorites f INNER join music_mv m on m.id = f.music_and_mv_id\n" +
            "           where f.music_and_mv_id < ?1 and f.user_id = ?2 and m.type = 1 order by f.id desc limit 1",nativeQuery = true)
    Optional<MusicAndMv> preMvByUser(Long id, Long userId);

    @Query(value = "select * from music_mv limit 1 order by id desc",nativeQuery = true)
    MusicAndMv firstMusic();
}
