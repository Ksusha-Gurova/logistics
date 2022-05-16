package com.example.logistics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private SizeBox size;
    private Double weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "from_client_id")
    private Client fromClient;

    @ManyToOne
    @JoinColumn(name = "to_client_id")
    private Client toClient;

    @ManyToOne
    @JoinColumn(name = "from_office_id")
    private Office fromOffice;

    @ManyToOne
    @JoinColumn(name = "to_office_id")
    private Office toOffice;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    private LocalDate dateOfReceipt;
    private LocalDate dateOfIssue;

}
