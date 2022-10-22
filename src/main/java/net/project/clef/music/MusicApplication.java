package net.project.clef.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.project.clef.music.entity.Music;
import net.project.clef.music.repository.MusicRepository;

@SpringBootApplication
public class MusicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

		@Autowired
		private MusicRepository musicRepository;
	
		@Override
		public void run(String... args) throws Exception {
	
			Music music1 = Music.builder()
					.artist("5SOS")
					.album("5SOS5")
					.date("01/10/2022")
					.imagealbum("https://i.scdn.co/image/ab67616d0000b2738bfbaac83000c56775070328")
					.build();
	
			Music music2 = Music.builder()
					.artist("Beyoncé")
					.album("Renaissance")
					.date("29/07/2022")
					.imagealbum("https://i.scdn.co/image/ab67616d0000b2730e58a0f8308c1ad403d105e7")
					.build();
	
			Music music3 = Music.builder()
					.artist("Harry Styles")
					.album("Harry's House")
					.date("20/05/2022")
					.imagealbum("https://i.scdn.co/image/ab67616d0000b2732e8ed79e177ff6011076f5f0")
					.build();
	
			musicRepository.save(music1);
			musicRepository.save(music2);
			musicRepository.save(music3);
		}

}
