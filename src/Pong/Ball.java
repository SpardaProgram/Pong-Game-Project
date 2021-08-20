package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball{
	public double x,y;
	
	public Game game;
	
	public int largurab,alturab;
	
	public double dx,dy;
	
	public double speed = 2.0;
	
	public boolean isMoving=true;
	
	public double getValorBatida(double playerX, double largurap, double bolaX) {
		return 2*((bolaX-playerX)/largurap)-1;
	}
	
	public double getAnguloSaida(double anguloDireita, double colisao) {
		return 90-(90-anguloDireita)*colisao;
	}

	
	public Ball(int x, int y) {
		this.x=x;
		this.y=y;
		this.largurab=4;
		this.alturab=4;
		double angle = 90;
		
		
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));	
			
		
		
		
	}
	
	
	
	



	
		
		
	







	public void tick(){
		
			if(x+(dx*speed)+largurab >=Game.largura) {
				dx*=-1;
			}
			else if(x+(dx*speed)<0) {
				dx*=-1;
			}
			if(y<0) {
				System.out.println("Your Point");
				new Game();
				return;
			}
			else if(y>=Game.altura) {
				System.out.println("Enemy Point");
				new Game();
				return;
		}
	
		
		
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),largurab,alturab);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y, Game.player.largurap,Game.player.alturap);
		Rectangle boundsCpu = new Rectangle((int)Game.cpu.x,(int)Game.cpu.y,Game.cpu.largurae,Game.cpu.alturae);
		if(bounds.intersects(boundsPlayer)) {
			
			double colisao=getValorBatida(Game.player.x,Game.player.largurap,Game.ball.x);
			double angle=getAnguloSaida(30,colisao);
			
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			
			dy*=-1;
			
			
			
			
			
			
			
		}
		
		else if(bounds.intersects(boundsCpu)) {
			double colisao=getValorBatida(Game.cpu.x,Game.cpu.largurae,Game.ball.x);
			double angle=getAnguloSaida(30,colisao);
			
			dx = Math.cos(Math.toRadians(angle));
			dy = -Math.sin(Math.toRadians(angle));
		
			dy*=-1;
		}
		x+=dx*speed;
		y+=dy*speed;
		
		
	}
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y,largurab,alturab);
	}

	

	}
		
	
		
	