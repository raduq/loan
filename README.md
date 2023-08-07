# EMI estimations calculator

This project is responsible for calculating a EMI based on received parameters.

## Installation

Just start with default spring boot runner.

```bash
./gradlew bootrun
```

## Usage

Call the endpoint with and JSON body with the parameters.

Endpoint:

```java
# calculate
POST /loans/estimations
```

Body Parameters:
```json
{
    "loanValue": 10000,
    "yearlyInterestRate": 10,
    "loanTermInYears": 2
}
```
