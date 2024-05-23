package com.CRUD.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Demo {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private char gender;

    public Demo(Integer id, String name, char gender) {     //used in testing. can use entity or Dto.
        super();                                            //use Dto as mthd parameter accept Dto.
        this.id=id;                                         //while using entity, converted to dto in test.
        this.name=name;
        this.gender=gender;
    }
    
}
