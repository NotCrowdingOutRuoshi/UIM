package UIM;
import javax.swing.JPanel;

import DOM.DOM;
import Entitys.Direction;
import Entitys.Player;
import TCP.TCP;

public class GameManager {

	private String status;
	private Director director;
	private JPanel statusPanel;
	private Player player;
	private DOM dom;
	private TCP tcp;
	
	/**
     * �ϥ��R�A�ܼưO��Singleton, �ëإ߹��
     */
    private static GameManager singleton;

  
    /**
     * ���~���u��z�L�o��method���oSingleton���
     */
    public static GameManager getInstance() {
    	if (singleton == null) {
            singleton = new GameManager();
        }
        return singleton;
    }
	
    private GameManager(){
		tcp = new TCP();
	}
    
    public void setDom(DOM dom){
    	this.dom = dom;
    }
    
    public void setDirector(Director director){
    	this.director = director;
    }
	
	public void setGameStatus(String status){
		this.status = status;
		switch(this.status){
		case "menu":
			MenuScene ms = new MenuScene();
			statusPanel = ms;
			break;
		case "wait":
			player = new Player();
			WaitScene ws = new WaitScene(dom);
			statusPanel = ws;
			break;
		case "game":
			GameScene gs = new GameScene(dom,player);
			//KeyAdapterDemo k = new KeyAdapterDemo(gs);
			statusPanel = gs;
			break;
		case "gameover":
			GameOverScene gos = new GameOverScene();
			statusPanel = gos;
			break;
		
		}
		
		this.director.setpanel(statusPanel);
		statusPanel.requestFocusInWindow();
	}
	
	public void setClientId(int clientid){
		player.setID(clientid);
	}
	
	public void setCountdown(){
		
	}
	
	public void addPlayer(Player player){
		dom.addPlayer(player);
	}
	
	public void sendtoTcp(String s){
		System.out.println(s);
		tcp.send();
	}
	
	
}
