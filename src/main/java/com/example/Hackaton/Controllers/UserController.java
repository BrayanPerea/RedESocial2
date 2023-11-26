package com.example.Hackaton.Controllers;


import com.example.Hackaton.DTO.PublicationDTO.PublicationByUser;
import com.example.Hackaton.DTO.UserDTO.User;
import com.example.Hackaton.Exceptions.UnknownPublicationException;
import com.example.Hackaton.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/publish")
    public ResponseEntity<PublicationByUser> publishPublicationByUser(@RequestBody PublicationByUser publicationByUser) {
        userService.publish(publicationByUser);
        return ResponseEntity.ok(publicationByUser);
    }

    @GetMapping("/publications/search")
    public List<PublicationByUser> searchPublicationsByTitle(@RequestParam String title) {
        return userService.searchPublicationsByTitle(title);
    }

    @DeleteMapping("/publications/{id}")
    public void deletePublication(@PathVariable int idPublication) {
        userService.deletePublication(idPublication);
    }


    @PutMapping("/{idPublication}")
    public ResponseEntity<String> updatePublication(
            @PathVariable int idPublication,
            @RequestBody PublicationByUser updatedPublication) {
        try {
            userService.updatePublication(idPublication, updatedPublication);
            return ResponseEntity.ok("Publicación actualizada correctamente");
        } catch (UnknownPublicationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicación no encontrada");
        }
    }
}
