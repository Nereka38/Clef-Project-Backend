package net.project.clef.music.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.project.clef.music.entity.Music;
import net.project.clef.music.repository.MusicRepository;

@Service
public class MusicServiceImpl implements MusicService {
    MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public List<Music> getAll() {
        List<Music> music = new ArrayList<>();
        musicRepository.findAll().forEach(music::add);
        return music;
    }

    @Override
    public Music getById(Long id) {
        return musicRepository.findById(id).get();
    }

    @Override
    public Music insert(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public void updateMusic(Long id, Music music) {
        Music musicFromDb = musicRepository.findById(id).get();
        System.out.println(musicFromDb.toString());
        musicFromDb.setAlbum(music.getAlbum());
        musicFromDb.setArtist(music.getArtist());
        musicFromDb.setDate(music.getDate());
        musicFromDb.setImagealbum(music.getImagealbum());
        musicRepository.save(musicFromDb);
    }

    @Override
    public void deleteMusic(Long musicId) {
        musicRepository.deleteById(musicId);
    }
}
