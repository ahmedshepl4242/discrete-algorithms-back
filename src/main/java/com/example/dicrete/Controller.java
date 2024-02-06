package com.example.dicrete;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Controller {

    Facotors facotors = new Facotors();
    chinese ch = new chinese();

    @PostMapping("/chine")
    void chines(@RequestBody ArrayList<congrence_eq> eqs) {
        for (int i = 0; i < eqs.size(); i++) {
            System.out.println(eqs.get(i).a+ " "+eqs.get(i).m);
        }
        ch.chinese_theorem_remainders(eqs);
    }

    @GetMapping("/getChines")
    Long chines() {
        return ch.answer;
    }

    @PostMapping("/factorization")
    void lcm(@RequestParam Long number) {
        facotors.factorization(number);
    }

    @GetMapping("/getPrimes")
    ArrayList<primeFact> factors() {
        return facotors.list_1;
    }
}

