package blackJack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DrawBoard extends JFrame implements ActionListener, MouseListener{
	
	private GameState gamestate;
	
	private JPanel[] panel = new JPanel[2];
	private JPanel pnlMain;
	private JLabel lblTitle, lblDealerHand, lblYourHand, lblDeck, lblPlayerCoins, lblPot,
				lblScore, lblCoin1, lblCoin5, lblCoin25, lblCoin100, lblUserPrompt, lblDeckShuffled;
	private JButton leftButton, middleButton, rightButton;
	private ImageIcon ImgCoin1, ImgCoin5, ImgCoin25, ImgCoin100, ImgDeck;
	
	public DrawBoard()
	{
		initUI();
	}
	
	public void initUI()
	{
		pnlMain = new JPanel();
		pnlMain = new ImagePanel();
		pnlMain.setLayout(null);
		pnlMain.setBackground(new Color(0,170,20));
        
        lblTitle = new JLabel("Black Jack");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(10, 11, 169, 33);
        lblTitle.setFont(new Font("Clarendon Lt BT", Font.PLAIN, 30));
        pnlMain.add(lblTitle);
        
        lblScore = new JLabel("");
        lblScore.setForeground(new Color(255,255,95));
        lblScore.setBounds(150, 276, 40, 39);
        lblScore.setFont(new Font("Verdana", Font.PLAIN, 25));
        pnlMain.add(lblScore);
        
        lblPot = new JLabel("Pot: 0");
        lblPot.setForeground(new Color(255,255,95));
        lblPot.setBounds(468, 194, 141, 45);
        lblPot.setFont(new java.awt.Font("Verdana", 0, 25));
        pnlMain.add(lblPot);
        
        lblPlayerCoins = new JLabel("$ 1000");
        lblPlayerCoins.setForeground(new Color(255,255,95));
        lblPlayerCoins.setBounds(63, 313, 100, 45);
        lblPlayerCoins.setFont(new Font("Verdana", Font.PLAIN, 25));
        pnlMain.add(lblPlayerCoins);
        
        lblDealerHand = new JLabel("Dealer");
        lblDealerHand.setForeground(new Color(255,255,95));
        lblDealerHand.setBounds(63, 91, 100, 39);
        lblDealerHand.setFont(new Font("Verdana", Font.PLAIN, 24));
        pnlMain.add(lblDealerHand);
        
        lblYourHand = new JLabel("You");
        lblYourHand.setForeground(new Color(255,255,95));
        lblYourHand.setBounds(84, 276, 51, 39);
        lblYourHand.setFont(new Font("Verdana", Font.PLAIN, 24));
        pnlMain.add(lblYourHand);
        
        middleButton = new JButton("Deal");
        middleButton.setEnabled(true);
        middleButton.addActionListener(this);
        middleButton.setBounds(264, 388, 100, 25);
        pnlMain.add(middleButton);
        
	    leftButton = new JButton("Reset Bet");
	    leftButton.setForeground(Color.BLACK);
	    leftButton.setEnabled(true);
	    leftButton.addActionListener(this);
	    leftButton.setBounds(153, 388, 100, 25);
	    pnlMain.add(leftButton);
	    
        rightButton = new JButton("Max Bet");
        rightButton.setEnabled(true);
        rightButton.setBounds(374, 388, 102, 25);
        rightButton.addActionListener(this);
        pnlMain.add(rightButton);
        
        panel[0] = new JPanel();
        panel[0].setLayout(null);
        panel[0].setOpaque(false);
        //panel[0].setBackground(new Color(0, 170, 20));
        panel[0].setBounds(185, 62, 237, 117);
        pnlMain.add(panel[0]);
        
        panel[1] = new JPanel();
        panel[1].setLayout(null); 
        panel[1].setOpaque(false);
        //panel[1].setBackground(new Color(0,170,20));
        panel[1].setBounds(189, 250, 237, 117);
        pnlMain.add(panel[1]);
        
        ImgCoin1 = new ImageIcon(getClass().getResource("/res/coin1.png"));
        lblCoin1 = new JLabel(ImgCoin1);
        lblCoin1.setSize(71, 62);
        lblCoin1.setLocation(437, 240);
        lblCoin1.setToolTipText("Bets 1 coin");
        lblCoin1.addMouseListener(this);
        pnlMain.add(lblCoin1);
		
        ImgCoin5 = new ImageIcon(getClass().getResource("/res/coin5.png"));
        lblCoin5 = new JLabel(ImgCoin5);
        lblCoin5.setSize(71, 62);
        lblCoin5.setLocation(499, 238);
        lblCoin5.setToolTipText("Bets 5 coins");
        lblCoin5.addMouseListener(this);
        pnlMain.add(lblCoin5);
		
        ImgCoin25 = new ImageIcon(getClass().getResource("/res/coin25.png"));
        lblCoin25 = new JLabel(ImgCoin25);
        lblCoin25.setSize(71, 62);
        lblCoin25.setLocation(468, 282);
        lblCoin25.setToolTipText("Bets 25 coins");
        lblCoin25.addMouseListener(this);
        pnlMain.add(lblCoin25);
		
        ImgCoin100 = new ImageIcon(getClass().getResource("/res/coin100.png"));
        lblCoin100 = new JLabel(ImgCoin100);
        lblCoin100.setSize(71, 62);
        lblCoin100.setLocation(528, 282);
        lblCoin100.setToolTipText("Bets 100 coins");
        lblCoin100.addMouseListener(this);
        pnlMain.add(lblCoin100);
		
		lblUserPrompt = new JLabel("Welcome To Black Jack :)");
		lblUserPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPrompt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserPrompt.setForeground(Color.WHITE);
		lblUserPrompt.setBounds(117, 35, 380, 45);
		lblUserPrompt.setVisible(true);
		pnlMain.add(lblUserPrompt);
		
		lblDeckShuffled = new JLabel("Deck Shuffled");
		lblDeckShuffled.setBounds(481, 122, 103, 33);
		lblDeckShuffled.setVisible(false);
		lblDeckShuffled.setForeground(Color.WHITE);
		lblDeckShuffled.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		pnlMain.add(lblDeckShuffled);
		
		//ImageIcon deckImage = new ImageIcon("res/Deck.png");
		ImgDeck = new ImageIcon(getClass().getResource("/res/Deck.png"));
		lblDeck = new JLabel(ImgDeck);
		lblDeck.setBounds(467, 11, 132, 100);
		pnlMain.add(lblDeck);
		lblDeck.setToolTipText("Deck of Cards");
		
		getContentPane().add(pnlMain);
		
        setTitle("Black Jack");
        setSize(615, 452);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setGameState(GameState gs)
	{
		gamestate = gs;
	}
	
	public void drawGame(Deck deck, Player player1, Person dealer, int coins)
	{
		drawHand(player1);
		drawHand(dealer);
		setCoins(player1);
		setBetValue();
		setScore(player1);
		validate();
		repaint();
	}
	
	public void setBetValue()
	{
		lblPot.setText("Pot: " + gamestate.getBet());
	}
	
	public void setCoins(Player player)
	{
		lblPlayerCoins.setText("$ " + player.getCoins());
	}
	
	public void setScore(Player player)
	{
		if(player.getScore() != 0)
			lblScore.setText("" + player.getScore());
	}

	public void drawHand(Person d)
	{
		if(d.getHandSize() == 0)
		{
			removeHandDisplay(d);
			return;
		}
		
	     for(int i = 0; i < d.getHandSize(); i++)
	     {
	    	 Card c = d.getCard(i);
	    	 ImageIcon cardImage;
	    	 
	    	 if(c.isCardFlipped())
	    		cardImage = new ImageIcon(getClass().getResource("/res/BackFace.png"));
	    	 else
	    	 	cardImage = new ImageIcon(getClass().getResource("/res/" + c.toString() + ".png"));
	    	 
	    	 JLabel cardLabel = new JLabel(cardImage);
			 cardLabel.setBounds(-60 + (i * 25), 10, 200, 100); 
			 //pnlDealer.add(cardLabel, 0);
			 panel[d.getPanelIndex()].add(cardLabel, 0);
	     }
		 pnlMain.revalidate();
		 pnlMain.repaint();
	}
	
	///NOTE
	public void removeHandDisplay(Person p)
	{
		panel[p.getPanelIndex()].removeAll();
		panel[p.getPanelIndex()].revalidate();
		panel[p.getPanelIndex()].repaint();
	}
	
	public void setRoundView()
	{
		rightButton.setText("Rules");
		middleButton.setText("Hit Me");
		leftButton.setText("Stand");
		
		middleButton.setEnabled(true);
		leftButton.setEnabled(true);
		rightButton.setEnabled(true);
		
		lblUserPrompt.setVisible(false);
		
		lblCoin1.setEnabled(false);
		lblCoin5.setEnabled(false);
		lblCoin25.setEnabled(false);
		lblCoin100.setEnabled(false);
	}
	
	public void resetGameView()
	{
		leftButton.setText("Reset Bet");
		leftButton.setEnabled(true);
		middleButton.setText("Deal");
		middleButton.setEnabled(true);
		rightButton.setText("Max Bet");
		rightButton.setEnabled(true);
		
		lblCoin1.setEnabled(true);
		lblCoin5.setEnabled(true);
		lblCoin25.setEnabled(true);
		lblCoin100.setEnabled(true);
		
		lblDeckShuffled.setVisible(false);
		lblScore.setText("");
		lblUserPrompt.setVisible(false);
	}
	
	public void evaluateWinnerView()
	{
		leftButton.setEnabled(false);
		rightButton.setEnabled(true);
		lblUserPrompt.setVisible(true);
		middleButton.setEnabled(true);
		middleButton.setText("Play Again");
		rightButton.setText("Exit");
	}
	
	public void displayUserPrompt(String prompt)
	{
		lblUserPrompt.setText(prompt);
		lblUserPrompt.setVisible(true);
	}
	
	public void displayDeckShuffled()
	{
		lblDeckShuffled.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton) e.getSource();
		gamestate.buttonClick(temp.getText());
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		
		JLabel temp = (JLabel) m.getSource();
		if(temp.isEnabled()){
			gamestate.labelClick(temp.getToolTipText());
		}
	}

	@Override
	public void mouseEntered(MouseEvent m) {
	
		JLabel test = (JLabel) m.getSource();
		ImageIcon newIcon = new ImageIcon();
		
		//instead of tooltiptext have a coin class and a function to return which coin was pressed
		if(test.getToolTipText() == "Bets 1 coin")
			newIcon = new ImageIcon(getClass().getResource("/res/coin1highlight.png"));
		else if(test.getToolTipText() == "Bets 5 coins")
			newIcon = new ImageIcon(getClass().getResource("/res/coin5highlight.png"));
		else if(test.getToolTipText() == "Bets 25 coins")
			newIcon = new ImageIcon(getClass().getResource("/res/coin25highlight.png"));
		else if(test.getToolTipText() == "Bets 100 coins")
			newIcon =new ImageIcon(getClass().getResource("/res/coin100highlight.png"));
		
		test.setIcon(newIcon);
	}

	@Override
	public void mouseExited(MouseEvent m) {
		
		JLabel test = (JLabel) m.getSource();
		ImageIcon newIcon = new ImageIcon();
			
		if(test.getToolTipText() == "Bets 1 coin")
			newIcon = new ImageIcon(getClass().getResource("/res/coin1.png"));
		else if(test.getToolTipText() == "Bets 5 coins")
			newIcon = new ImageIcon(getClass().getResource("/res/coin5.png"));
		else if(test.getToolTipText() == "Bets 25 coins")
			newIcon = new ImageIcon(getClass().getResource("/res/coin25.png"));
		else if(test.getToolTipText() == "Bets 100 coins")
			newIcon = new ImageIcon(getClass().getResource("/res/coin100.png"));
			
		test.setIcon(newIcon);
	}

	@Override
	public void mousePressed(MouseEvent m) {
		return;
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		return;
	}
}
