package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Cpu {
	
	public double x,y;
	
	public int largurae,alturae;
	
	public Cpu(int x, int y) {
		this.x=x;
		this.y=y;
		this.largurae=40;
		this.alturae=5;
		
	}
	
	public void tick(){
		x+=(Game.ball.x - x - 18)*0.079;	
		
	
	}
	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int)x, (int)y,largurae,alturae);
		g.setColor(Color.PINK);
		g.fillRect((int)x, (int)y, largurae-30, alturae);
		g.fillRect((int)x+30, (int)y, largurae-30, alturae);
	}
}
