package gastocompartido.api.controllers;

import gastocompartido.api.entities.expense.ExpenseRequest;
import gastocompartido.api.entities.expense.ExpenseResponse;
import gastocompartido.api.services.interfaces.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<ExpenseResponse> createExpense(@RequestBody ExpenseRequest request) {
        return ResponseEntity.ok(expenseService.createExpense(request));
    }
}
