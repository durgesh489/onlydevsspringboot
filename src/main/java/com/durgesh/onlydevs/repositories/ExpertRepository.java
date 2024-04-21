package com.durgesh.onlydevs.repositories;

import com.durgesh.onlydevs.entities.Expert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends CrudRepository<Expert, Integer> {
}
