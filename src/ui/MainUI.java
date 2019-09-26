package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.ScrollPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class MainUI extends JFrame {

	protected JPanel contentPane;
	protected JLabel lblStatusdisplay;
	protected JMenuBar menuBar;
	protected JMenu mnCommands;
	protected JMenuItem mntmManage;
	protected JScrollPane scrollPane;
	protected JPanel panel;

	public MainUI() {
		setResizable(false);
		setTitle("Arduino racesim server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCommands = new JMenu("Commands");
		menuBar.add(mnCommands);
		
		mntmManage = new JMenuItem("Manage");
		mnCommands.add(mntmManage);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblStatus = new JLabel("Status:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 0;
		contentPane.add(lblStatus, gbc_lblStatus);
		
		lblStatusdisplay = new JLabel("");
		GridBagConstraints gbc_lblStatusdisplay = new GridBagConstraints();
		gbc_lblStatusdisplay.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatusdisplay.gridx = 1;
		gbc_lblStatusdisplay.gridy = 0;
		contentPane.add(lblStatusdisplay, gbc_lblStatusdisplay);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}

}
