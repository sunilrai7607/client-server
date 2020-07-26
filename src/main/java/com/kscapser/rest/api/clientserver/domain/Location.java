package com.kscapser.rest.api.clientserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;


@Data
@EqualsAndHashCode(of = {"id"})
public class Location extends BaseModel implements Serializable {

    private String street, city, state;
    private Integer postcode;

    @JsonBackReference
    private CustomProfile customProfile;

}
