package com.Easeat.data.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Easeat.data.Entity.Strain;
import com.Easeat.data.services.StrainService;

@RestController
@RequestMapping("/api")
public class StainControllers {
private StrainService strainService;

    @Autowired
     public StainControllers(StrainService strainService) {
        this.strainService = strainService;
    }

   @PostMapping("/Strain")
    public Strain addUser (@RequestBody Strain strain){
               strain.setId(0);
               return strainService.save(strain);
    }

     @GetMapping("/Strain")
    public List<Strain> getAllUser(){
        return strainService.findAll();
    }
}
