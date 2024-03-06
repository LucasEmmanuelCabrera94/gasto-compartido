package gastocompartido.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Currency {
    @Id
    private String code;
    private String name;
    private BigDecimal exchangeRateToUSD;
}
