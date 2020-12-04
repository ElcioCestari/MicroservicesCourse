package com.elciocestari.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.elciocestari.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
