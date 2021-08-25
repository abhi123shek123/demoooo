package com.vocalink.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -7412589630147852369L;
    private final String jwt;

    public JwtResponse(String jwt) {
        this.jwt = jwt;
    }
}
