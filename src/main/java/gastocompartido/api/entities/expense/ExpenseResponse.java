package gastocompartido.api.entities.expense;

import gastocompartido.api.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {
    private Category category;
    private String description;
    private String amount;
    private String date;
}
