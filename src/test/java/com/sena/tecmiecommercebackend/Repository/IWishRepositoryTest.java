package com.sena.tecmiecommercebackend.Repository;

import com.sena.tecmiecommercebackend.repository.IWishRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Tag("Repository")
@SpringBootTest
@Sql(value = {"/wishes-controller.sql"})
public class IWishRepositoryTest {

    @Autowired
    IWishRepository wishRepository;

    @RepeatedTest(value = 1)
    void teste(RepetitionInfo repetitionInfo) {
        var allByUserIdOrderByCreatedDateDesc = wishRepository
                .findAllByUserIdOrderByCreatedDateDesc((long) repetitionInfo.getCurrentRepetition());

        assertFalse(allByUserIdOrderByCreatedDateDesc.isEmpty());

        allByUserIdOrderByCreatedDateDesc.forEach(wish -> {
            assertEquals(repetitionInfo.getCurrentRepetition(), wish.getUser().getId());
        });
    }
}
