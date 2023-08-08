package com.raduq.loan.exceptions;

import java.util.List;

public record ErrorResponse(String message, List<String> details) {
}
