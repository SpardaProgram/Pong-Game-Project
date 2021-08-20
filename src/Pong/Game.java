package Pong;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	public static int largura = 300;
	public static int altura = 150;
	public static int escala = 5;
	
	public BufferedImage layer = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);
	
	private boolean active;
	
	public static Player player;
	
	public static Cpu cpu;
	
	public static Ball ball;
	
	public Game() {
		active=true;
		this.setPreferredSize(new Dimension(largura*escala,altura*escala));
		player = new Player(largura/2-20,altura-10);
		addKeyListener(this);
		cpu = new Cpu(largura/2-20,10);
		ball = new Ball(largura/2,altura/2);
	}
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		
		new Thread(game).start();;
		
		
		
		
	}
	public void tick() {
		player.tick();
		cpu.tick();
		ball.tick();		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,largura,altura);
		player.render(g);
		cpu.render(g);
		ball.render(g);
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, largura*escala, altura*escala,null);
		bs.show();
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		double fps = 60.0;
		double ns = 1000000000/fps;
		double delta=0;
		while(active) {
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime=now;
			if(delta>=1) {
				tick();
				render();
				delta--;
			}
			
		}
		
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			
			player.right = true;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_P) {
			ball.isMoving = false;
		}
		
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			
			player.right = false;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
			
		}
		
		
	}
	public void keyTyped(KeyEvent e) {
		
	
		
	}
	
	
}