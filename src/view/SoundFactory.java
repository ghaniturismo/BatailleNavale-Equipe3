package view;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SoundFactory {

	/**
	 * Instance unique pré-initialisée
	 */
	private static SoundFactory INSTANCE = new SoundFactory();
	
	/**
	 * Attributs pour gérer la musique de fond
	 */
	AudioInputStream audio; 
	
	/**
	 * Musique du jeu
	 */
	Clip SonDuFond;
	
	/**
	 * Constructeur privé
	 */
	private SoundFactory() {
		try {
			audio = AudioSystem.getAudioInputStream(new File("/source/son/generic1.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, audio.getFormat());
			SonDuFond = (Clip)AudioSystem.getLine(info);
			SonDuFond.open(audio);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("audio error");
		} 
	}
	
	public static SoundFactory getInstance() {
		return INSTANCE;
	}
	
	public Clip getBackgroundSound() {
		return SonDuFond;
	}
	
}