package org.example.jpa;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "villagers")
public class Villager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private String personality;
    private String species;
    private String birthday;
    @Column(name = "color")
    private String favoriteColor;

    public Villager() {}

    public Villager(String name, String gender, String personality, String species, String birthday, String favoriteColor) {
        this.name = name;
        this.gender = gender;
        this.personality = personality;
        this.species = species;
        this.birthday = birthday;
        this.favoriteColor = favoriteColor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPersonality() { return personality; }
    public void setPersonality(String personality) { this.personality = personality; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getFavoriteColor() { return favoriteColor; }
    public void setFavoriteColor(String favoriteColor) { this.favoriteColor = favoriteColor; }

    public Set<Island> getIslands() { return islands; }
    public void setIslands(Set<Island> islands) { this.islands = islands; }

    public Hobby getHobby() { return hobby; }
    public void setHobby(Hobby hobby) { this.hobby = hobby; }

    //------------------------dont touch above--------------------------
    //------------------------dont touch above--------------------------
    @ManyToMany
    @JoinTable(
            name = "villager_island",
            joinColumns = @JoinColumn(name = "villager_id"),
            inverseJoinColumns = @JoinColumn(name = "island_id")
    )
    private Set<Island> islands = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;


}