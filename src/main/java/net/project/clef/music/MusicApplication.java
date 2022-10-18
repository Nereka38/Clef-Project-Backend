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
					.build();
	
			Music music2 = Music.builder()
					.artist("Beyoncé")
					.album("Renaissance")
					.date("08/10/2022")
					.build();
	
			Music music3 = Music.builder()
					.artist("5SOS")
					.album("5SOS5")
					.date("01/10/2022")
					.build();
	
			musicRepository.save(music1);
			musicRepository.save(music2);
			musicRepository.save(music3);
		}

}
