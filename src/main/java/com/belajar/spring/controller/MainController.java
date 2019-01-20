package com.belajar.spring.controller;

import com.belajar.spring.entity.Identity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sukenda on 29/07/18.
 * Edited by afzalmardiansyah 0n 20/01/19.
 * Project belajar-spring
 */

@RestController
public class MainController {

    @GetMapping(value = "/")
    public String home() {
    return "Oalaaaaah";
    }
}
