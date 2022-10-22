package net.project.clef.music.controller;

import net.project.clef.music.entity.Music;
import net.project.clef.music.service.MusicService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api")
/* @CrossOrigin ("http://127.0.0.1:5173/") */
/* @CrossOrigin("*") */
@CrossOrigin("http://localhost:8080")

public class MusicController {
    @Autowired
    private MusicService musicService;

  @GetMapping("/musics")
  public List<Music> getAll() {
    return musicService.getAll();
  }

  @PostMapping("/musics")
  public Music store(@RequestBody Music add) {
    Music music = musicService.store(add);    
    return music;
  }
  
  @DeleteMapping("/musics/{id}")
  public Map<String, String> deleteMusic(@PathVariable Long id) {
   Map<String,String> message = musicService.delete(id);
   return message;    
  }

  @PutMapping("/products/{id}")
  public Music updateMusic(@PathVariable Long id, @RequestBody Music music){    
    return musicService.update(id, music);
  }

}
