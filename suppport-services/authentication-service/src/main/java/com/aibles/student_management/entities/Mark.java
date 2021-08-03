package com.aibles.student_management.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="deligence", nullable = false)
    private double deligence;

    @Column(name="mid_point1", nullable = false)
    private double midpoint1;

    @Column(name="mid_point2", nullable = false)
    private double midpoint2;

    @Column(name="status", nullable = false)
    private String status;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sub_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id")
    private User user;


}
