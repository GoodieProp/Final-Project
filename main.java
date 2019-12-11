import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
/**
 * This class represents the main class and how the program functions
 * @author Xavier Gonzalez
 *
 */
public class main extends JFrame {
	
	private String textToShow;
	private JTextArea txaWords;
	ArrayList<Scores> score = new ArrayList<Scores>();
	
	
	public void setupUI() {
		
		setTitle("Web Scaper");
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel panNorth = new JPanel();
		JPanel panSouth = new JPanel();
		
		panNorth.setLayout(new FlowLayout());
		JLabel label = new JLabel("Enter URL: ");
		JTextField txtURL = new JTextField(30);
		JButton btnAddText = new JButton("Fetch");
		
		panSouth.setLayout(new FlowLayout());
		JButton btnSaveToText = new JButton("Save to Text");
		JButton btnSaveToJSON = new JButton("Save to JSON");
		
		btnAddText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url = txtURL.getText();
				
				score = WebScraper.screenScaper(url);
				
				//txaWords.setText(WebScraper.screenScaper(url));
				/*String text = txtTextToAdd.getText();
				textToShow = textToShow + "\n" + text;
				txaWords.setText(textToShow);*/
			}
		});
		
		btnSaveToText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser(new File("c:\\temp\\"));
					if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						if (SaveTo.writeToText(jfc.getSelectedFile(), score)) {
							JOptionPane.showMessageDialog(null, "Scores saved");
						} else {
							JOptionPane.showMessageDialog(null, "Scores not saved.");
						}
					}
				} catch (Exception ex) {
					
				}
			}
		});
		
		btnSaveToJSON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser(new File("c:\\temp\\"));
					if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						if (SaveTo.writeToJSON(jfc.getSelectedFile(), score)) {
							JOptionPane.showMessageDialog(null, "Scores saved");
						} else {
							JOptionPane.showMessageDialog(null, "Scores not saved.");
						}
					}
				} catch (Exception ex) {
					
				}
			}
		});
		
		panNorth.add(label);
		panNorth.add(txtURL);
		panNorth.add(btnAddText);
		
		panSouth.add(btnSaveToText);
		panSouth.add(btnSaveToJSON);
		
		c.add(panNorth,BorderLayout.NORTH);
		c.add(panSouth,BorderLayout.SOUTH);
		txaWords = new JTextArea();
		txaWords.setEditable(false);
		c.add(txaWords,BorderLayout.CENTER);
	}
	
	public void setupMenu() {
		
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenu mnuHelp = new JMenu("Help");
		
		JMenuItem miOpenFile = new JMenuItem("Open");
		miOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser();
					if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						System.out.println(jfc.getSelectedFile().getPath());
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "fuck..");
				}
			}
		});
		mnuFile.add(miOpenFile);
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "It's a me, Xavier!");
			}
		});
		mnuHelp.add(miAbout);
		
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
		
		
		
	}
	
	public main() {
		setupUI();
		setupMenu();
	}
	
	/**
	 * Main class is used to form the entirety of the program
	 * @param args
	 */
	public static void main(String[] args) {
		main ui = new main();
		ui.setVisible(true);
	}

}
