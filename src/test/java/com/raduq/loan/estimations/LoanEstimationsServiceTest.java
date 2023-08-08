package com.raduq.loan.estimations;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoanEstimationsServiceTest {

	@Test
	void shouldEstimateEMI() {
		EstimationRequest request = new EstimationRequest(10000D, 10D, 2D);

		Double estimation = new LoanEstimationsService().estimate(request);

		assertThat(estimation).isEqualTo(461.44926337516654);
	}

	@Test
	void shouldEstimateEMIWhenValueIs0() {
		EstimationRequest request = new EstimationRequest(0D, 10D, 2D);

		Double estimation = new LoanEstimationsService().estimate(request);

		assertThat(estimation).isZero();
	}

	@Test
	void shouldEstimateEMIWhenTermsIs0() {
		EstimationRequest request = new EstimationRequest(10000D, 10D, 0D);

		Double estimation = new LoanEstimationsService().estimate(request);

		assertThat(estimation).isZero();
	}

	@Test
	void shouldEstimateEMIWhenInterestIs0() {
		EstimationRequest request = new EstimationRequest(10000D, 0D, 2D);

		Double estimation = new LoanEstimationsService().estimate(request);

		assertThat(estimation).isZero();
	}
}
