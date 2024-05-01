package com.durgesh.onlydevs.repositories;

import com.durgesh.onlydevs.entities.experts.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {
}
