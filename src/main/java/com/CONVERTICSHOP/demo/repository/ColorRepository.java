package com.CONVERTICSHOP.demo.repository;

import com.CONVERTICSHOP.demo.modelo.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {


}
