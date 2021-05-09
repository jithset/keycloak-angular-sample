package io.github.jithset.posts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tbl_posts")
@ToString
public class Posts {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    @Getter @Setter
    private UUID postId;

    @Getter @Setter
    @NotBlank
    private String title;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private LocalDateTime createdDate = LocalDateTime.now();

    @Getter @Setter
    private LocalDateTime updatedDate = LocalDateTime.now();

}
