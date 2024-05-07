package com.rodrigues.silva.marcos.hrworker.repositories;

import com.rodrigues.silva.marcos.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
