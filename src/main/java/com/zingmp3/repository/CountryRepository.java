package com.zingmp3.repository;

import com.zingmp3.entity.Country;
import com.zingmp3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
