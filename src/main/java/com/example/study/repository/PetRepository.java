package com.example.study.repository;

import com.example.study.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-08 18:50
 **/
@Repository
public interface PetRepository extends JpaRepository<Pet, String>, JpaSpecificationExecutor<Pet> {
}
