package com.codegym.furama.model;

import javax.persistence.*;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer attachServiceId;

    @Column(name = "attach_service_name")
    private String attachServiceName;

    @Column(name = "attach_service_cost")
    private double attachServiceCost;

    @Column(name = "attach_service_unit")
    private int attachServiceUnit;

    @Column(name = "attach_service_status")
    private String attachServiceStatus;
}
