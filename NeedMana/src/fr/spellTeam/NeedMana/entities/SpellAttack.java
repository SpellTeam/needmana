package fr.spellTeam.NeedMana.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.spellTeam.NeedMana.Game;

public class SpellAttack extends Spell implements GameObject{
	public SpellAttack(int id, String name, String description, int degats, int effetMax, String sprite, String icone, Vector2 position) {
		super(id, name, description, degats, effetMax, sprite, icone, position);
		spawn(Game.getInstance().getPlayer().position.x + Game.getInstance().getPlayer().width - 5,Game.getInstance().getPlayer().position.y);
	}
	
	public void spawn(float x, float y){
		getPosition().x = x;
		getPosition().y += y+((Game.getInstance().getPlayer().getHeight()*0.40f));
	}
	
	public void move(float dx){
		getPosition().x += dx * Gdx.graphics.getDeltaTime() * 30;	
	}
	
	public void checkCol(){
		
	}
	
	public void shoot(SpellAttack attack){
		Game.getInstance().addGameObject(attack);
	}
	
	@Override
	public void render(float delta, OrthographicCamera camera, SpriteBatch batch){
		batch.draw(new Sprite(new Texture("texture/"+getSprite())), getPosition().x, getPosition().y);
		move(25);
		checkCol();
	}
}