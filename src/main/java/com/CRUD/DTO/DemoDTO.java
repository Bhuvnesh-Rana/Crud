package com.CRUD.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DemoDTO {

    private Integer id;
    private String name;
    private char gender;        //changed G to g.

    public DemoDTO(Integer id, String name, char gender) {     //used in testing. can use entity or Dto.
        super();                                            //use Dto as mthd parameter accept Dto.
        this.id=id;                                         //while using entity, converted to dto in test.
        this.name=name;
        this.gender=gender;
    }
}
