package MenuItemDisplay;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataModel.Grade_Ratio;
import Query.Grade_RatioQueries;

public class Set_Grade_Ratio extends JFrame {

	private Grade_Ratio currentEntry; 
	private Grade_RatioQueries grade_ratioQueries;
	private List<Grade_Ratio> results;
	private int numberOfEntries = 0;
	private int currentEntryIndex;

	private JButton browseButton; 
	
	private JTextField a_plusTextField;
	private JTextField a_zeroTextField;
	private JTextField b_plusTextField;
	private JTextField b_zeroTextField;
	private JTextField c_plusTextField;
	private JTextField c_zeroTextField;
	private JTextField fTextField;
	
	private JButton update_allButton; 
	
	public Set_Grade_Ratio() {
		super("학점 등급 비율 설정");

		grade_ratioQueries = new Grade_RatioQueries();

		JPanel displayPanel = new JPanel();

		a_plusTextField = new JTextField(10);
		a_zeroTextField= new JTextField(10);
		b_plusTextField = new JTextField(10);
		b_zeroTextField = new JTextField(10);
		c_plusTextField = new JTextField(10);
		c_zeroTextField = new JTextField(10);
		fTextField = new JTextField(10);
		
		browseButton = new JButton("학점 등급 비율 조회");
		update_allButton = new JButton("모든 점수 등록");

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setSize(300, 300); 
		this.setResizable(false); 
		                                                    
		displayPanel.setLayout(new GridLayout(7, 2, 4, 4));
		
		displayPanel.add(new JLabel("A+:"));
		displayPanel.add(a_plusTextField);

		displayPanel.add(new JLabel("A0:"));
		displayPanel.add(a_zeroTextField);

		displayPanel.add(new JLabel("B+:"));
		displayPanel.add(b_plusTextField);
		
		displayPanel.add(new JLabel("B0:"));
		displayPanel.add(b_zeroTextField);
		
		displayPanel.add(new JLabel("C+:"));
		displayPanel.add(c_plusTextField);
		
		displayPanel.add(new JLabel("C0:"));
		displayPanel.add(c_zeroTextField);
		
		displayPanel.add(new JLabel("F:"));
		displayPanel.add(fTextField);
		
		this.add(displayPanel);
		
		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				browseButtonActionPerformed(evt);
			}

		});

		this.add(browseButton);
		
		update_allButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				update_allButtonActonPerformed(evt);
			}

		});

		this.add(update_allButton);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent evt) {
				grade_ratioQueries.close();
				//System.exit(0);
			}
		});

		this.setVisible(true);
	}


	private void browseButtonActionPerformed(ActionEvent evt) {
		try {
			results = grade_ratioQueries.getAllGrade_Ratio();
			numberOfEntries = results.size();

			if(numberOfEntries != 0) {
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);

				a_plusTextField.setText(String.valueOf(currentEntry.getA_plus()));
				a_zeroTextField.setText(String.valueOf(currentEntry.getA_zero()));
				b_plusTextField.setText(String.valueOf(currentEntry.getB_plus()));
				b_zeroTextField.setText(String.valueOf(currentEntry.getB_zero()));
				c_plusTextField.setText(String.valueOf(currentEntry.getC_plus()));
				c_zeroTextField.setText(String.valueOf(currentEntry.getC_zero()));
				fTextField.setText(String.valueOf(currentEntry.getF()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void update_allButtonActonPerformed(ActionEvent evt) {
		int[] result = new int[7];
		int total_ratio = 0;
		
		for(int i=0; i<7; i++) {
			if(i == 0) {
				result[i] = grade_ratioQueries.UpdateA_plus(Integer.parseInt(a_plusTextField.getText()));
				total_ratio += Integer.parseInt(a_plusTextField.getText());
			}
		
			else if(i == 1) {
				result[i] = grade_ratioQueries.UpdateA_zero(Integer.parseInt(a_zeroTextField.getText()));
				total_ratio += Integer.parseInt(a_zeroTextField.getText());
			}
				
			else if(i == 2) {
				result[i] = grade_ratioQueries.UpdateB_plus(Integer.parseInt(b_plusTextField.getText()));
				total_ratio += Integer.parseInt(b_plusTextField.getText());
			}
				
			else if(i == 3) {
				result[i] = grade_ratioQueries.UpdateB_zero(Integer.parseInt(b_zeroTextField.getText()));
				total_ratio += Integer.parseInt(b_zeroTextField.getText());
			}
				
			else if(i == 4) {
				result[i] = grade_ratioQueries.UpdateC_plus(Integer.parseInt(c_plusTextField.getText()));
				total_ratio += Integer.parseInt(c_plusTextField.getText());
			}
				
			else if(i == 5) {
				result[i] = grade_ratioQueries.UpdateC_zero(Integer.parseInt(c_zeroTextField.getText()));
				total_ratio += Integer.parseInt(c_zeroTextField.getText());
			}
				
			else if(i == 6) {
				result[i] = grade_ratioQueries.UpdateF(Integer.parseInt(fTextField.getText()));
				total_ratio += Integer.parseInt(fTextField.getText());
			}
		}
		
		if(Integer.parseInt(a_plusTextField.getText()) >= 0 && Integer.parseInt(a_zeroTextField.getText()) >= 0 && 
				Integer.parseInt(b_plusTextField.getText()) >= 0 && Integer.parseInt(b_zeroTextField.getText()) >= 0 
				&& Integer.parseInt(c_plusTextField.getText()) >= 0 && Integer.parseInt(c_zeroTextField.getText()) >= 0
				&& Integer.parseInt(fTextField.getText()) >= 0) {
			if(result[0] == 1 && result[1] == 1 && result[2] == 1 && result[3] == 1 && result[4] == 1 && result[5] == 1 && result[6] == 1) {
				JOptionPane.showMessageDialog(this, "학점 등급 비율이 등록되었습니다!", "학점 등급 비율 등록", JOptionPane.PLAIN_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "학점 등급 비율이 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(this, "학점 등급 비율이 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		
		browseButtonActionPerformed(evt);
	}
}
