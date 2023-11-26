package com.example.Hackaton.DTO.PublicationDTO;

import com.example.Hackaton.DTO.UserDTO.User;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Entity
@Table(name = "publicationsByUsers")
public class PublicationByUser {

    @Id
    private int idPublication;

    @Column
    public String title;

    @Column
    public String content;

    @ManyToOne
    @JoinColumn(name = "userDni")
    private User dni;

    public void setUser(User user) {
        this.dni = user;
    }
}
