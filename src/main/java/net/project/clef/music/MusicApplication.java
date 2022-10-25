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

			Music music4 = Music.builder()
					.artist("Taylor Swift")
					.album("Midnights")
					.date("20/10/2022")
					.imagealbum("https://i.scdn.co/image/ab67616d00001e0294e71ca5acea8203c4aa120c")
					.build();

			Music music5 = Music.builder()
					.artist("The Weeknd")
					.album("Dawn FM")
					.date("10/01/2022")
					.imagealbum("https://i.scdn.co/image/ab67616d0000b2734ab2520c2c77a1d66b9ee21d")
					.build();

			Music music6 = Music.builder()
					.artist("Rosalía")
					.album("MOTOMAMI")
					.date("10/02/2022")
					.imagealbum("https://i.scdn.co/image/ab67616d0000b2730c179967a265de0fc76382fe")
					.build();

			Music music7 = Music.builder()
					.artist("BTS")
					.album("Proof")
					.date("10/05/2022")
					.imagealbum("https://i.scdn.co/image/ab67616d0000b27317db30ce3f081d6818a8ad49")
					.build();
	
			musicRepository.save(music1);
			musicRepository.save(music2);
			musicRepository.save(music3);
			musicRepository.save(music4);
			musicRepository.save(music5);
			musicRepository.save(music6);
			musicRepository.save(music7);
		}

}
