package com.Easeat.data.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Easeat.data.Entity.Strain;

public interface StrainRepository extends JpaRepository<Strain,Integer> {

}
