package com.rodrigues.silva.marcos.hrworker.resources;

import com.rodrigues.silva.marcos.hrworker.entities.Worker;
import com.rodrigues.silva.marcos.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

  @Autowired
  private WorkerRepository workerRepository;


  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> list = workerRepository.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {
    Optional<Worker> opt = workerRepository.findById(id);
    return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
