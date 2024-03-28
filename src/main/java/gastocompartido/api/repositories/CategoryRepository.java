package gastocompartido.api.repositories;

import gastocompartido.api.entities.Category;
import gastocompartido.api.entities.User;
import gastocompartido.api.entities.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * Finds a category by its name.
     *
     * @param  categoryName  the name of the category to find
     * @return               an optional containing the found category, or an empty optional if no category with the given name exists
     */
    Optional<Category> findByName(String categoryName);}
