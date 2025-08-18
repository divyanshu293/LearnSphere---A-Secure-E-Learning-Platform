package com.hashedin.huspark.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(unique = true)
    private String name;


    private String pswrd;


    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Log> logs = new ArrayList<>();


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();


    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL  )
    private Instructor instructor;


    public List<Log> getLogs() {
        return logs;
    }


    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }




    public String getPswrd() {
        return pswrd;
    }


    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }


    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
