package com.Easeat.data.services;

import java.util.List;

import com.Easeat.data.Entity.Strain;

public interface StrainService {
     Strain save(Strain strain);
     List<Strain> findAll();
     Strain findById(Integer id);
     void deleteById(Integer id);
}
