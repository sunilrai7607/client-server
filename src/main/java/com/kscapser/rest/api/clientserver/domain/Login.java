package com.kscapser.rest.api.clientserver.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(of = {"id"})
public class Login extends BaseModel implements Serializable {

    private String uuid, username, password;
    @JsonBackReference
    private CustomProfile customProfile;
}
