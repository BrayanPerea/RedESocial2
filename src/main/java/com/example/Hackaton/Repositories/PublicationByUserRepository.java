package com.example.Hackaton.Repositories;

import com.example.Hackaton.DTO.PublicationDTO.PublicationByUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;



@Repository
public interface PublicationByUserRepository extends JpaRepository<PublicationByUser, Integer> {


    @Query("SELECT p FROM PublicationByUser p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<PublicationByUser> findByTitleContainingIgnoreCase(@Param("title") String title);

}
