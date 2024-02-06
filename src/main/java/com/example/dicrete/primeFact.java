package com.example.dicrete;

import com.fasterxml.jackson.annotation.JsonProperty;

public class primeFact {

    @JsonProperty("value")

    int value;
    @JsonProperty("pow")

    int pow;

    public primeFact() {

    }

    public primeFact(int value, int pow) {
        this.value = value;
        this.pow = pow;
    }


}