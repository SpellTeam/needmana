package fr.spellTeam.NeedMana.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.spellTeam.NeedMana.Game;
import fr.spellTeam.NeedMana.entities.GameObject;

public class GuiInGame extends GuiScreen{

	private SpriteBatch batch;
	private OrthographicCamera camera;
	public GuiInGame(String txt){
		super("GuiInGame");
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Game.WIDTH, Game.HEIGTH);
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(201/255f, 178/255f, 144/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Game.getInstance().getCurrentRegion().render(delta, camera, batch);
		camera.setToOrtho(false, Game.WIDTH, Game.HEIGTH);
		batch.begin();
		
			
			for (GameObject o : Game.getInstance().getGameObject()){
				
				o.render(delta, camera, batch);
			}
		
		batch.end();
	}

	public void resize(int width, int height) {
		
	}

	public void show() {
		
	}

	public void hide() {
		
	}

	public void pause() {
		
	}

	public void resume() {
		
	}

	public void dispose() {
		
	}
	
	public SpriteBatch getBatch(){
		return batch;
	}
	
}
