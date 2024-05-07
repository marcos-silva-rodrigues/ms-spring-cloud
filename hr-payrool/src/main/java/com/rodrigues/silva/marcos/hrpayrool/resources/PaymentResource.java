package com.rodrigues.silva.marcos.hrpayrool.resources;

import com.rodrigues.silva.marcos.hrpayrool.entities.Payment;
import com.rodrigues.silva.marcos.hrpayrool.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

  @Autowired
  private PaymentService service;

  @GetMapping("/{workerId}/days/{days}")
  public ResponseEntity<Payment> payment(@PathVariable Long workerId, @PathVariable Integer days) {
    Payment payment = service.getPayment(workerId, days);
    return ResponseEntity.ok(payment);
  }
}
