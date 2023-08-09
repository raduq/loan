package com.raduq.loan.estimations.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EstimationRequestTest {

	@Test
	void shouldCreateEstimationRequest() {
		EstimationRequest request = new EstimationRequest(10000D, 10D, 0D);
		assertThat(request).isNotNull();

	}
}
