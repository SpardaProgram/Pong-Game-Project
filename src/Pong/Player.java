package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public int largurap,alturap;
	
	public boolean right,left;
	
	public int x,y;
	
	public Player(int x, int y) {
		this.x=x;
		this.y=y;
		this.largurap=40;
		this.alturap=5;
	}
	
	public void tick(){
		if(right) {
			
			x=x+2;
		}
		else if(left) {
			
			x=x-2;
		}
		if (x+largurap > Game.largura) {
			x = Game.largura - largurap;
		}
		else if(x < 0) {
			x=0;
		}
	
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x+10, y,largurap-20,alturap);
		g.setColor(Color.RED);
		g.fillRect(x, y, largurap-30, alturap);
		g.fillRect(x+30, y, largurap-30, alturap);
}
}