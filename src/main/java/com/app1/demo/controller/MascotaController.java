
package com.app1.demo.controller;

import com.app1.demo.Dto.OperacionDTO;
import com.app1.demo.service.Calculadorservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MascotaController {
    
    @Autowired // inyeccion de dependencias (Trae todas las funciones de calculadora servide)
    Calculadorservices calculadoraService;
    
//    obtiene data
    @GetMapping //componente base
    public String saludo(Model model){
        model = reinicio(model, new OperacionDTO());
        return "index";
    }
    
    //funcion encargada de cargar las variables del modelo en la pagina web
    public Model reinicio(Model model, OperacionDTO operacionDTO){
        model.addAttribute("Orejas", "(\\__/)");
        model.addAttribute("Cara", "=' '=");
        model.addAttribute("Patas", "(\"\")-(\"\")");
        model.addAttribute("Mensaje", "Hola soy el conejo samy");
        model.addAttribute("OperacionDTO", operacionDTO);
        return model;
    }
    
    
//    envia data. Q PTAS ES POST, GET, DELETE, ETC
    @PostMapping("/calcular")
    public String calcular(Model model, @ModelAttribute("OperacionDTO") OperacionDTO operacionDTO){
        switch (operacionDTO.getOperacion()){
            case "suma":
                operacionDTO.setResultado(calculadoraService.suma(operacionDTO.getNumero1(), operacionDTO.getNumero2()));
                break;
            case "resta":
                operacionDTO.setResultado(calculadoraService.resta(operacionDTO.getNumero1(), operacionDTO.getNumero2()));
                break;
            case "multiplicacion":
                operacionDTO.setResultado(calculadoraService.multi(operacionDTO.getNumero1(), operacionDTO.getNumero2()));
                break;
            case "division":
                try {
                    operacionDTO.setResultado(calculadoraService.div(operacionDTO.getNumero1(), operacionDTO.getNumero2()));
                } catch (IllegalArgumentException e){
                    operacionDTO.setResultado(null);
                }
                break;
            default:
                operacionDTO.setResultado(null);
                break;
        }
        model = reinicio(model, operacionDTO);
        System.out.println("Resultado: " + operacionDTO.getResultado());
        return "index";
    }
}
