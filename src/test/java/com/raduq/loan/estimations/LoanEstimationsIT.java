package com.raduq.loan.estimations;

import com.raduq.loan.LoanApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LoanApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoanEstimationsIT {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void shouldCalculateEMI() {
		EstimationRequest request = new EstimationRequest(10000D, 10D, 2D);
		ResponseEntity<Double> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/loans/estimations", request, Double.class);
		assertEquals(200, responseEntity.getStatusCode().value());
		assertEquals(461.44926337516654, responseEntity.getBody());
	}

	@Test
	void shouldNotCalculateIfNegativeLoanValue() {
		EstimationRequest request = new EstimationRequest(-1D, 10D, 2D);
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/loans/estimations", request, String.class);
		assertEquals(400, responseEntity.getStatusCode().value());
	}

	@Test
	void shouldNotCalculateIfNullLoanValue() {
		EstimationRequest request = new EstimationRequest(null, 10D, 2D);
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/loans/estimations", request, String.class);
		assertEquals(400, responseEntity.getStatusCode().value());
	}

	@ParameterizedTest
	@ValueSource(doubles = {-1, 101})
	void shouldNotCalculateIfInvalidInterestRates(Double rate) {
		EstimationRequest request = new EstimationRequest(10000D, rate, 2D);
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/loans/estimations", request, String.class);
		assertEquals(400, responseEntity.getStatusCode().value());
	}

	@ParameterizedTest
	@ValueSource(doubles = {-1, 31})
	void shouldNotCalculateIfInvalidTermInYears(Double term) {
		EstimationRequest request = new EstimationRequest(10000D, 10D, term);
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/loans/estimations", request, String.class);
		assertEquals(400, responseEntity.getStatusCode().value());
	}

}
