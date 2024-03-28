package gastocompartido.api.entities.expense;

import gastocompartido.api.entities.Category;
import gastocompartido.api.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequest {
    private String category;
    private String description;
    private String amount;
    private String userName;
}
