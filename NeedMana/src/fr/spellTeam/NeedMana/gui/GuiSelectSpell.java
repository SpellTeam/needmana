package fr.spellTeam.NeedMana.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.spellTeam.NeedMana.Game;
import fr.spellTeam.NeedMana.entities.Element;
import fr.spellTeam.NeedMana.entities.Spell;
import fr.spellTeam.NeedMana.utils.GenerateurSort;

public class GuiSelectSpell extends ClickListener implements Screen {

	private Stage stage;
	private Table table;
	private TextureAtlas atlas;
	private Skin skin;
	private Element [] listeElements;
	private Element [] composants;
	private Spell [] sorts;
	private GenerateurSort genSpell;
	private BitmapFont font;
	private int index1, index2, index3, indexSpell;
	private Element element1, element2, element3;
	private TextButton play, back, validateSpell, up1, up2, up3, down1, down2, down3;
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch batch = new SpriteBatch();
		
		batch.begin();
		batch.draw(new Texture(element1.getIcone()), 150, 351, 100, 100);
		
		batch.draw(new Texture(element2.getIcone()), 550, 351, 100, 100);

		batch.draw(new Texture(element3.getIcone()), 950, 351, 100, 100);
		
		if(sorts[0] !=null) {
			batch.draw(new Texture(sorts[0].getIcone()), 150, 100, 100, 100);
			font.draw(batch, sorts[0].getName(), 150, 110);
			//font.draw(batch, sorts[0].getDescription(), 0, 100);
		}
		
		if(sorts[1] !=null) {
			batch.draw(new Texture(sorts[1].getIcone()), 550, 100, 100, 100);
			font.draw(batch, sorts[1].getName(), 550, 110);
			//font.draw(batch, sorts[1].getDescription(), 350, 100);
		}
		
		if(sorts[2] !=null) {
			batch.draw(new Texture(sorts[2].getIcone()), 950, 100, 100, 100);
			font.draw(batch, sorts[2].getName(), 950, 110);
			//font.draw(batch, sorts[2].getDescription(), 750, 100);
		}
		batch.end();
		
		
		
		stage.act(delta);
		stage.draw();
		//Table.drawDebug(stage);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		listeElements = Element.getAllElements();
		element1 = element2 = element3 = listeElements[0];
		sorts = new Spell[3];
		composants = new Element[3];
		genSpell = new GenerateurSort();
		
		index1=0;
		index2=0;
		index3=0;
		indexSpell=0;
		
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas("ui/atlas.pack");
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		
		up1 = new TextButton("Element précédent", skin, "default");
		up2 = new TextButton("Element précédent", skin, "default");
		up3 = new TextButton("Element précédent", skin, "default");
		down1 = new TextButton("Element suivant", skin, "default");
		down2 = new TextButton("Element suivant", skin, "default");
		down3 = new TextButton("Element suivant", skin, "default");
		
		up1.pad(15);
		up2.pad(15);
		up3.pad(15);
		down1.pad(15);
		down2.pad(15);
		down3.pad(15);
		
		validateSpell = new TextButton ("Valider le sort", skin, "default");
		validateSpell.pad(15);
		validateSpell.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(indexSpell < 3) {
					composants[0]=element1;
					composants[1]=element2;
					composants[2]=element3;
					
					sorts[indexSpell] = genSpell.createSpell(composants);
					
					indexSpell++;
				}
			}
		});
		
		play = new TextButton("Jouer", skin, "default");
		play.pad(15);
		play.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y) {
				//((Game) Gdx.app.getApplicationListener()).setScreen(new GuiInGame("lvl0"));
				Game.appelerGuiInGame();
			}
		});
		back = new TextButton("Retour", skin, "default");
		back.pad(15);
		back.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//((Game) Gdx.app.getApplicationListener()).setScreen(new GuiLevels());
				Game.appelerGuiLevels();
			}
		});
		table.add("Select Spells").colspan(3).center().expandX().spaceBottom(30).row();
		
		table.add(up1);
		table.add(up2);
		table.add(up3).row();
		
		table.add().colspan(3).center().expandX().spaceTop(50).spaceBottom(50).row();
		
		up1.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(index1 > 0) {
					index1--;
					element1 = listeElements[index1];
				}
			}
		});
		up2.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(index2 > 0) {
					index2--;
					element2 = listeElements[index2];
				}
			}
		});
		up3.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(index3 > 0) {
					index3--;
					element3 = listeElements[index3];
				}
			}
		});
		
		table.add(down1);
		table.add(down2);
		table.add(down3).row();
		
		down1.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(index1 < 7) {
					index1++;
					element1 = listeElements[index1];
				}
			}
		});
		down2.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(index2 < 7) {
					index2++;
					element2 = listeElements[index2];
				}
			}
		});
		down3.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(index3 < 7) {
					index3++;
					element3 = listeElements[index3];
				}
			}
		});
		
		table.add(validateSpell).colspan(3).center().expandX().spaceTop(15).spaceBottom(15).row();
		
		table.add().center().height(80);
		table.add().center().height(80);
		table.add().center().height(80).row();
		
		table.add(play).width(200).center().colspan(2).right().padRight(95).spaceTop(30);
		table.add(back).center().colspan(1).right().padRight(100).spaceTop(30);
		
		table.debug();
		stage.addActor(table);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		stage.dispose();
		atlas.dispose();
		skin.dispose();
	}
}
