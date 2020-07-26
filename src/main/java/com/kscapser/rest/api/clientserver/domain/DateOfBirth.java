package com.kscapser.rest.api.clientserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode(of = {"id"})
public class DateOfBirth extends BaseModel implements Serializable {

    private Date dob;
    private Integer age;
    @JsonBackReference
    private CustomProfile customProfile;
}
