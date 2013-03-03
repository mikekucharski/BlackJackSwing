package blackJack;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RulesBox extends JFrame {
	
	private JTextArea howToPlay;
	private JLabel lblTitle;
	private JPanel panel;
	
	public RulesBox() {
		initUI();
	}

	private void initUI()
	{	
		panel = new JPanel();
		panel.setBounds(0, 0, 363, 277);
        panel.setBackground(new Color(0,170,20));
        panel.setLayout(null);

        lblTitle = new JLabel("How To Play");
        lblTitle.setBounds(49, 22, 279, 41);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Traditional Arabic", Font.ITALIC, 36));
        panel.add(lblTitle);
        
        howToPlay = new JTextArea();
        howToPlay.setBounds(25, 61, 328, 205);
        howToPlay.setLineWrap(true);
        howToPlay.setWrapStyleWord(true);
        howToPlay.setFont(new java.awt.Font("Lucida Console", 0, 14));
        howToPlay.setBackground(new Color(0,170,20));
        howToPlay.setEditable(false);
        howToPlay.setText( "  " + 
        		"Each player is dealt two cards. The object of the game is to get as close to 21 as possible without going over. " +
        		"A hand with a higher total than 21 is a bust. " +
        		"Cards 2 through 10 are worth their face value, and face cards (jack, queen, king) are all worth 10. " +
        		"An ace's value is 11 unless this would cause the player to bust, in which case it is worth 1. "+

				"You may either \"hit\" or \"stand.\" " +
				"When you hit, another card will be dealt. " +
				"When you stand, your turn is over and control moves to the dealer." +
				" The dealer must hit until they have more than 17.");
        
	    panel.add(howToPlay);
	    
	    getContentPane().add(panel);
        
        setTitle("How To Play");
        setSize(367, 301);
	    setResizable(false);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
