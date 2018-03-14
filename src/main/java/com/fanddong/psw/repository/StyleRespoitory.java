package com.fanddong.psw.repository;

import com.fanddong.psw.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRespoitory extends JpaRepository<Style, String> {

    @Query("select styleName from style where id = ?1")
    String findStyleById(String id);
}
