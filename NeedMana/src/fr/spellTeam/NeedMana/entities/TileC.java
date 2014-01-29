package fr.spellTeam.NeedMana.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class TileC extends Tile{

	protected Vector2 Pos;
	protected int WH;
	protected Rectangle r;
	
	public TileC(String name, int wh, Vector2 pos){
		super(name, new Texture(Gdx.files.internal("texture/tile.png")));
		this.name = name;
		this.Pos = pos;
		this.WH = wh;
		bounds = new Rectangle(Pos.x, Pos.y, WH, WH);
	}
	
	public void render(float delta, OrthographicCamera camera, SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(Texture, Pos.x, Pos.y, WH, WH);
	}
	
	public int getWH(){
		
		return WH;
	}

}
