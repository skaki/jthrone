package com.thinkhr.api.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by skaki on 10/4/17.
 */
@Data
@Entity
@Table(name = "document")
public class Document {
    private @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false) Long id;

    private @Column(name = "header", nullable = true) String header;
    private @Column(name = "footer", nullable = true) String footer;
    private @Column(name = "body", nullable = true) String body;
}
