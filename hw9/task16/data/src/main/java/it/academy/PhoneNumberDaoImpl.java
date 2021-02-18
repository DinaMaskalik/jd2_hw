package it.academy;

import it.academy.model.PhoneNumber;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneNumberDaoImpl implements PhoneNumberDao {

    private static List<PhoneNumber> phoneNumberList;

    static {
        phoneNumberList=List.of(
                PhoneNumber.builder()
                        .phoneId(1)
                        .phoneNumber("+375333061651")
                        .balance(12.23)
                        .build(),
                PhoneNumber.builder()
                        .phoneId(2)
                        .phoneNumber("+375292158361")
                        .balance(9.25)
                        .build()
        );
    }
    @Override
    public List<PhoneNumber> readAll() {
        return phoneNumberList;
    }
}
