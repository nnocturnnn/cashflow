package world.ucode.cashflow.repos;

import world.ucode.cashflow.db.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepo extends CrudRepository<Transaction, Long> {

    List<Transaction> findByTag(String tag);

}