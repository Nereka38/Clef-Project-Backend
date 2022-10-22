package net.project.clef.music.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.project.clef.music.entity.Music;
import net.project.clef.music.repository.MusicRepository;

@Service
public class MusicService {

    @Autowired
    MusicRepository musicRepository;
    
    public List<Music> getAll() {
        return musicRepository.findAll();
    }
    public Music store(Music add) {
        return musicRepository.save(add); //guarda el repositorio
    }
    public Map<String,String> delete(Long id) {
        Map<String, String> message = new HashMap<>();
        if(musicRepository.findById(id).isPresent()){
           musicRepository.deleteById(id);
           message.put("message", "Eliminado correctamente");
           return message;
        }
        message.put("message", "Error al eliminar producto");
        return message;    
    }

    public Music update(Long id, Music modifyMusic) {
        return musicRepository.findById(id)
        .map((music)->{
            music.setAlbum(modifyMusic.getAlbum());
            music.setArtist(modifyMusic.getArtist());
            music.setDate(modifyMusic.getDate());
            music.setImagealbum(modifyMusic.getImagealbum());
            return musicRepository.save(music);
        })
        .orElseGet(()->{
           return musicRepository.save(modifyMusic);
        });      
    }    

}
