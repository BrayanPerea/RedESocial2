package com.example.Hackaton.Controllers;


import com.example.Hackaton.DTO.PublicationDTO.PublicationByAdmin;
import com.example.Hackaton.Exceptions.UnknownPublicationException;
import com.example.Hackaton.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/publish")
    public ResponseEntity<PublicationByAdmin> publishPublicationByAdmin(@RequestBody PublicationByAdmin publicationByAdmin) {
        adminService.publish(publicationByAdmin);
        return ResponseEntity.ok(publicationByAdmin);
    }

    @GetMapping("/publications/search")
    public List<PublicationByAdmin> searchPublicationsByTitle(@RequestParam String title) {
        return adminService.searchPublicationsByTitle(title);
    }

    @DeleteMapping("/delete/{idPublication}")
    public ResponseEntity<Void> deletePublicationById(@PathVariable int idPublication) {
        adminService.deletePublication(idPublication);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update/{idPublication}")
    public ResponseEntity<String> updatePublicationById(
            @PathVariable int idPublication,
            @RequestBody PublicationByAdmin updatedPublication) {
        try {
            adminService.updatePublication(idPublication, updatedPublication);
            return ResponseEntity.ok("Publicación actualizada correctamente");
        } catch (UnknownPublicationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicación no encontrada");
        }
    }
}
