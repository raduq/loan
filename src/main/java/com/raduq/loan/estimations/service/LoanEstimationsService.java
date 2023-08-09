package com.raduq.loan.estimations.service;

import com.raduq.loan.estimations.model.EstimationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoanEstimationsService {

	private final Logger logger = LoggerFactory.getLogger(LoanEstimationsService.class);

	private static final int YEAR_MONTHS = 12;
	private static final int MAX_PERCENTAGE = 100;

	/**
	 * Estimate the EMI value using the following formula: EMI = P x R x (1+R)^N / [(1+R)^N-1]
	 * Where: “P” is the loan amount, “N” is tenure in months, and “R” is the monthly interest
	 *
	 * @return EMI value estimated
	 */
	public Double estimate(EstimationRequest request) {
		if (request.loanValue() == 0
			|| request.yearlyInterestRate() == 0
			|| request.loanTermInYears() == 0) {
			logger.warn("Some of the values received was zero, defaulting to EMI 0. " +
					"Values: loanValue is {}, yearlyInterestRate {}, loanTermInYears {}",
				request.loanValue(), request.yearlyInterestRate(), request.loanValue());
			return 0D;
		}

		Double monthInterest = request.yearlyInterestRate() / (YEAR_MONTHS * MAX_PERCENTAGE);
		Double monthlyTerm = request.loanTermInYears() * YEAR_MONTHS;
		logger.debug("Montly interest is {}", monthInterest);
		logger.debug("Montly monthlyTerm is {}", monthlyTerm);

		return (request.loanValue() * monthInterest * Math.pow(1 + monthInterest, monthlyTerm))
			/ (Math.pow(1 + monthInterest, monthlyTerm) - 1);
	}

}
