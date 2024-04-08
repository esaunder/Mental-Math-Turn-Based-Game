
import java.awt.EventQueue;
import java.io.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.Timer;

public class mentalMathGame extends JPanel implements ActionListener{
	Timer t = new Timer(400, this);
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	//main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mentalMathGame window = new mentalMathGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public mentalMathGame() {
		t.start();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenh = screenSize.height;
	int screenw = screenSize.width;
	static JLabel label_1 = new JLabel(""); static JLabel label_2= new JLabel(""); static JLabel label_3 = new JLabel(""); static JLabel label_4 = new JLabel(""); static JLabel label_5 = new JLabel("");
	public static void health(double r) {
		if (r == 5) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\u.png"));
			label_3.setIcon(new ImageIcon("Images\\u.png"));
			label_4.setIcon(new ImageIcon("Images\\u.png"));
			label_5.setIcon(new ImageIcon("Images\\u.png"));
		}
		else if (r == 4.5) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\u.png"));
			label_3.setIcon(new ImageIcon("Images\\u.png"));
			label_4.setIcon(new ImageIcon("Images\\u.png"));
			label_5.setIcon(new ImageIcon("Images\\ua.png"));
		}
		else if (r == 4) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\u.png"));
			label_3.setIcon(new ImageIcon("Images\\u.png"));
			label_4.setIcon(new ImageIcon("Images\\u.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
		else if (r == 3.5) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\u.png"));
			label_3.setIcon(new ImageIcon("Images\\u.png"));
			label_4.setIcon(new ImageIcon("Images\\ua.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
		else if (r == 3) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\u.png"));
			label_3.setIcon(new ImageIcon("Images\\u.png"));
			label_4.setIcon(new ImageIcon("Images\\ub.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
		else if (r == 2.5) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\u.png"));
			label_3.setIcon(new ImageIcon("Images\\ua.png"));
			label_4.setIcon(new ImageIcon("Images\\ub.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
		else if (r == 2) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\u.png"));
			label_3.setIcon(new ImageIcon("Images\\ub.png"));
			label_4.setIcon(new ImageIcon("Images\\ub.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
		else if (r == 1.5) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\ua.png"));
			label_3.setIcon(new ImageIcon("Images\\ub.png"));
			label_4.setIcon(new ImageIcon("Images\\ub.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
		else if (r == 1) {
			label_1.setIcon(new ImageIcon("Images\\u.png"));
			label_2.setIcon(new ImageIcon("Images\\ub.png"));
			label_3.setIcon(new ImageIcon("Images\\ub.png"));
			label_4.setIcon(new ImageIcon("Images\\ub.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
		else if (r == 0.5) {
			label_1.setIcon(new ImageIcon("Images\\ua.png"));
			label_2.setIcon(new ImageIcon("Images\\ub.png"));
			label_3.setIcon(new ImageIcon("Images\\ub.png"));
			label_4.setIcon(new ImageIcon("Images\\ub.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
		else if (r <= 0){
			label_1.setIcon(new ImageIcon("Images\\ub.png"));
			label_2.setIcon(new ImageIcon("Images\\ub.png"));
			label_3.setIcon(new ImageIcon("Images\\ub.png"));
			label_4.setIcon(new ImageIcon("Images\\ub.png"));
			label_5.setIcon(new ImageIcon("Images\\ub.png"));
		}
	}
	public static String mathQuestion(String choice) {
		int i = 0;
		
		if (diff.contentEquals("Easy")) {
			i = 2;
			time = 10000;
		}
		else if (diff.contentEquals("Medium")) {
			i = 4;
			time = 20000;
		}
		else if (diff.contentEquals("Hard")) {
			i = 6;
			time = 35000;
		}
		String ques = "";
		double [] p = new double[i];
		double t = i;
		int w = 0;
		double mult = 1, mod = 1;
		if (choice.contentEquals("A")) {
			mult = 1;
			mod = 8;
		}
		else if (choice.contentEquals("M")) {
			mult = 3;
			mod = 2;
		}
		else {
			mult = 1;
			mod = 2;
		}
		while (i >= 1) {
			double num1 = Math.round(Math.random() * mult);
			if (num1 == 0) {
				if (ques.length() >= 1) {
					ques += " + ";
				}
				num1 = Math.round((Math.random() * mod * t));
				if (choice.contentEquals("A") || choice.contentEquals("M")) {
					ques += num1;
					p[w] = num1;
				}
				else if (choice.contentEquals("I")){
					ques = ques + num1 + " * " + num1;
					p[w] = num1 * num1;
				}
			}
			else if (num1 == 1) {
				ques += " - ";
				num1 = Math.round((Math.random() * mod * t));
				if (choice.equals("A")|| choice.contentEquals("M")) {
					ques += num1;
					p[w] = -1 * num1;
				}
				else if (choice.contentEquals("I")){
					ques = ques + num1 + " * " + num1;
					p[w] = -1 * num1 * num1;
				}
			}
			else if (num1 == 2) {
				if (ques.length() >= 1) {
					ques += " * ";
				}
				num1 = Math.round((Math.random() * mod * t));
				
				if (ques.length() >= 1) {
					p[w] = num1 * p[w-1];
					p[w-1] = 0;
				}
				else {
					p[w] = num1;
				}
				ques += num1;
			}
			else if (num1 == 3) {
				if (ques.length() >= 1) {
					ques += " / ";
				}
				num1 = Math.round((Math.random()));
				if (num1 == 0) {
					num1 = 2;
				}
				else {
					num1 = 4;
				}
				if (ques.length() >= 1) {
					p[w] = p[w-1] / num1;
					p[w-1] = 0;
				}
				else {
					p[w] = num1;
				}
				ques += num1;
			}
			w++;
			i--;
		}
		sum = 0;
		for (double k: p) {
			sum += k;
		}
		return ques;
	}
	@SuppressWarnings({ "deprecation" })
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(0, 0, screenw, screenh);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Mental Math Game: The Journey");
		
		JButton btnLoadASave = new JButton("Load a save file");
		JButton btnStartANew = new JButton("Start a new game");
		JButton btnNewButton = new JButton("Click to start");
		JLabel lblHi = new JLabel("<HTML>In this game, to defeat your enemies, you will need to <BR>answer math questions. Click the button with the <BR>correct answer to successfully attack the enemy.<BR>But don't take too long to answer or you will be penalized.</HTML>");
		JButton button = new JButton("Continue");
		JLabel lblNewLabel_1 = new JLabel("Mental Math Game: The Journey");
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton_1 = new JButton("Save Game");
		JLabel lblMp = new JLabel(mp + "/5 MP");

		btnStartANew.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (z == 1) {	
					lblNewLabel_1.setText("Choose a difficulty");
					btnLoadASave.setText("Hard");
					btnStartANew.setText("Easy");
					btnNewButton.setText("Medium");
					btnNewButton.setVisible(true);
					z += 1;
				}
				else if (z == 2) {
					diff = "Easy";
					button.setVisible(true);
					btnNewButton_1.setVisible(true);
					btnLoadASave.setVisible(false);
					btnStartANew.setVisible(false);
					btnNewButton.setVisible(false);
					lblHi.setVisible(true);
					lblNewLabel_1.setText("Welcome to the mental math game!");
					z += 1;
				}
				else if (z == 6) {
					if (potion == 0) {
						lblHi.setText("You don't have any potions.");
					}
					else {
						
						lblHi.setText("What is the answer to " + mentalMathGame.mathQuestion("I") + "? (combo "+combo+")");
						textField.setVisible(true);
						btnStartANew.setVisible(false);
						btnLoadASave.setVisible(false);
						button.setVisible(false);
						btnNewButton.setBounds((int) (screenw/100), (int) (screenh*0.87), 180, 26);
						btnNewButton.setText("Enter");
						g = System.currentTimeMillis();
						z = 16;
					}
				}
			}
		});
		
		
		lbl1.setBounds((int)(screenw * 0.31), (int)(screenh*0.05), 800, 600);
		
		frame.getContentPane().add(lbl1);
		
		
		
		lblMp.setForeground(Color.CYAN);
		lblMp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMp.setBounds((int)(screenw * 0.01), (int)(screenh * 0.05), 200, 65);
		frame.getContentPane().add(lblMp);
		JButton btnMuteSound = new JButton("Mute Sound");
		btnMuteSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					Music.musics = false;
					if (Music.music1 == true) {
						musicOb.pauseMusic();
					}
					num = 1;
					btnMuteSound.setText("Unmute Sound");
				}
				else {
					Music.musics = true;
					num = 0;
					btnMuteSound.setText("Mute Sound");
					if (battle == true) {
						if (Music.music1 == false) {
							musicOb.playMusic(filename);
						}
						else {
							musicOb.resumeMusic();
						}
					}
					
				}
			}
		});
		btnMuteSound.setBounds((int)(screenw*0.7), (int) (screenh*0.02), 120, 20);
		frame.getContentPane().add(btnMuteSound);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				FileWriter fw = null;
				try {
					fw = new FileWriter("Save.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				PrintWriter output = new PrintWriter(fw);
				output.println(diff);
				output.println(y);
				output.println(r);
				output.println(gold);
				output.println(potion);
				output.println(mp);
				output.println(end);
				output.println(combo);
				output.close();
				try {
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds((int)(screenw*0.85), (int) (screenh*0.02), 120, 20);
		frame.getContentPane().add(btnNewButton_1);
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		lblNewLabel_1.setBounds((int)screenw/100, (int)(screenh*0.8), 1018, 75);
		frame.getContentPane().add(lblNewLabel_1);
		
		mentalMathGame.health(r);
		label_1.setBounds(0, 0, 200, 65);
		frame.getContentPane().add(label_1);
		
		
		label_2.setBounds((int)(screenw * 0.05), 0, 200, 65);
		frame.getContentPane().add(label_2);
		
		
		label_3.setBounds((int)(screenw * 0.1), 0, 200, 65);
		frame.getContentPane().add(label_3);
		
		
		label_4.setBounds((int)(screenw * 0.15), 0, 200, 65);
		frame.getContentPane().add(label_4);
		
	
		label_5.setBounds((int)(screenw * 0.2), 0, 200, 65);
		frame.getContentPane().add(label_5);
		
		
		label.setBounds((int)(screenw * 0.25), (int)(screenh*0.05), 800, 600);
		frame.getContentPane().add(label);
		
		
		lblNewLabel.setIcon(new ImageIcon("Images\\math.jpg"));
		lblNewLabel.setBounds(0, 0, screenw, (int) (screenh * 0.8));
		frame.getContentPane().add(lblNewLabel);
		
		
		lblHi.setForeground(Color.BLACK);
		lblHi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHi.setBounds((int)(screenw * 0.7), (int)(screenh*0.74), 600, 180);
		frame.getContentPane().add(lblHi);
		btnStartANew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStartANew.setBounds((int)(screenw * 0.5), (int)(screenh*0.87), 165, 39);
		frame.getContentPane().add(btnStartANew);
		
		
		btnLoadASave.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (z == 1) {
					Scanner sc = null;
					try {
						sc = new Scanner(new File("Save.txt"));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
						z = -1;
					}
					try {
						diff = sc.nextLine();
						y = sc.nextInt();
						r = sc.nextDouble();
						gold = sc.nextInt();
						potion = sc.nextInt();
						mp = sc.nextInt();
						end = sc.nextBoolean();
						combo = sc.nextInt();
						mentalMathGame.health(r);
						lblMp.setText(mp + "/5 MP");
						sc.close();
					}
					catch (Exception e1) {
						e1.printStackTrace();
						z = -1;
					}
					z += 2;
					if (z == 3) {
						button.setVisible(true);
						btnNewButton_1.setVisible(true);
						lblHi.setVisible(true);
						btnLoadASave.setVisible(false);
						btnStartANew.setVisible(false);
						btnNewButton.setVisible(false);
						lblNewLabel_1.setText("Welcome to the mental math game!");
					}
				}
				else if (z == 2) {
					diff = "Hard";
					button.setVisible(true);
					btnNewButton_1.setVisible(true);
					lblHi.setVisible(true);
					btnLoadASave.setVisible(false);
					btnStartANew.setVisible(false);
					btnNewButton.setVisible(false);
					lblNewLabel_1.setText("Welcome to the mental math game!");
					z += 1;
				}
				else if (z == 5) {
					y += 1;
					battle = false;
					btnLoadASave.setVisible(false);
					btnNewButton.setVisible(false);
					button.setVisible(true);
					if (y < text.length && end == false) {
						lblHi.setText(text[y]);
					}
					else {
						lblHi.setText("You continue to explore the world, looking for new challenges and surprises.");
						end = true;
						y = (int) (Math.round(Math.random() * (text.length - 2)));
						hi = (int) (Math.round(Math.random() * (shop.length - 1)));
					}
					lblNewLabel.setIcon(u[y]);
					z = 4;
					hi += 1;
					if (Music.music1 == true) {
						musicOb.stopMusic();
					}
				}
				else if (z == 6) {
					if (mp > 0) {
						
						lblHi.setText("What is the answer to " + mentalMathGame.mathQuestion("M") + "? (combo "+combo+")");
						textField.setVisible(true);
						btnStartANew.setVisible(false);
						btnLoadASave.setVisible(false);
						button.setVisible(false);
						btnNewButton.setBounds((int) (screenw/100), (int) (screenh*0.87), 180, 26);
						btnNewButton.setText("Enter");
						g = System.currentTimeMillis();
						mag = true;
						z = 8;
						mp -= 1;
						lblMp.setText(mp + "/5 MP");
					}
					else {
						lblHi.setText("You don't have any magic left!");
					}
				}
			}
		});
		btnLoadASave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoadASave.setBounds((int)(screenw * 0.8), (int)(screenh*0.87), 165, 39);
		frame.getContentPane().add(btnLoadASave);
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (z == 0) {
					btnNewButton.setVisible(false);
					z = 1;
					btnStartANew.setVisible(true);
					btnLoadASave.setVisible(true);
				}
				else if (z == 2) {
					diff = "Medium";
					button.setVisible(true);
					lblHi.setVisible(true);
					btnLoadASave.setVisible(false);
					btnStartANew.setVisible(false);
					btnNewButton.setVisible(false);
					btnNewButton_1.setVisible(true);
					lblNewLabel_1.setText("Welcome to the mental math game!");
					z = 3;
				}
				else if (z == 5) { 
					if (gold >= 5) {
						gold -= 5;
						potion += 1;
						lblHi.setText("<HTML>You bought a potion. Now you have " + potion + " potions <BR> and " + gold + " gold.");
						musicObj.playSound("Music\\purchase.wav");
					}
					else {
						lblHi.setText("You don't have enough gold. Please come again!");
					}
				}
				else if (z == 6) {
					double x = Math.random();
					if (x > 0.6 && y != 35) {
						musicObj.playSound("Music\\run.wav");
						lblHi.setText("You successfully escaped from the battle.");
						z = 3;
						run = 3;
						btnLoadASave.setVisible(false);
						btnStartANew.setVisible(false);
						btnNewButton.setVisible(false);
						lblNewLabel_1.setVisible(false);
						button.setText("Continue");
						button.setBounds((int)(screenw * 0.53), (int)(screenh*0.87), 180, 39);
						y += 1;
						musicOb.stopMusic();
						battle = false;
					}
					else {
						r -= (dam[y]*2);
						mentalMathGame.health(r);
						if (r <= 0) {
							lblHi.setText("<HTML>You failed to run away!<BR>The enemy attacks you dealing " + dam[y]*2 + " damage. <BR> You Died!!!</HTML>");
							z = 7;
							btnNewButton_1.setVisible(false);
							musicObj.playSound("Music\\wrong.wav");
							btnNewButton.setBounds((int)(screenw * 0.65), (int)(screenh*0.87), 165, 39);
							btnNewButton.setText("Restart");
							btnLoadASave.setVisible(false);
							btnStartANew.setVisible(false);
							button.setVisible(false);
							label.setVisible(false);
							y = 0;
							r = 5;
							combo = (int)(combo/4);
							battle = false; 
							if (Music.music1 == true) {
								musicOb.stopMusic();
							}
						}
						else {
							musicObj.playSound("Music\\wrong.wav");
							lblHi.setText("<HTML>You failed to run away!<BR>The enemy attacks you dealing " + dam[y] *2+ " damage.</HTML>");
							combo = (int) (combo / 2);
						}
						
					}
				}
				else if (z == 7) {
					btnNewButton.setText("Click to Start");
					lblNewLabel.setIcon(new ImageIcon("Images\\math.jpg"));
					z = 0;
					mp = 5;
					lblMp.setText(mp + "/5 MP");
					btnStartANew.setText("Start a New Game");
					btnLoadASave.setText("Load A Save");
					btnStartANew.setBounds((int)(screenw * 0.5), (int)(screenh*0.87), 165, 39);
					btnLoadASave.setBounds((int)(screenw * 0.8), (int)(screenh*0.87), 165, 39);
					lblNewLabel_1.setVisible(true);
					lblNewLabel_1.setText("Welcome to the Mental Math Game!");
					lblHi.setVisible(false);
					lblHi.setBounds((int)(screenw * 0.7), (int)(screenh*0.76), 600, 180);
					button.setBounds((int)(screenw * 0.53), (int)(screenh*0.87), 180, 39);
					lblNewLabel_1.setBounds((int)screenw/100, (int)(screenh*0.85), 1018, 75);
					lblNewLabel_1.setForeground(Color.black);
					button.setText("Continue");
					lblHi.setVisible(false);
					label.setVisible(false);
					lblMp.setVisible(false);
					battle = false;
					label_1.setVisible(false);
					label_2.setVisible(false);
					label_3.setVisible(false);
					label_4.setVisible(false);
					label_5.setVisible(false);
					mentalMathGame.health(r);
					lblHi.setText("<HTML>In this game, to defeat your enemies, you will need to <BR>answer math questions. Click the button with the <BR>correct answer to successfully attack the enemy.<BR>But don't take too long to answer or you will be penalized.</HTML>");
				}
				else if (z == 8) {
					
					double x = -1000000;
					try {
						x = Double.parseDouble(textField.getText());
					}
					catch (Exception ex){
						JOptionPane.showMessageDialog(null, "Please input a valid number next time.");
						musicObj.playSound("Music\\wrong.wav");
						combo = (int) (combo / 4);
					}
					f = -1* System.currentTimeMillis();
					long c = Long.sum(f, g);
					if (c < -time) {
						lblHi.setText("You took too long to answer. You miss your opportunity to attack.");
						musicObj.playSound("Music\\wrong.wav");
						combo = (int) (combo / 4);
					}
					else if (x == sum) {
						if (mag == true) {
							d = 4 + combo;
							magic = 3;
							hm = "an inferno of fire,";
							musicObj.playSound("Music\\fire.wav");
						}
						else {
							d = 2 + 0.25 * combo;
							attack = 3;
							hm = "your sword, performing an impressive cleave,";
							musicObj.playSound("Music\\sword.wav");
						}
						lblHi.setText("Correct answer! You hit your enemy with " + hm + " dealing " + d + " damage!");
						hp -= d;
						mag = false;
						combo += 1;
						
					}
					else if (x < sum && sum < x + 5 || x - 5 < sum && sum < x) {
						if (mag == true) {
							d = 2;
							magic = 3;
							hm = "with a ball of fire,";
							musicObj.playSound("Music\\fire.wav");
						}
						else {
							d = 1;
							hm = "your sword";
							attack = 3;
							musicObj.playSound("Music\\sword.wav");
						}
						lblHi.setText("Close but not correct. The correct answer was " + sum + ". You strike your foe lightly " + hm + " dealing " + d + " damage.");
						hp -= d;
						mag = false;
						combo = (int)(combo/2);
					}
					else {
						lblHi.setText("The correct answer was " + sum + ". You stumble over your own feet and fail to hit the enemy.");
						musicObj.playSound("Music\\wrong.wav");
						mag = false;
						combo = (int)(combo/4);
					}
					if (end == true && y < 30 && y != 19) {
						lblNewLabel_1.setText(hp + " / " + HP[y]*10);
					}
					else {
						lblNewLabel_1.setText(hp + " / " + HP[y]);
					}
					if (hp <=0) {
						z = 3;
						if (end == true && hp * 10 < 301 && y != 19) {
							lblHi.setText("You defeated the enemy with your attack. You gained " + money[y] * 5 + " gold.");
							gold += money[y] * 5;
						}
						else {
							lblHi.setText("You defeated the enemy with your attack. You gained " + money[y] + " gold.");
							gold += money[y];
						}
						btnNewButton.setVisible(false);
						textField.setVisible(false);
						button.setVisible(true);
						button.setText("Continue");
						textField.setText("");
						y += 1;
						
						lblNewLabel_1.setVisible(false);
						if (Music.music1 == true) {
							musicOb.stopMusic();
						}
						musicOb.playMusic("Music\\victory.wav");
						battle = false;
					}
					else {
						btnNewButton.setVisible(false);
						textField.setVisible(false);
						button.setVisible(true);
						button.setText("Continue");
						textField.setText("");
						z = 9;
					}
					btnNewButton.setText("Run");
				}
				else if (z == 16) {
					double x = -10000;
					try {
						x = Double.parseDouble(textField.getText());
					}
					catch (Exception ex){
						JOptionPane.showMessageDialog(null, "Please input a valid number next time.");
						musicObj.playSound("Music\\wrong.wav");
						combo = (int)(combo/4);
					}
					f = -1* System.currentTimeMillis();
					long c = Long.sum(f, g);
					if (c < -20000) {
						lblHi.setText("You took too long to answer. You fumble the potion and spill it all over the ground.");
						musicObj.playSound("Music\\wrong.wav");
						combo = (int)(combo/4);
					}
					else if (x == sum) {
						d = 3.5 + (combo/5)*0.5;
						lblHi.setText("Correct answer! You chug the potion at a world record pace, healing " + d + " hearts.");
						r += d;
						combo +=1;
						musicObj.playSound("Music\\heal.wav");
						if (r > 5) 
							r = 5;
					}
					else if (x < sum && sum < x + 5 || x - 5 < sum && sum < x) {
						lblHi.setText("Close but not correct. The correct answer was " + sum + ". You drink the potion and heal 2.5 hearts.");
						r += 2.5;
						combo = (int)(combo/2);
						musicObj.playSound("Music\\heal.wav");
						if (r > 5) {
							r = 5;
						}
					}
					else {
						lblHi.setText("The correct answer was " + sum + ". You forgot how to drink the potion and threw it away.");
						musicObj.playSound("Music\\wrong.wav");
						combo = (int)(combo/4);
					}
					mentalMathGame.health(r);
					potion -=1;
					btnNewButton.setVisible(false);
					textField.setVisible(false);
					button.setVisible(true);
					button.setText("Continue");
					textField.setText("");
					z = 9;
					btnNewButton.setText("Run");
			}
			}
		});
		btnNewButton.setBounds((int)(screenw * 0.65), (int)(screenh*0.87), 165, 39);
		frame.getContentPane().add(btnNewButton);
		
		
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (z == 3) {
					if (Music.music1 == true) {
						musicOb.stopMusic();
					}
					btnMuteSound.setVisible(true);
					lblHi.setBounds((int)(screenw/100), (int) (screenh * 0.75), 600, 200);
					button.setBounds((int)(screenw * 0.53), (int)(screenh*0.87), 180, 39);
					lblHi.setVisible(true);
					lblNewLabel_1.setVisible(false);
					if (y < text.length && end == false) {
						lblHi.setText(text[y]);
					}
					else {
						lblHi.setText("You continue to explore the world, looking for new challenges and surprises.");
						end = true;
						y = (int) (Math.round(Math.random() * (text.length - 2)));
						hi = (int) (Math.round(Math.random() * (shop.length - 1)));
					}
					label_1.setVisible(true);
					label_2.setVisible(true);
					label_3.setVisible(true);
					label_4.setVisible(true);
					label_5.setVisible(true);
					lblMp.setVisible(true);
					lblNewLabel.setIcon(u[y]);
					lblNewLabel.setVisible(true);
					z = 4;
				}
				else if (z == 4) {
					lblHi.setText(enemies[y]);
					lblHi.setBounds((int)(screenw/100),  (int) (screenh * 0.72), 1000, 200);
					z=5;
				}
				else if (z == 5) {
					if (y == 2 || y == 7 || y == 13 || y == 20 || y == 23 || y == 30 || y == 32 || y == 36) { 
						lblNewLabel.setIcon(shop[hi]);
						lblHi.setText("You have " + potion + " health potions and " + gold + " gold currently.");
						btnNewButton.setVisible(true);
						button.setVisible(false);
						btnNewButton.setBounds((int)(screenw*0.53), (int) (screenh * 0.88), 180, 40);
						btnNewButton.setText("Buy a potion: " + cost + " gold.");
						btnLoadASave.setVisible(true);
						btnLoadASave.setBounds((int)(screenw*0.73), (int) (screenh * 0.88), 180, 40);
						filename = music[y];
						battle = true;
						musicOb.playMusic(filename);
						mp += 2;
						r += 1.5;
						if (r > 5) {
							r = 5;
						}
						mentalMathGame.health(r);
						if (mp > 5) {
							mp = 5;
						}
						lblMp.setText(mp + "/5 MP");
						btnLoadASave.setText("Leave Shop");
					}
					else {
						battle = true;
						button.setBounds((int)(screenw*0.13), (int) (screenh * 0.88), 180, 40);
						btnLoadASave.setBounds((int)(screenw*0.33), (int) (screenh * 0.88), 180, 40);
						btnStartANew.setBounds((int)(screenw*0.53), (int) (screenh * 0.88), 180, 40);
						btnNewButton.setBounds((int)(screenw*0.73), (int) (screenh * 0.88), 180, 40);
						btnNewButton.setVisible(true);
						btnLoadASave.setVisible(true);
						btnStartANew.setVisible(true);
						button.setVisible(true);
						button.setText("Attack");
						btnLoadASave.setText("Magic");
						btnStartANew.setText("Potion");
						btnNewButton.setText("Run");
						label.setVisible(true);
						label.setIcon(enemy[y]);
						
						lblNewLabel_1.setVisible(true);
						z =6;
						filename = music[y];
						musicOb.playMusic(filename);
						lblNewLabel_1.setBounds((int)(screenw * 0.42), (int)(screenh*0.02), 300, 100);
						lblNewLabel_1.setForeground(Color.RED);
						hp = HP[y];
						if (end == true && hp * 10 < 301 && y !=19) {
							hp = HP[y] * 10;
							lblNewLabel_1.setText(hp + " / " + HP[y]* 10);
						}
						else {
							lblNewLabel_1.setText(hp + " / " + HP[y]);
							
						}
					}
				}
				else if (z == 6) {
					
					lblHi.setText("What is the answer to " + mentalMathGame.mathQuestion("A") + "? (combo "+combo+")");
					textField.setVisible(true);
					btnStartANew.setVisible(false);
					btnLoadASave.setVisible(false);
					button.setVisible(false);
					btnNewButton.setBounds((int) (screenw/100), (int) (screenh*0.87), 180, 26);
					btnNewButton.setText("Enter");
					g = System.currentTimeMillis();
					z = 8;
				}
				else if (z == 9) {
					
					r -= dam[y];
					mentalMathGame.health(r);
					if (r <= 0) {
						lblHi.setText("The enemy strikes you with a " + word[y] + " attack, dealing " + dam[y] + " damage. You died!");
						z = 7;
						btnNewButton.setBounds((int)(screenw * 0.65), (int)(screenh*0.87), 165, 39);
						btnNewButton.setText("Restart");
						btnNewButton.setVisible(true);
						btnLoadASave.setVisible(false);
						btnStartANew.setVisible(false);
						button.setVisible(false);
						label.setVisible(false);
						btnNewButton_1.setVisible(false);
						y = 0;
						r = 5;
						if (Music.music1 == true) {
							musicOb.stopMusic();
						}
					}
					else {
						z = 10;
						lblHi.setText("The enemy strikes you with a " + word[y] + " attack, dealing " + dam[y] + " damage.");
					}
					
				}
				else if (z == 10) {
					btnLoadASave.setVisible(true);
					btnStartANew.setVisible(true);
					btnNewButton.setVisible(true);
					button.setBounds((int)(screenw*0.13), (int) (screenh * 0.88), 180, 40);
					btnLoadASave.setBounds((int)(screenw*0.33), (int) (screenh * 0.88), 180, 40);
					btnStartANew.setBounds((int)(screenw*0.53), (int) (screenh * 0.88), 180, 40);
					btnNewButton.setBounds((int)(screenw*0.73), (int) (screenh * 0.88), 180, 40);
					button.setText("Attack");
					z = 6;
					
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds((int)(screenw * 0.53), (int)(screenh*0.87), 180, 39);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds((int) (screenw*.15), (int) (screenh*0.87), 460, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		btnStartANew.setVisible(false);
		btnLoadASave.setVisible(false);
		button.setVisible(false);
		lblHi.setVisible(false);
		label.setVisible(false);
		label_1.setVisible(false);
		lblMp.setVisible(false);
		label_2.setVisible(false);
		label_3.setVisible(false);
		btnNewButton_1.setVisible(false);
		label_4.setVisible(false);
		label_5.setVisible(false);
		textField.setVisible(false);
		lbl1.setVisible(false);
	}
	
	public static int z = 0, y = 0, num = 0, hi = 0;
	public static double hp;
	public static long g = 0, f = 0;
	public static double r = 5;
	public int gold = 0;
	static double sum = 0;
	Music musicObj = new Music();
	Music musicOb = new Music();
	
	public static String diff = "";
	String hm = "";
	public static String[] text= {"<HTML>You wake up in the middle of a field and you see some goblins running towards you. <BR>You prepare yourself to fight them.</HTML>", "You get ready for the next goblin", "You see a town in the distance and head towards it.", "<HTML>After talking to the townsfolk, you decide to head north to a larger city <BR>to figure out who you are and where you came from.<BR> On the way, you are attacked by three bandits.</HTML>", "You dust yourself off and stand at the ready for your other foes.", "You try to catch your breath before their leader attacks.", "<HTML>After resting for a bit, you enter the Misty Forest towards your<BR>but you feel a menacing presence behind you.</HTML>", "<HTML>Exhausted, you finally reach the halfway point on this leg<BR> of your journey. You take a well deserved break at the small village in<BR>the middle of the forest.</HTML>", "When you depart you hear rustling in the trees up ahead.", "<HTML>Before you could enter the cave that led to the next town<BR> you are blocked of by two tough looking skeletons.", "The skeleton archer finally figured out how to use its bow and prepares to attack.", "<HTML>While walking through to cave, something drops<BR> down from the ceiling and lands in front of you</HTML>", "Just before you can exit the cave, a minotaur appears, blocking your way", "Upon exiting the cave, you enter the large city right outside.", "<HTML>When you exit the shop, you see the townsfolk running<BR> around in a panic. You ask one of them what was happening and they tell you<BR>that golems are attacking the town.</HTML>", "You rnotice that the golems are quite sturdy and prepare yourself for a long fight.", "<HTML>The city's guards start to repel the rest of the golems, leaving <BR>you to take down the largest golem.</HTML>", "<HTML>Having saved the city from the golems, you ask the guards <BR>where the golems came from. They tell you that the witch in the nearby swamp is the cause.</HTML>", "You make your way to the depths of the swamp and confront the witch.", "<HTML>On the way back, you see a small frog in front of you.<BR>Something about it doesn't seem quite right.</HTML>", "<HTML>The townsfolk thank you but don't reward you in any way<BR>when you arrive there, having saved the town<BR>from both the golems and the witch.<HTML>", "<HTML>You leave the town and continue on your trek across the<BR>to find out who you are but on the path out of town, a<BR>menacing figure blocks your way.</HTML>", "<HTML>Just when you think the fight is over, Sekiro gets up<BR>with all of his injuries healed somehow.", "<HTML>You reach another small town on your journey and <BR>stop to take a break after your duel with Sekiro.</HTML>", "<HTML>You journey onwards and start the trek through the desert,<BR>wondering if you will ever get back your lost memories.</HTML>", "You rush down the other hyenas.", "You prepare to take down the leader.", "<HTML>You trudge onwards and see an oasis in the distance.<BR>Exhausted, you run towards it and take a massive sip of water,<BR> quenching your thirst. You take a well-deserved break.</HTML>", "Another monster runs at you from the other side of the oasis.", "<HTML>You leave the oasis and travel through the<BR> last stretch of desert before the next town.<BR>Suddenly, the ground starts shaking, almost like an earthquake.</HTML>", "<HTML>You reach the next town, find an <BR>inn, and immediately fall asleep.</HTML>", "<HTML>A local warrior decides to teach you a new technique.<BR>You can now combo your enemy, meaning each successful<BR>attack will do more damage. You give your thanks and head onwards.</HTML>", "<HTML>Having managed to repel the dragon, you retreat back <BR>to town to better prepare to fight such a tough monster.<HTML>", "<HTML>You head off to confront the dragon and you trek<BR>through the lava filled wasteland that it calls home.</HTML>", "You continue onwards to slay the dragon.", "<HTML>You finally reach the dragon's home and<BR>you charge forward fearlessly.</HTML>", "<HTML>Having slain the dragon, you return to the town<BR>bearing good news. The townsfolk treat you to a massive feast.", "<HTML>You decide to continue your journey,<BR>hoping that you will one day discover who you  are.</HTML>"};
	public static String[] enemies = {"A goblin approaches", "A large goblin staggers towards you.", "You enter the town and head towards the shop to stock up on supplies.", "A sickly bandit approaches.", "An angry bandit rushes at you in a mad rage.", "The bandit leader closes in to finish you off.", "The King of the Misty Forest jumps at you from the shadows.", "You stop at the local alchemist's store to buy provisions for your journey.", "A massive lizard lashes out at you!", "A relaxing skeleton taunts you to attack.", "You rush towards the skeleton.", "A humungous spider scuttles towards you.", "Calling on your last bit of strength, you challenge the minotaur.", "You head to the general store after asking around about yourself.", "You find the golems and engage the weakest looking one first.", "You charge at the next golem you see.", "You approach the hulking beast and steel yourself for the war of attrition.", "You head to the swamp but as you step foot in it, a swamp monster surfaces and attacks.", "The witch laughs at you, before flying towards you to burn you to a crisp.", "The frog hops towards you.", "You head to the local shop once again to stock up before you depart.", "The legendary swordsman, Sekiro, challenges you to a duel.", "Sekiro rushes at you for round 2.", "You stop at the village elder's house to replenish your medicinal supplies.", "You are attacked by a pack of hyenas.", "You engage the second hyena.", "The two headed hyena attacks.", "A monster jumps out at you from the water and attacks.", "You gather your bearings and prepare to obliterate the monster.", "A giant worm emerges from the sand  and pounces at you.", "The next day you make a stop at the local alchemist to buy some potions.", "<HTML>As soon as you exit town, you see a dragon gliding in<BR>the distance, towards the town. You draw its attention<BR>and try to repel the dragon.", "You head to the shop to restock.", "You are ambushed by a dragon!", "A dragon flies in front of you to block your way.", "The great dragon attacks! Prepare yourself!", "You stop at the shop before departing.", "<HTML>You beat the game! Now you can fight stronger<BR>versions of previous enemies. Pressing continue after this <BR>battle will put you in a random encounter."};
	public static String []word = {"swift", "deft", "", "staggering", "piercing", "bone-shattering", "critical", "", "weak", "lazy", "well-placed", "poisonous","vicious", "", "blunt", "bruising", "earthly", "stinging", "magic", "toxic", "", "killing", "swift", "", "beast-like", "ripping", "tearing", "monstrous", "painful", "sandy", "", "overwhelming", "", "savage", "destructive", "overwhelming", "", "thankful"};
	public static double dam[] = {0.5, 0.5, 0, 0.5, 1, 1.5, 1.5, 0, 0.5, 1, 1, 2, 1, 0, 0.5, 0.5, 0.5, 1, 2, 9999, 0, 1, 1.5, 0, 1, 1.5, 2, 0.5, 1, 1.5, 0, 1.5, 0, 1, 1.5, 2, 0, 0};
	public static ImageIcon[] u = {new ImageIcon("Images\\q.jpg"), new ImageIcon("Images\\q.jpg"), new ImageIcon("Images\\town1.jpg"), new ImageIcon("Images\\set1.jpg"), new ImageIcon("Images\\set1.jpg"), new ImageIcon("Images\\set1.jpg"), new ImageIcon("Images\\set2.jpg"), new ImageIcon("Images\\town2.jpg"), new ImageIcon("Images\\set2.jpg"), new ImageIcon("Images\\set3.jpg"), new ImageIcon("Images\\set3.jpg"), new ImageIcon("Images\\set4.jpg"), new ImageIcon("Images\\set4.jpg"), new ImageIcon("Images\\town3.jpg"), new ImageIcon("Images\\set5.jpg"), new ImageIcon("Images\\set5.jpg"), new ImageIcon("Images\\set5.jpg"), new ImageIcon("Images\\set6.jpg"), new ImageIcon("Images\\set6.jpg"), new ImageIcon("Images\\set6.jpg"), new ImageIcon("Images\\town3.jpg"), new ImageIcon("Images\\set7.jpg"), new ImageIcon("Images\\set7.jpg"), new ImageIcon("Images\\town4.jpg"), new ImageIcon("Images\\set8.jpg"), new ImageIcon("Images\\set8.jpg"), new ImageIcon("Images\\set8.jpg"), new ImageIcon("Images\\set9.jpg"), new ImageIcon("Images\\set9.jpg"), new ImageIcon("Images\\set8.jpg"), new ImageIcon("Images\\town5.jpg"), new ImageIcon("Images\\set10.jpg"), new ImageIcon("Images\\town5.jpg"), new ImageIcon("Images\\set10.jpg"), new ImageIcon("Images\\set10.jpg"), new ImageIcon("Images\\set11.jpg"), new ImageIcon("Images\\town5.jpg"), new ImageIcon("Images\\set1.jpg")};
	public static ImageIcon[] enemy = {new ImageIcon("Images\\s.png"), new ImageIcon("Images\\b.png"), new ImageIcon("Images\\en3.png"), new ImageIcon("Images\\en3.png"), new ImageIcon("Images\\en1.png"), new ImageIcon("Images\\en2.png"), new ImageIcon("Images\\en4.png"), new ImageIcon("Images\\en5.png"), new ImageIcon("Images\\en5.png"), new ImageIcon("Images\\en6.png"), new ImageIcon("Images\\en7.png"), new ImageIcon("Images\\en8.png"), new ImageIcon("Images\\en9.png"), new ImageIcon("Images\\town3.png"), new ImageIcon("Images\\en10.png"), new ImageIcon("Images\\en11.png"), new ImageIcon("Images\\en12.png"), new ImageIcon("Images\\en13.png"), new ImageIcon("Images\\en14.png"), new ImageIcon("Images\\en15.png"), new ImageIcon("Images\\town3.png"), new ImageIcon("Images\\en16.png"), new ImageIcon("Images\\en16.png"), new ImageIcon("Images\\town3.png"), new ImageIcon("Images\\en17.png"), new ImageIcon("Images\\en18.png"), new ImageIcon("Images\\en19.png"), new ImageIcon("Images\\en20.png"), new ImageIcon("Images\\en21.png"), new ImageIcon("Images\\en22.png"), new ImageIcon("Images\\town5.png"), new ImageIcon("Images\\en23.png"), new ImageIcon("Images\\town5.jpg"), new ImageIcon("Images\\en24.png"), new ImageIcon("Images\\en25.png"), new ImageIcon("Images\\en23.png"), new ImageIcon("Images\\town5.png"), new ImageIcon("Images\\enf.png")};
	public static int[] money = {2, 3, 0, 3, 3, 4, 7, 0, 5, 5, 6, 8, 10, 0, 0, 1, 2, 1, 11, 5, 0, 20, 10, 0, 4, 3, 8, 12, 8, 13, 0, 100, 0, 50, 50, 200, 0, 0};
	public static double[] HP = {2, 3, 0, 4, 4, 5, 5, 0, 6, 5, 4, 6, 7, 0, 9, 11, 15, 9, 5, 1, 0, 20, 19, 0, 9, 12, 18, 30, 22, 19, 0, 350, 0, 100, 150, 999, 0, 1};
	String music[] = {"Music\\music1.wav", "Music\\music2.wav", "Music\\store.wav", "Music\\music3.wav", "Music\\music2.wav", "Music\\music1.wav", "Music\\boss1.wav", "Music\\store.wav", "Music\\music2.wav", "Music\\music1.wav", "Music\\music3.wav", "Music\\boss1.wav", "Music\\boss2.wav", "Music\\store.wav", "Music\\boss1.wav", "Music\\boss1.wav", "Music\\boss2.wav", "Music\\boss3.wav", "Music\\boss4.wav", "Music\\music1.wav", "Music\\store.wav", "Music\\boss6.wav", "Music\\boss6.wav", "Music\\store.wav", "Music\\music3.wav", "Music\\music2.wav", "Music\\boss5.wav", "Music\\boss2.wav", "Music\\boss3.wav", "Music\\boss1.wav", "Music\\store.wav", "Music\\boss1.wav", "Music\\store.wav", "Music\\boss1.wav", "Music\\boss3.wav", "Music\\bossf.wav", "Music\\store.wav", "Music\\store.wav"};
	int potion = 0;
	static int time = 10000;
	double d = 2;
	int mp = 5;
	int cost = 5;
	double [] p = null;
	public static int xval = 0;
	public static int yval = 0;
	int w = 0;
	
	ImageIcon[] shop = {new ImageIcon("Images\\shop1.jpg"), new ImageIcon("Images\\shop2.png"), new ImageIcon("Images\\shop3.jpg"), new ImageIcon("Images\\shop3.jpg"), new ImageIcon("Images\\shop1.jpg"), new ImageIcon("Images\\shop2.png"), new ImageIcon("Images\\shop2.png")};
	private JTextField textField;
	int velx = 5, vely = 8, attack = 0, magic = 0, run = 0, combo = 0;
	boolean battle = false, mag = false, end = false;
	JLabel label = new JLabel("");
	JLabel lbl1 = new JLabel("");
	String filename = "";

	@Override
	public void actionPerformed(ActionEvent e) {
		if (attack == 3) {
			lbl1.setIcon(new ImageIcon("Images\\att1.png"));
			lbl1.setVisible(true);
			attack = 1;
		}
		else if (attack == 1) {
			attack = 0;
			if (hp <= 0) {
				label.setVisible(false);
			}
			lbl1.setVisible(false);
		}
		if (magic == 3) {
			lbl1.setBounds((int)(screenw * 0.31), (int)(screenh*0.05), 800, 600);
			lbl1.setIcon(new ImageIcon("Images\\ex1.png"));
			lbl1.setVisible(true);
			magic = 2;
		}
		else if (magic == 2) {
			lbl1.setIcon(new ImageIcon("Images\\ex2.png"));
			magic = 1;
			lbl1.setBounds((int)(screenw * 0.28), (int)(screenh*0.05), 800, 600);
		}
		else if (magic == 1) {
			magic = 0;
			if (hp <=0) {
				label.setVisible(false);
			}
			lbl1.setVisible(false);
		}
		if (run == 3) {
			lbl1.setBounds((int)(screenw * 0.38), (int)(screenh*0.05), 800, 600);
			lbl1.setIcon(new ImageIcon("Images\\run1.png"));
			lbl1.setVisible(true);
			run = 2;
		}
		else if (run == 2) {
			lbl1.setBounds((int)(screenw * 0.28), (int)(screenh*0.05), 800, 600);
			lbl1.setIcon(new ImageIcon("Images\\run2.png"));
			run = 1;
		}
		else if (run == 1) {
			run = 0;
			label.setVisible(false);
			lbl1.setVisible(false);
		}
		label.setBounds((int)(screenw * 0.25) + velx, 0 + vely, 1100, 600);
		velx = -velx;
		vely = -vely;

	}
}

//hi\\
