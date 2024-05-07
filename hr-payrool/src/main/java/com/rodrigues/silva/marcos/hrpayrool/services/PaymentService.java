package com.rodrigues.silva.marcos.hrpayrool.services;

import com.rodrigues.silva.marcos.hrpayrool.entities.Payment;
import com.rodrigues.silva.marcos.hrpayrool.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${h2-worker.host}")
  private String workerHost;

  public Payment getPayment(long workerId, int days) {
    Map<String, String> uriVariable = new HashMap<>();
    uriVariable.put("id", String.valueOf(workerId));
    String url = workerHost + "/workers/{id}";
    Worker worker = restTemplate.getForObject(url, Worker.class, uriVariable);

    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}
