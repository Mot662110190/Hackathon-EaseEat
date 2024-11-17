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

import com.Easeat.data.Entity.Bmr;
import com.Easeat.data.services.BmrService;

@RestController
@RequestMapping("/api")
public class BmrControllers {

private  BmrService  bmrService;
  @Autowired
    public BmrControllers(BmrService bmrService) {
        this.bmrService = bmrService;
    }

   @PostMapping("/bmr")
    public Bmr addbmr (@RequestBody Bmr bmr){
               bmr.setId(0);
               return bmrService.save(bmr);
    }
    
    @GetMapping("/bmr")
    public List<Bmr> getAllbmr(){
        return bmrService.findAll();
    }

    @GetMapping("/bmr/{id}")
    public Bmr getbmr(@PathVariable int id){
       Bmr myBmr =  bmrService.findById(id);
       if(myBmr==null){
        throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
    }
    return myBmr;
    }
    @DeleteMapping("/bmr/{id}")
    public String deletebmr(@PathVariable int id){
        Bmr myBmr =  bmrService.findById(id);
        if(myBmr==null){
            throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
        }
        bmrService.deleteById(id);
        return "ลบข้อมูลแล้ว";
    }
    @PutMapping("/bmr")
    public Bmr updatebmr (@RequestBody Bmr bmr){
        return bmrService.save(bmr);
}
}
