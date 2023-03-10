package com.zingmp3.repository;

import com.zingmp3.entity.Singer;
import com.zingmp3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer,Long> {
}
