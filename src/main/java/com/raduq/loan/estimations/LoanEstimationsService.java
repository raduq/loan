package com.raduq.loan.estimations;

import org.springframework.stereotype.Service;

@Service
public class LoanEstimationsService {

	private static final int YEAR_MONTHS = 12;
	private static final int MAX_PERCENTAGE = 100;

	/**
	 * Estimate the EMI value using the following formula: EMI = P x R x (1+R)^N / [(1+R)^N-1]
	 * Where: “P” is the loan amount, “N” is tenure in months, and “R” is the monthly interest
	 *
	 * @return EMI value estimated
	 */
	public Double estimate(EstimationRequest request) {
		Double monthInterest = request.yearlyInterestRate() / (YEAR_MONTHS * MAX_PERCENTAGE);
		Double monthlyTerm = request.loanTermInYears() * YEAR_MONTHS;

		return (request.loanValue() * monthInterest * Math.pow(1 + monthInterest, monthlyTerm))
			/ (Math.pow(1 + monthInterest, monthlyTerm) - 1);
	}

}
