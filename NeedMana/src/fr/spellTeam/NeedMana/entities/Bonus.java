package fr.spellTeam.NeedMana.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.spellTeam.NeedMana.Game;

public class Bonus extends Spell {
	public Bonus(int id, String name, String description, int degats, int effetMax, String sprite, String icone, Vector2 position) {
		super(id, name, description, degats, effetMax, sprite, icone, position);
	}

	public void soin(int valeur){
	}
	
	public void affectVitesse(int valeur){
		Game.getInstance().getPlayer().mouvement.x += (float)valeur;
	}
	
	@Override
	public void render(float delta, OrthographicCamera camera, SpriteBatch batch) {
		
	}
}
