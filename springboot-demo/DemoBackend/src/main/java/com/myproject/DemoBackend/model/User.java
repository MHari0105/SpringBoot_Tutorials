package com.myproject.DemoBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User {

    @Id
    private Integer userId;
    private String username;
    private Integer age;
    private String gender;
    private String email;
    private String password;

}
