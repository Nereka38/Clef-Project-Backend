package net.project.clef.music.controller;

import net.project.clef.music.entity.Music;
import net.project.clef.music.service.MusicService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* @RestController
@RequestMapping ("/api")
@CrossOrigin ("http://127.0.0.1:5173/")
@CrossOrigin("*")
@CrossOrigin("http://localhost:8080")

public class MusicController {
    @Autowired
    private MusicService musicService;

  @GetMapping("/musics")
  public List<Music> getAll() {
    return musicService.getAll();
  }

  @PutMapping("/musics/{id}")
  public Music readMusic(@PathVariable(value = "id") Long id, @RequestBody Music musicDetails) {
    return musicService.updateMusic(id, musicDetails);
  }

  @PostMapping("/musics")
  public Music store(@RequestBody Music add) {
    Music music = musicService.store(add);    
    return music;
  }
  
  @DeleteMapping("/musics/delete/{id}")
  public void deleteMusic(@PathVariable(value = "id") Long id) {
    musicService.deleteMusic(id);  
  }

} */

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/musics")
@CrossOrigin("http://127.0.0.1:5173/")

public class MusicController {
    MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public ResponseEntity<List<Music>> getAll() {
        List<Music> musics = musicService.getAll();
        return new ResponseEntity<>(musics, HttpStatus.OK);
    }
  
    @GetMapping({"/{musicId}"})
    public ResponseEntity<Music> getMusic(@PathVariable Long musicId) {
        return new ResponseEntity<>(musicService.getById(musicId), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Music> saveMusic(@RequestBody Music music) {
        Music music1 = musicService.insert(music);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("music", "/api/musics/" + music1.getId());
        return new ResponseEntity<>(music1, httpHeaders, HttpStatus.CREATED);
    }
   
    @PutMapping({"/{musicId}"})
    public ResponseEntity<Music> updateMusic(@PathVariable("musicId") Long musicId, @RequestBody Music music) {
        musicService.updateMusic(musicId, music);
        return new ResponseEntity<>(musicService.getById(musicId), HttpStatus.OK);
    }
    
    @DeleteMapping({"/{musicId}"})
    public ResponseEntity<Music> deleteMusic(@PathVariable("musicId") Long musicId) {
        musicService.deleteMusic(musicId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}