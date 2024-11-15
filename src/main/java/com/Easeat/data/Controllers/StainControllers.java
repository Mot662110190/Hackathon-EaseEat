package com.Easeat.data.Controllers;

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
public class StainControllers {
private StrainService strainService;

    @Autowired
     public StainControllers(StrainService strainService) {
        this.strainService = strainService;
    }

   @PostMapping("/strain")
    public Strain addstrain (@RequestBody Strain strain){
               strain.setId(0);
               return strainService.save(strain);
    }

     @GetMapping("/strain")
    public List<Strain> getAllstrain(){
        return strainService.findAll();
    }
    @GetMapping("/strain/{id}")
    public Strain getstrain(@PathVariable int id){
        Strain myStrain =  strainService.findById(id);
       if(myStrain==null){
        throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
    }
    return myStrain;
    }
    @DeleteMapping("/strain/{id}")
    public String deletestrain(@PathVariable int id){
        Strain myStrain =  strainService.findById(id);
        if(myStrain==null){
            throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
        }
        strainService.deleteById(id);
        return "ลบข้อมูลแล้ว";
    }
    @PutMapping("/strain")
    public Strain updatestrain (@RequestBody Strain strain){
        return strainService.save(strain);
}
}
