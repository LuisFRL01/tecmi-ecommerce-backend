package com.sena.tecmiecommercebackend.Repository;

import com.sena.tecmiecommercebackend.repository.IWishRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Tag("Unit")
@Tag("Repository")
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
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
