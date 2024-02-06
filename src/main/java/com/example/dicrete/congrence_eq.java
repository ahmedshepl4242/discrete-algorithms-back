package com.example.dicrete;

import com.fasterxml.jackson.annotation.JsonProperty;

class congrence_eq {

    @JsonProperty

    long a;

    @JsonProperty
    long m;

    public congrence_eq() {

    }

    public congrence_eq( long a, long m) {
        this.a = a;
        this.m = m;
    }
}
