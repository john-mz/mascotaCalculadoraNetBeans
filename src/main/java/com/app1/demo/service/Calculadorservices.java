/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app1.demo.service;


import org.springframework.stereotype.Service;

@Service
public class Calculadorservices {
    public Double suma(Double num1, Double num2){
        return num1 + num2;
    }
    
    public Double resta(Double num1, Double num2){
        return num1 - num2;
    }
    
    public Double multi(Double num1, Double num2){
        return num1 * num2;
    }
    
    public Double div(Double num1, Double num2){
        if (num2 == 0){
            return 0.0;
        }
        
        return num1 / num2;
    }
}
