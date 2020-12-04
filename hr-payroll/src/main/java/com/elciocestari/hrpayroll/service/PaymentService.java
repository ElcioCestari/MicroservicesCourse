package com.elciocestari.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.elciocestari.hrpayroll.entities.Payment;
import com.elciocestari.hrpayroll.entities.Worker;
import com.elciocestari.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

//	it is not more necessary, because I include feign
//	@Value("${hr-worker.host}")
//	private String workerHost;

	@Autowired
	private WorkerFeignClient workerFeignCliente;

	@Autowired
	private RestTemplate restTemplate;

//	this was the old way to call a service. 
//	public Payment getPayment(Long workerId, int days) {
//		
//		Map<String, String> uriVariable = new HashMap<>();
//		
//		uriVariable.put("id", workerId.toString());
//		
//		Worker worker = restTemplate.getForObject(
//				workerHost + "/workers/{id}", Worker.class, uriVariable);
//		
//		return new Payment(worker.getName(), worker.getDailyIncome, days);
//	}

	public Payment getPayment(Long workerId, int days) {
		Worker worker = workerFeignCliente.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
