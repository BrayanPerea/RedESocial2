package com.example.Hackaton.Services;

import com.example.Hackaton.DTO.CommentDTO.CommentByUser;
import com.example.Hackaton.DTO.PublicationDTO.PublicationByUser;
import com.example.Hackaton.Exceptions.UnknownPublicationException;
import com.example.Hackaton.Repositories.PublicationByUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private PublicationByUserRepository publicationByUserRepository;

    @Autowired
    public UserService(PublicationByUserRepository publicationByUserRepository) {
        this.publicationByUserRepository = publicationByUserRepository;
    }


    public PublicationByUser publish(PublicationByUser publicationByUser){
        this.publicationByUserRepository.save(publicationByUser);
        return publicationByUser;
    }

    public void deletePublication(int idPublication) {
        publicationByUserRepository.deleteById(idPublication);
    }


    public List<PublicationByUser> searchPublicationsByTitle(String title) {
        return publicationByUserRepository.findByTitleContainingIgnoreCase(title);
    }
    public void updatePublication(int idPublication, PublicationByUser updatedPublication) {
        if (publicationByUserRepository.existsById(idPublication)) {
            updatedPublication.setIdPublication(idPublication);
            publicationByUserRepository.save(updatedPublication);
        } else {

            throw new UnknownPublicationException("La publicación con ID " + idPublication + " no existe.");
        }
    }






}

