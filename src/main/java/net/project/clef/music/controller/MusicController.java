package net.project.clef.music.controller;

import net.project.clef.music.entity.Music;
import net.project.clef.music.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin ("http://127.0.0.1:5173/")

public class MusicController {
    @Autowired
    private MusicRepository musicRepository;

    @GetMapping("/musics")
    public List<Music> fetchMusics(){
        return musicRepository.findAll();
    }
}
