package com.virtusa.MongoDBWithJwt.entitity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

    import javax.validation.constraints.NotBlank;
    import javax.validation.constraints.NotNull;
    import java.io.Serializable;

@Document(collection= "Student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id

    private int id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String village;

    public int getId() {
        return id;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", village='" + village + '\'' +
                '}';
    }
}
