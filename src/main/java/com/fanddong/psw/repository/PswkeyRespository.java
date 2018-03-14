package com.fanddong.psw.repository;

import com.fanddong.psw.entity.Pswkey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PswkeyRespository extends JpaRepository<Pswkey, String>{

    /**
     * 根据关键词模糊匹配
     * @param keyword
     * @return
     */
    @Query(value = "SELECT * FROM pswkey WHERE usrname LIKE CONCAT('%',:keyword,'%') OR psw LIKE CONCAT('%',:keyword,'%') OR style LIKE CONCAT('%',:keyword,'%') OR remark LIKE CONCAT('%',:keyword,'%') OR address LIKE CONCAT('%',:keyword,'%')", nativeQuery = true)
    List<Pswkey> findByKeyword(@Param("keyword") String keyword);
}
