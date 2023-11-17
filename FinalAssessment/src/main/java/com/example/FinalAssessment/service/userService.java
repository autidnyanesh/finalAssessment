package main.java.com.example.FinalAssessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private loginRepo loginRepository;

    public login saveUser(login user) {
        String password = generatePassword(user.getFirstName(), user.getMiddleName(), user.getLastName());
        user.setPassword(password);

        return loginRepository.save(user);
    }

    private String generatePassword(String firstName, String middleName, String lastName) {
        String password = firstName.substring(0, 2) + middleName.substring(0, 2) + lastName.substring(0, 2)
                + String.format("%03d", (int) (Math.random() * 1000));
        return password;
    }
}
