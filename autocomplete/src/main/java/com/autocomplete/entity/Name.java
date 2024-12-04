package com.autocomplete.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/*@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data*/
@Entity
public class Name {
    
    @Id
    private String name;

    public Name() {
    }

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}