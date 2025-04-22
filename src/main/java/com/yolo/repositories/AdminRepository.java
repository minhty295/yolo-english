package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
