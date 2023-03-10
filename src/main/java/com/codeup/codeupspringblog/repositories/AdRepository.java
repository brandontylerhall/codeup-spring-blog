package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> /*inside brackets, add data type the repo is referencing (ad) and the data type of the id (long)*/ {
    Ad findAdByTitle(String title);
    Ad findAdById(long id);
    @Query("from Ad a where a.title like %:term%")
    List<Ad> searchByTitleLike(@Param("term") String term);
}
