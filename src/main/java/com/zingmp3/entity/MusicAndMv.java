package com.zingmp3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "music_mv")
@Getter
@Setter
public class MusicAndMv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private Date createdDate;

    private String linkMusic;

    private String imageBanner;

    private Integer block;

    private Integer type;

    private Integer numViews;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
