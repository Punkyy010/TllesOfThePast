package com.tavi.totp.sound;

import java.applet.Applet;
import java.applet.AudioClip;

import com.tavi.totp.Game;


public class Sound {

	public static final Sound moving = new Sound("/music/footstep.wav");
	public static final Sound ambient = new Sound("/music/ambiance.wav");
	public static final Sound shoot = new Sound("/music/monsterhurt.wav");
	public static final Sound pistol = new Sound("/music/pistol.wav");
	public static final Sound hurt = new Sound("/music/hurt.wav");
	public static final Sound shoot2 = new Sound("/music/pistol2.wav");
	public static final Sound powerup = new Sound("/music/powerup.wav");
	public static final Sound select = new Sound("/music/select.wav");
	public static final Sound notenough = new Sound("/music/enough.wav");
	public static final Sound pickup = new Sound("/music/pickup.wav");
	
	private AudioClip clip;

	
	public Sound(String name){
		try{
		clip = Applet.newAudioClip(Sound.class.getResource(name));
		}catch(Throwable e){
			e.printStackTrace();
		}
	}
	public void play() {
		try {
			new Thread() {
				public void run() {
					if(Game.sound)
					clip.play();
				}
			}.start();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
