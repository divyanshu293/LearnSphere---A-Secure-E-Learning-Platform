package com.hashedin.huspark.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String title;


    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;


    @OneToMany(mappedBy = "subModule",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Document> documents = new ArrayList<>();


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public Module getModule() {
        return module;
    }


    public void setModule(Module module) {
        this.module = module;
    }


    public List<Document> getDocuments() {
        return documents;
    }


    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}


