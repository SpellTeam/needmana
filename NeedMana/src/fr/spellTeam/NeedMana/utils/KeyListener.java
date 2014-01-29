package fr.spellTeam.NeedMana.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import fr.spellTeam.NeedMana.Game;
import fr.spellTeam.NeedMana.entities.EntityPlayer;

public class KeyListener implements InputProcessor{

	
	static long previousTimer = 0;
	public boolean keyDown(int keycode) {
		switch(keycode){
		
			case Keys.ESCAPE:
				Game.getInstance().quit();
				break;
		
		}
		return false;
	}

	public boolean keyUp(int keycode) {
		switch(keycode){
		
		case Keys.LEFT:
			Game.getInstance().getPlayer().move(0);
			break;
		case Keys.RIGHT:
			Game.getInstance().getPlayer().move(0);
			break;
		case Keys.A:
			Game.getInstance().getPlayer().move(0);
			break;
		case Keys.D:
			Game.getInstance().getPlayer().move(0);
			break;
	
	}
		return false;
	}

	public boolean keyTyped(char character) {
		return false;
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	public boolean scrolled(int amount) {
		return false;
	}
	
	public void tick(){
		
		if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)){
			
			EntityPlayer p = Game.getInstance().getPlayer();
			if(p.getX()>0){
				p.move(-p.getMouvement().y);
			}
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)){
			
			EntityPlayer p = Game.getInstance().getPlayer();
			if (p.getX()<(Game.WIDTH -100))
			p.move(p.getMouvement().y);
		}
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)){
				EntityPlayer p = Game.getInstance().getPlayer();
				if (!p.getJumping()){
					p.jump();
				}
			
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.Q)){
			
				//long time = new Date().getTime();
				/*SpellAttack spell = new SpellAttack("texture/fireball.png");
				EntityPlayer p = Game.getInstance().getPlayer();
			
				if(time >= previousTimer + spell.getCd()) {
					p.shoot(spell);
					previousTimer = new Date().getTime();
					}
					*/
				}
			
		}
	}
	
