package fr.spellTeam.NeedMana.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Malus extends Spell{
	public Malus(int id, String name, String description, int degats, int effetMax, String sprite, String icone, Vector2 position) {
		super(id, name, description, degats, effetMax, sprite, icone, position);
	}

	@Override
	public void render(float delta, OrthographicCamera camera, SpriteBatch batch) {
		// TODO Auto-generated method stub
	}
}
