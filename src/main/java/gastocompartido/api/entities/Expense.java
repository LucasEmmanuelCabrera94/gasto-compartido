package gastocompartido.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    private List<User> users;
    @ManyToOne
    private Category category;
    private String description;
    private String amount;
    private String date;
    private Date created_at;
    private Date updated_at;
}
