package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payement;
import com.example.demo.service.PayementService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController // is controller which provides different end points to access the services
@RequestMapping("/api/payements")
public class PayementController {
	@Autowired
	private PayementService payementService;

	/*
	 * public PayementController(PayementService payementService) { super();
	 * this.payementService = payementService;
	 * 
	 * }
	 */

	// making payement
	@PostMapping("{roomId}/{customerId}/{id}")
	public ResponseEntity<Payement> addPayement(@RequestBody Payement payement, @PathVariable long roomId,
			@PathVariable long customerId, @PathVariable long id) {

		return new ResponseEntity<Payement>(payementService.addPayement(payement, roomId, customerId, id),
				HttpStatus.CREATED);
	}

	// getting list of payements
	@GetMapping
	public List<Payement> getAlPayements() {
		return payementService.getAllPayements();
	}

	// to get payement by payement id(for receipt)

	@GetMapping("{payementId}")
	public ResponseEntity<Payement> getPayementById(@PathVariable("payementId") long payementId) {
		return new ResponseEntity<Payement>(payementService.getPayementById(payementId), HttpStatus.OK);
	}

// to delete payement
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deletePayement(@PathVariable("id") long id) {
		payementService.deletePayement(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
