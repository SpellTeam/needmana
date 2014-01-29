package fr.spellTeam.NeedMana.gui;

//import aurelienribon.tweenengine.Timeline;
//import aurelienribon.tweenengine.Tween;
//import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.spellTeam.NeedMana.Game;

public class GuiMenu extends GuiScreen {	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton playButton, exitButton;
	private Label heading;
//	private TweenManager tweenManager;
	
	public GuiMenu(){
		
		super("GuiMenu");
		
		//batch = new SpriteBatch();
		//camera = new OrthographicCamera(Game.WIDTH, Game.HEIGTH);

		
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		stage.act(delta);
		stage.draw();
//		Table.drawDebug(stage);
	}

	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
		table.invalidateHierarchy();
		table.setSize(width, height);
	}

	public void show() {
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("ui/atlas.pack");
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);
		
		table = new Table(skin);
		table.setBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		// creation de l'entete
			heading = new Label("NeedMana", skin);
			heading.setFontScale(2);
		
		// création du bouton jouer
		playButton = new TextButton("Jouer", skin, "default");
		playButton.padLeft(23);
		playButton.padRight(23);
		playButton.padTop(15);
		playButton.padBottom(15);
		
		playButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//((Game) Gdx.app.getApplicationListener()).setScreen(new GuiLevels());
				Game.appelerGuiLevels();
			}
		});
		
		
		// création bouton quitter
		exitButton = new TextButton("Quitter", skin, "default");
		exitButton.pad(15);
		exitButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
			
		});
		
		
		// tous les trucs dans la table ouech
		table.add(heading);
		table.getCell(heading).spaceBottom(50);
		table.row();
		table.padBottom(50);
		table.add(playButton);
		table.getCell(playButton).spaceBottom(20);
		table.row();
		table.add(exitButton);
//		table.debug(); // voir les lignes des tableaux
		stage.addActor(table);
		
//		// création d'animation
//		tweenManager = new TweenManager();
//		Tween.registerAccessor(Actor.class, new ActorAccessor());
//		
//		// heading et boutons fade in
//		video 8, min 30.
//		Timeline.createSequence().beginSequence()
//			.push(Tween.set(playButton, ActorAccessor.ALPHA).target(0))
//			.push(Tween.set(exitButton, ActorAccessor.ALPHA).target(0))
//			.push(Tween.from(heading, ActorAccessor.ALPHA,  10f).target(0))
//			.push(Tween.to(playButton, ActorAccessor.ALPHA, 10f).target(1))
//			.push(Tween.to(exitButton, ActorAccessor.ALPHA, 10f).target(1))
//			.end().start(tweenManager);
	}

	public void hide() {
		
	}

	public void pause() {
		
	}

	public void resume() {
		
	}

	public void dispose() {
		stage.dispose();
		atlas.dispose();
		skin.dispose();
	}
	
}
