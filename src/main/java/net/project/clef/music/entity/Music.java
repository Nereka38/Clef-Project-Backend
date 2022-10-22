package net.project.clef.music.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "musics")

public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "album")
    private String album;

    @Column(name = "date")
    private String date;

    @Column(name = "imagealbum")
    private String imagealbum;
}
