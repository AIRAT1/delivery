package io.delivery.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "documents")
public class Document {
    @Id
    @Column(name = "document_id")
    private long id;

    @Column(name = "document_name")
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
