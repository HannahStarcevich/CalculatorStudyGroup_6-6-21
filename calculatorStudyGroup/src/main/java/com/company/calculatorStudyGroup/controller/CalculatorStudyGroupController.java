package com.company.calculatorStudyGroup.controller;

import com.company.calculatorStudyGroup.models.Numbers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CalculatorStudyGroupController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public double addition(@RequestBody @Valid Numbers numbers){

        return numbers.getNum1() + numbers.getNum2();
    }

    @PostMapping("/subtract")
    @ResponseStatus(HttpStatus.CREATED)
    public double subtraction(@RequestBody @Valid Numbers numbers){
        return numbers.getNum1() - numbers.getNum2();
    }

    @PostMapping("/multiply")
    @ResponseStatus(HttpStatus.CREATED)
    public double multiplication(@RequestBody @Valid Numbers numbers){
        return numbers.getNum1() * numbers.getNum2();
    }

    @PostMapping("/divide")
    @ResponseStatus(HttpStatus.CREATED)
    public double division(@RequestBody @Valid Numbers numbers){

        if (numbers.getNum2().equals((double)0)) {
            throw new IllegalArgumentException("Number cannot be 0");
        }

        return numbers.getNum1() / numbers.getNum2();
    }

}
