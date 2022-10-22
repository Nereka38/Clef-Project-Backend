package net.project.clef.music.service;

import java.util.List;

import net.project.clef.music.entity.Music;

/* @Service
public class MusicService {

    @Autowired
    MusicRepository musicRepository;
    
    public List<Music> getAll() {
        return musicRepository.findAll();
    }
    public Music store(Music add) {
        return musicRepository.save(add);
    }
    public void deleteMusic(Long id) {
        musicRepository.deleteById(id);   
    }

public Music updateMusic(Long id, Music musicDetails) {
    Music music = musicRepository.findById(id).get();
    music.setAlbum(musicDetails.getAlbum());
    music.setArtist(musicDetails.getArtist());
    music.setDate(musicDetails.getDate());
    music.setImagealbum(musicDetails.getImagealbum());
    
    return musicRepository.save(music); 
    }    

}
 */
public interface MusicService {
    List<Music> getAll();

    Music getById(Long id);

    Music insert(Music music);

    void updateMusic(Long id, Music music);

    void deleteMusic(Long musicId);
}