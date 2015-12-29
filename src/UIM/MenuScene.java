package UIM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DOM.DOM;

public class MenuScene extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuScene() {
		this.setSize(900, 600);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JButton btn = new JButton("�C���}�l");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameManager.getInstance().setGameStatus("wait");
				GameManager.getInstance().setClientId(1);
				GameManager.getInstance().setGameStatus("game");
			}
		});
		btn.setBounds((this.getWidth()-100)/2, 50, 100, 30);
		
		JButton btn2 = new JButton("�C������");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"�m���x","�C������",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn2.setBounds((this.getWidth()-100)/2, 100, 100, 30);
		
		JButton btn3 = new JButton("���}");
		btn3.setBounds((this.getWidth()-100)/2, 150, 100, 30);
		
		add(btn);
		add(btn2);
		add(btn3);
	}

}
