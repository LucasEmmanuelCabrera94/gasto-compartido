package gastocompartido.api.services;

import gastocompartido.api.entities.Category;
import gastocompartido.api.entities.User;
import gastocompartido.api.entities.expense.Expense;
import gastocompartido.api.entities.expense.ExpenseRequest;
import gastocompartido.api.entities.expense.ExpenseResponse;
import gastocompartido.api.exceptions.NotFoundException;
import gastocompartido.api.repositories.CategoryRepository;
import gastocompartido.api.repositories.ExpenseRepository;
import gastocompartido.api.repositories.UserRepository;
import gastocompartido.api.services.interfaces.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static gastocompartido.api.utils.UsefulMethods.getUserLogged;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ExpenseResponse createExpense(ExpenseRequest request) {
        User userAuth = getUserLogged();
        List<User> users = new ArrayList<>();
        users.add(userAuth);
        if (!Objects.isNull(request.getUserName())) {
            Optional<User> user = userRepository.findByUsername(request.getUserName());
            user.ifPresent(users::add);
        }

        Category category = categoryRepository.findByName(request.getCategory())
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "Category not found"));

        Expense expense = Expense.builder()
                .category(category)
                .description(request.getDescription())
                .amount(request.getAmount())
                .users(users)
                .build();

        Expense response = expenseRepository.save(expense);

        String dateString = response.getCreatedAt().substring(0, 10);

        return ExpenseResponse.builder()
                .category(response.getCategory())
                .description(response.getDescription())
                .amount(response.getAmount())
                .date(dateString)
                .build();
    }
}
