package com.example.Hackaton.DTO.CommentDTO;


import com.example.Hackaton.DTO.AdminDTO.Admin;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commentByAdmin")
public class CommentByAdmin {

    @Id
    private int idComment;

    @Column
    public String title;

    @Column
    public String content;

    @ManyToOne
    @JoinColumn
    public Admin dni;
}
