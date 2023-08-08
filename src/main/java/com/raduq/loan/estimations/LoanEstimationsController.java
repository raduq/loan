package com.raduq.loan.estimations;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoanEstimationsController {

	private final Logger logger = LoggerFactory.getLogger(LoanEstimationsController.class);
	private final LoanEstimationsService service;

	public LoanEstimationsController(LoanEstimationsService service) {
		this.service = service;
	}

	/**
	 * Receives a EstimationRequest in the body and calculates the EMI.
	 *
	 * @param request EstimationRequest with loanValue, yearlyInterestRate and loanTerm in years.
	 * @return the calculated EMI value
	 */
	@PostMapping("/estimations")
	public Double estimate(@Valid @RequestBody EstimationRequest request) {
		logger.info("Estimating EMI for: {}", request);
		return service.estimate(request);
	}
}
