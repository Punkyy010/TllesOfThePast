package com.tavi.totp.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import com.tavi.totp.Game;


public class Keyboard implements KeyListener {
	public class Key{
	
		public Key() {
			keys.add(this);
		}
		
	public int absorbs,presses;
	public boolean clicked,down;
	
	public void toggle(boolean pressed){
		if(pressed != down){
			down = pressed;
		}
		if(pressed){
			presses++;
		}
	}
	
	public void tick(){
		if (absorbs < presses) {
			absorbs++;
			clicked = true;
		} else {
			clicked = false;
		}
	}
}
	
	public Keyboard(Game game){
		game.addKeyListener(this);
	}
	
	public List<Key> keys = new ArrayList<Key>();
	
	public Key up = new Key();
	public Key down = new Key();
	public Key right = new Key();
	public Key left = new Key();
	public Key space = new Key();
	public Key shift = new Key();
	public Key enter = new Key();
	public Key one = new Key();
	public Key two = new Key();
	public Key three = new Key();
	public Key five = new Key();
	public Key four = new Key();
	public Key esc = new Key();
	public Key e = new Key();
	
	public void releaseAll(){
		for(int i = 0 ; i < keys.size();i++){
			keys.get(i).down = false;
		}
	}

	public void tick(){
		for(int i = 0;i <keys.size();i++){
			keys.get(i).tick();
		}
	}
	
	public void toggle(KeyEvent key,boolean pressed){
		
		if(key.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_SPACE) space.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_SHIFT) shift.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_1) one.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_2) two.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_3) three.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_4) four.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_5) five.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_ESCAPE) esc.toggle(pressed);
		if(key.getKeyCode() == KeyEvent.VK_E) e.toggle(pressed);
		
	}

	
	public void keyPressed(KeyEvent key) {
		toggle(key,true);
	}

	public void keyReleased(KeyEvent key) {
		toggle(key,false);	
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
