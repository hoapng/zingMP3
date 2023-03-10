package com.zingmp3.repository;

import com.zingmp3.entity.Category;
import com.zingmp3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
