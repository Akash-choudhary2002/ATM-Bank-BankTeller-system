package com.Akash_Bank.repository;

// import java.util.Optional;

// import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import com.Akash_Bank.entity.Account;

// import jakarta.transaction.Transactional;

// import jakarta.persistence.LockModeType;;
@Repository

public interface AccountRepository extends JpaRepository<Account, Long> {
    
  
}
