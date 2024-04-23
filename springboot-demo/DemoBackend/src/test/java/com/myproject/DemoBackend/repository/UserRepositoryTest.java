package com.myproject.DemoBackend.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.myproject.DemoBackend.model.User;

@DataMongoTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepo;

    @Test
    public void userRepository_saveAll_returnSavedUser() {

        // ARRANGE
        User user = User.builder()
                        .id(3)
                        .username("Arjun")
                        .age(3)
                        .gender("Male")
                        .email("arjun@gmail.com")
                        .password("user3")
                        .build();

        // ACT
        User savedUser = userRepo.save(user);

        // ASSERT
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isEqualTo(3);
    }

    @Test
    public void userRepository_getAll_ReturnMoreThanOneUser() {

        User user1 = User.builder()
                        .id(4)
                        .username("Vaishu")
                        .age(1)
                        .gender("Female")
                        .email("vaishu@gmail.com")
                        .password("user4")
                        .build();

        User user2 = User.builder()
                        .id(5)
                        .username("Pup")
                        .age(5)
                        .gender("Animal")
                        .email("puppy@gmail.com")
                        .password("user5")
                        .build();

        userRepo.save(user1);
        userRepo.save(user2);

        List<User> userList = userRepo.findAll();

        Assertions.assertThat(userList).isNotNull();
        Assertions.assertThat(userList.size()).isEqualTo(5);

    }

    @Test
    public void userRepository_findById_returnUser() {

        User user = User.builder()
                        .id(6)
                        .username("Amma")
                        .age(45)
                        .gender("Female")
                        .email("amma@gmail.com")
                        .password("user6")
                        .build();

        userRepo.save(user);

        User thisUser = userRepo.findById(user.getId()).get();

        Assertions.assertThat(thisUser).isNotNull();

    }

    @Test
    public void userRepository_findByEmailAndUpdate_returnUserNotNull() {
        User user = User.builder()
                        .id(5)
                        .username("Pup")
                        .age(5)
                        .gender("Animal")
                        .email("puppy@gmail.com")
                        .password("user5")
                        .build();

        // userRepo.save(user);

        User savedUser = userRepo.findByEmail(user.getEmail()).get();
        savedUser.setAge(6);
        savedUser.setGender("pet");

        User updatedUser = userRepo.save(savedUser);

        Assertions.assertThat(updatedUser).isNotNull();
    }

}
