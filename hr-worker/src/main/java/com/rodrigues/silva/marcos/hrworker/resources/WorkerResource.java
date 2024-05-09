package com.rodrigues.silva.marcos.hrworker.resources;

import com.rodrigues.silva.marcos.hrworker.entities.Worker;
import com.rodrigues.silva.marcos.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

  private static  final Logger log = LoggerFactory.getLogger(Worker.class);

  @Autowired
  private WorkerRepository workerRepository;

  @Value("${test.config}")
  private String configValue;


  @GetMapping("/config")
  public ResponseEntity config() {
    log.info(String.format("CONFIG VALUE: %s", configValue));
    return ResponseEntity.noContent().build();
  }


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
