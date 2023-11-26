package com.example.Hackaton.DTO.PublicationDTO;

import com.example.Hackaton.DTO.AdminDTO.Admin;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "publicationsByAdmins")
public class PublicationByAdmin {

    @Id
    private int idPublication;

    @Column
    public String title;

    @Column
    public String content;

    @ManyToOne
    @JoinColumn(name = "adminDni")
    private Admin dni;

    public void setAdmin(Admin admin) {
        this.dni = admin;
    }


}
