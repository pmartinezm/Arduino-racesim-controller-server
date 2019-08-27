package ui.panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.dao.CommandDAO;
import model.Command;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JList;

public class ManageCommandsPanel extends JPanel {
	protected JTextField txtName;
	protected JTextField txtKeys;
	protected JButton btnRemove;
	protected JButton btnAdd;
	protected JSeparator separator;
	protected JList<Command> list;
	protected JButton btnClearShortcut;
	
	public ManageCommandsPanel() {
		setPreferredSize(new Dimension(500, 350));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 2;
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);
		
		JLabel lblKeys = new JLabel("Keys");
		GridBagConstraints gbc_lblKeys = new GridBagConstraints();
		gbc_lblKeys.anchor = GridBagConstraints.WEST;
		gbc_lblKeys.insets = new Insets(0, 0, 5, 5);
		gbc_lblKeys.gridx = 2;
		gbc_lblKeys.gridy = 0;
		add(lblKeys, gbc_lblKeys);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.gridwidth = 2;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 0;
		gbc_txtName.gridy = 1;
		add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		txtKeys = new JTextField();
		txtKeys.setEditable(false);
		GridBagConstraints gbc_txtKeys = new GridBagConstraints();
		gbc_txtKeys.gridwidth = 2;
		gbc_txtKeys.insets = new Insets(0, 0, 5, 5);
		gbc_txtKeys.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKeys.gridx = 2;
		gbc_txtKeys.gridy = 1;
		add(txtKeys, gbc_txtKeys);
		txtKeys.setColumns(10);
		
		btnClearShortcut = new JButton("Clear");
		GridBagConstraints gbc_btnClearShortcut = new GridBagConstraints();
		gbc_btnClearShortcut.fill = GridBagConstraints.BOTH;
		gbc_btnClearShortcut.insets = new Insets(0, 0, 5, 5);
		gbc_btnClearShortcut.gridx = 4;
		gbc_btnClearShortcut.gridy = 1;
		add(btnClearShortcut, gbc_btnClearShortcut);
		
		btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 5;
		gbc_btnAdd.gridy = 1;
		add(btnAdd, gbc_btnAdd);
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 6;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		add(separator, gbc_separator);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.BOTH;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemove.gridx = 5;
		gbc_btnRemove.gridy = 3;
		add(btnRemove, gbc_btnRemove);
	}
}
