package com.raduq.loan.estimations.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record EstimationRequest(
	@NotNull(message = "The loan value MUST NOT be null")
	@Min(
		value = MIN_LOAN_VALUE,
		message = "The loan value MUST BE at minimum " + MIN_LOAN_VALUE
	)
	Double loanValue,
	@NotNull(message = "The yearly interest rate MUST NOT be null")
	@Min(
		value = MIN_YEARLY_INTEREST_RATE,
		message = "The yearly interest rate MUST BE at minimum " + MIN_YEARLY_INTEREST_RATE
	)
	@Max(
		value = MAX_YEARLY_INTEREST_RATE,
		message = "The yearly interest rate MUST BE at maximum " + MAX_YEARLY_INTEREST_RATE
	)
	Double yearlyInterestRate,
	@NotNull(message = "The loan term in years MUST NOT be null")
	@Min(
		value = MIN_LOAN_TERM_IN_YEARS,
		message = "The loan term in years MUST BE at minimum " + MIN_LOAN_TERM_IN_YEARS
	)
	@Max(
		value = MAX_LOAN_TERM_IN_YEARS,
		message = "The loan term in years MUST BE at maximum " + MAX_LOAN_TERM_IN_YEARS
	) Double loanTermInYears) {
	public static final int MIN_LOAN_VALUE = 0;
	public static final int MIN_YEARLY_INTEREST_RATE = 0;
	public static final int MAX_YEARLY_INTEREST_RATE = 100;
	public static final int MIN_LOAN_TERM_IN_YEARS = 0;
	public static final int MAX_LOAN_TERM_IN_YEARS = 30;

}
