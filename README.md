# EMI estimations calculator

This project is responsible for calculating a EMI based on received parameters.

## Dependencies

- Java 17
- Gradle

## Installation

Just start with default spring boot runner.
It will start at `localhost:8080`.

The project already have gradlew sh file (or bat in windows) that will download gradle if needed.

Start by running this:
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

## Future Improvements

- Convert the logic from `Double` to `BigDecimal` to ensure better manipulation of monetary values
- Better handling to when values are 0 (zero)
- Integrate with sonar/sonarcloud
- Contenerize/Dockerize to deploy with kubernetes and AWS/Azure
- Configure nexus-iq and artifacts repository
- Build dashboards to control errors with prometheus
