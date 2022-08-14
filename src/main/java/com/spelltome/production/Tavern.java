package com.spelltome.production;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@JsonIgnoreProperties
public class Tavern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tavern_id")
    private long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="tavern")
    private List<Post> posts;

    @JsonIgnore
    @ManyToMany(mappedBy = "taverns")
    private List<Wizard> wizards = new ArrayList<>();

    public Tavern(String name) {
        this.name = name;
    }

}
