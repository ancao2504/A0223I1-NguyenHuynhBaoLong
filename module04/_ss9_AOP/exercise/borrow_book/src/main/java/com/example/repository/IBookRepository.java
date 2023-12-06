package com.example.repository;

import com.example.models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Book findAllByName(String name);
    @Modifying
    @Transactional
    @Query(name = "updateQuantity")
    void updateQuantityBook(@Param("quantity") int quantity, @Param("name") String name);

}
