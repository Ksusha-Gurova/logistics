package com.example.logistics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeBox size;
    private double weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "from_client_id")
    private Client fromClientId;

    @ManyToOne
    @JoinColumn(name = "to_client_id")
    private Client toClientId;

    @ManyToOne
    @JoinColumn(name = "from_office_id")
    private Office fromOfficeId;

    @ManyToOne
    @JoinColumn(name = "to_office_id")
    private Office toOfficeId;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courierId;

    private Date dateOfReceipt;
    private Date dateOfIssue;

}
