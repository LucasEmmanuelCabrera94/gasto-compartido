package gastocompartido.api.controllers;

import gastocompartido.api.entities.expense.ExpenseRequest;
import gastocompartido.api.entities.expense.ExpenseResponse;
import gastocompartido.api.services.interfaces.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
@Tag(name = "Expense endpoints")
@SecurityRequirement(name = "bearerAuth")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Operation(
            description = "Puede crear una expensa nueva.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "403", description = "Unauthorized / Invalid Token"),
                    @ApiResponse(responseCode = "404", description = "Category not found"),
            }
    )
    @PostMapping("/create")
    public ResponseEntity<ExpenseResponse> createExpense(@RequestBody ExpenseRequest request) {
        return ResponseEntity.ok(expenseService.createExpense(request));
    }
}
