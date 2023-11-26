package com.example.Hackaton.Services;

import com.example.Hackaton.DTO.PublicationDTO.PublicationByAdmin;
import com.example.Hackaton.Exceptions.UnknownPublicationException;
import com.example.Hackaton.Repositories.PublicationByAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private PublicationByAdminRepository publicationByAdminRepository;


    @Autowired
    public AdminService(PublicationByAdminRepository publicationByAdminRepository){
        this.publicationByAdminRepository = publicationByAdminRepository;
    }

    public PublicationByAdmin publish(PublicationByAdmin publicationByAdmin) {


        return publicationByAdminRepository.save(publicationByAdmin);
    }

    public void deletePublication(int idPublication) {
        publicationByAdminRepository.deleteById(idPublication);
    }

    public List<PublicationByAdmin> searchPublicationsByTitle(String title) {
        return publicationByAdminRepository.searchPublicationsByTitle(title);
    }

    public void updatePublication(int idPublication, PublicationByAdmin updatedPublication) {
        if (publicationByAdminRepository.existsById(idPublication)) {
            updatedPublication.setIdPublication(idPublication);
            publicationByAdminRepository.save(updatedPublication);
        } else {
            throw new UnknownPublicationException("La publicación con ID " + idPublication + " no existe.");
        }
    }



}
