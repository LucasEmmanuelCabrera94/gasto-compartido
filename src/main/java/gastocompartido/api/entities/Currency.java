package gastocompartido.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
