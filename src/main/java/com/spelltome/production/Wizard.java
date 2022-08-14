package com.spelltome.production;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wizard_id")
    private Long id;
    private String name;
    private String avatar;
    @Column(columnDefinition = "boolean default false")
    private Boolean active;
    @Column(columnDefinition = "boolean default true")
    private Boolean invites;

    @JsonIgnore
    @OneToMany(mappedBy="wizard")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "tavern_wizard",
            joinColumns = @JoinColumn(name = "wizard_id"),
            inverseJoinColumns = @JoinColumn(name = "tavern_id"))
    private List<Tavern> taverns = new ArrayList<>();

    public Wizard(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public void addTavern(Tavern tavern) {
        this.taverns.add(tavern);
        tavern.getWizards().add(this);
    }

}
