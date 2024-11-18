package com.Easeat.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Easeat.data.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
 

}
