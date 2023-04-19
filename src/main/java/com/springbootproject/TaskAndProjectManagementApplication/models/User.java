package com.springbootproject.TaskAndProjectManagementApplication.models;
import com.aerospike.client.query.IndexType;
import lombok.*;
import org.springframework.data.aerospike.annotation.Indexed;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.UUID;
//@Builder(toBuilder = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class User {
    @Id
    private String id;
    @Indexed(name = "userName_idx", type = IndexType.STRING)
    private String userName;
    private String password;
    private boolean active;
    private String roles;

    public String generateId() {
        this.id=UUID.randomUUID().toString();
        return this.id;
    }


}
