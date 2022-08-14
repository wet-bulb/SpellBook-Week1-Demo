package com.spellbook.production;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name="wizard_id", nullable=false)
    private Wizard wizard;

    @ManyToOne
    @JoinColumn(name="tavern_id", nullable=false)
    private Tavern tavern;

    public Post(String content, Wizard wizard) {
        this.content = content;
        this.wizard = wizard;
    }

}
