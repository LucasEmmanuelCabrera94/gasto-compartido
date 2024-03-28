package gastocompartido.api.services.interfaces;

import gastocompartido.api.entities.expense.ExpenseRequest;
import gastocompartido.api.entities.expense.ExpenseResponse;

public interface ExpenseService {
    /**
     * Creates an expense based on the given request.
     *
     * @param  request  the expense request containing the necessary information to create an expense
     * @return          the response containing the created expense
     */
    ExpenseResponse createExpense(ExpenseRequest request);

}
