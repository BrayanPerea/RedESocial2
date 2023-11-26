package com.example.Hackaton.DTO.CommentDTO;

import com.example.Hackaton.DTO.UserDTO.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "commentByUser")
public class CommentByUser {

    @Id
    private int idComment;

    @Column
    public String title;

    @Column
    public String content;

    @ManyToOne
    @JoinColumn
    public User id;
}
