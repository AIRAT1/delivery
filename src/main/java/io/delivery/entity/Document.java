package io.delivery.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {
    public Document() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private long id;

//    @Column(name = "document_name")
    private String name;

    @Transient
    private String specificInnerInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
