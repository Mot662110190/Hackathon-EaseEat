package com.Easeat.data.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Easeat.data.Entity.Strain;
import com.Easeat.data.services.StrainService;

@RestController
@RequestMapping("/api")
public class StrainControllers {
    private StrainService strainService;

    @Autowired
    public StrainControllers(StrainService strainService) {
        this.strainService = strainService;
    }

    @PostMapping("/strain")
    public Strain addstrain(@RequestBody Strain strain) {
        strain.setId(0);
        return strainService.save(strain);
    }

    @GetMapping("/strain")
    public List<Strain> getAllstrain() {

        return strainService.findAll();
    }

    @GetMapping("/strain/{id}")
    public Strain getstrain(@PathVariable int id) {
        Strain myStrain = strainService.findById(id);
        if (myStrain == null) {
            throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
        }
        return myStrain;
    }

    @DeleteMapping("/strain/{id}")
    public String deletestrain(@PathVariable int id) {
        Strain myStrain = strainService.findById(id);
        if (myStrain == null) {
            throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
        }
        strainService.deleteById(id);
        return "ลบข้อมูลแล้ว";
    }

    @PutMapping("/strain")
    public Strain updatestrain(@PathVariable Strain strain) {
        return strainService.save(strain);
    }

    @GetMapping("/strain/all/{user_id}")
    public List<Strain> getAllstrain(@PathVariable("user_id") Integer user_id) {
        List<Strain> List_Strain1 = strainService.findAll();

        List<Strain> List_Strain2 = new ArrayList<>();

        for (Strain strain1 : List_Strain1) {
            if (strain1.getUser() != null) {
                System.out.println("-----> " + strain1.getUser() + " - " + user_id);
                if (strain1.getUser().getId() == user_id) {
                    List_Strain2.add(strain1);
                }
            }
        }

        return List_Strain2;
    }

}
