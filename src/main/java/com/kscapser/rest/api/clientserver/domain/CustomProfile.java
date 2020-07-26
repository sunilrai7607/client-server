package com.kscapser.rest.api.clientserver.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;


@Data
@EqualsAndHashCode(of = {"id"})
public class CustomProfile extends BaseModel implements Serializable {

    private static final long serialVersionUID = 7239909656755589054L;

    private String firstName, middleName, lastName, email;

    private String gender;

    @JsonManagedReference
    private Location location;

    private String phone, cell;

    @JsonManagedReference
    private DateOfBirth dateOfBirth;


    @JsonManagedReference
    private Login login;
}
