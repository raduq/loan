# EMI estimations calculator

This project is responsible for calculating a EMI based on received parameters.

## Dependencies

- Java 17

## Installation

Just start with default spring boot runner.
It will start at `localhost:8080`

```bash
./gradlew bootrun
```

## Usage

Call the endpoint with and JSON body with the parameters.

Endpoint:

```java
# calculate
POST /api/loans/estimations
```

Body Parameters:
```json
{
    "loanValue": 10000,
    "yearlyInterestRate": 10,
    "loanTermInYears": 2
}
```
