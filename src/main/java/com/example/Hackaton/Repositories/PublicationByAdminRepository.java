package com.example.Hackaton.Repositories;

import com.example.Hackaton.DTO.PublicationDTO.PublicationByAdmin;
import com.example.Hackaton.Services.AdminService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationByAdminRepository extends JpaRepository<PublicationByAdmin, Integer> {

    @Query("SELECT p FROM PublicationByAdmin p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<PublicationByAdmin> searchPublicationsByTitle(String title);
}
