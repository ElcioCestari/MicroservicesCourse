package com.elciocestari.hrworker.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elciocestari.hrworker.entities.Worker;
import com.elciocestari.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers = repository.findAll();
		
		return ResponseEntity.ok().body(workers);
		
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker worker = repository.findById(id).get();
		
		return ResponseEntity.ok().body(worker);
		
	}
}
