package com.zingmp3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "music_singer")
@Getter
@Setter
public class MusicSinger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    @ManyToOne
    @JoinColumn(name = "musicAndMv_id")
    private MusicAndMv musicAndMv;
}
