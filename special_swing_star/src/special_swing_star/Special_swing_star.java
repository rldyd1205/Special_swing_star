package special_swing_star;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Special_swing_star extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField 					textField;
	private JTextArea 					textArea;
	private JComboBox<String> 			comboBox;
	private JButton 					btnSend, btnClear;
	private GridBagLayout 				gridBagLayout;
	private GridBagConstraints		    gbc_textArea, gbc_comboBox, gbc_textField, gbc_btnSend, gbc_btnClear;
	private String[] 					strArr;
	private JScrollPane 				jsp;

	public Special_swing_star() {
		super("별의 별 찍기");

		this.init();
		this.setLayout();
		this.addListener();
		this.showFrame();
	}

	private void init() {
		this.gridBagLayout 							= new GridBagLayout();
		this.gridBagLayout.columnWidths 			= new int[] { 0, 0, 0, 0, 0, 0, 0 };
		this.gridBagLayout.rowHeights 				= new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.gridBagLayout.columnWeights 			= new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.gridBagLayout.rowWeights 				= new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
																	 0.0, 0.0, 0.0, Double.MIN_VALUE };

		this.textArea 								= new JTextArea();
		this.jsp 									= new JScrollPane(this.textArea);
		this.gbc_textArea 							= new GridBagConstraints();
		this.gbc_textArea.gridheight 				= 15;
		this.gbc_textArea.gridwidth 				= 6;
		this.gbc_textArea.insets 					= new Insets(0, 0, 5, 5);
		this.gbc_textArea.fill 						= GridBagConstraints.BOTH;
		this.gbc_textArea.gridx 					= 0;
		this.gbc_textArea.gridy 					= 0;

		this.strArr 								= new String[] { "선택", "직각삼각형", "역직각삼각형", "피라미드", "다이아몬드", "모래시계" };
		this.comboBox 								= new JComboBox<String>(this.strArr);
		this.gbc_comboBox 							= new GridBagConstraints();
		this.gbc_comboBox.gridwidth 				= 2;
		this.gbc_comboBox.insets 					= new Insets(0, 0, 0, 5);
		this.gbc_comboBox.fill 						= GridBagConstraints.HORIZONTAL;
		this.gbc_comboBox.gridx 					= 0;
		this.gbc_comboBox.gridy 					= 15;

		this.textField 								= new JTextField();
		this.gbc_textField 							= new GridBagConstraints();
		this.gbc_textField.gridwidth 				= 2;
		this.gbc_textField.insets 					= new Insets(0, 0, 0, 5);
		this.gbc_textField.fill 					= GridBagConstraints.HORIZONTAL;
		this.gbc_textField.gridx 					= 2;
		this.gbc_textField.gridy 					= 15;

		this.btnSend 								= new JButton("전송");
		this.gbc_btnSend 							= new GridBagConstraints();
		this.gbc_btnSend.insets 					= new Insets(0, 0, 0, 5);
		this.gbc_btnSend.gridx 						= 4;
		this.gbc_btnSend.gridy 						= 15;

		this.btnClear 								= new JButton("삭제");
		this.gbc_btnClear 							= new GridBagConstraints();
		this.gbc_btnClear.gridx 					= 5;
		this.gbc_btnClear.gridy 					= 15;
	}

	private void setLayout() {
		this.setLayout(gridBagLayout);
		this.textField.setColumns(10);
		this.textArea.setEditable(false);

		this.add(jsp, gbc_textArea);
		this.add(comboBox, gbc_comboBox);
		this.add(textField, gbc_textField);
		this.add(btnSend, gbc_btnSend);
		this.add(btnClear, gbc_btnClear);

	}
	
	// 콤보박스로 별찍기 모형을 선택하고 텍스트 필드에 정수입력해서 별모형 작성
	private void addListener() {
		this.textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columns();
			}
		});
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columns();
			}
			
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
	}
	
	
	public void columns() {
		int num = Integer.parseInt(textField.getText());
		if (comboBox.getSelectedIndex() == 1) {
			for (int i = 1; i <= num; i++) {
				for (int j = 1; j <= i; j++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
		} else if (comboBox.getSelectedIndex() == 2) {
			for (int i = num; i >= 1; i--) {
				for (int j = 1; j <= i; j++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
		} else if (comboBox.getSelectedIndex() == 3) {
			for (int i = 1; i <= num; i++) {
				for (int j = 1; j <= num-i; j++) {
					textArea.append(" ");
				}
				for (int k = 1; k <= i*2-1; k++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
		} else if (comboBox.getSelectedIndex() == 4) {
			for (int i = 1; i <= num; i++) {
				for (int j = 1; j <= num-i; j++) {
					textArea.append(" ");
				}
				for (int k = 1; k <= i*2-1; k++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
			for (int i = num-1; i >= 1; i--) {
				for (int j = 1; j <= num-i; j++) {
					textArea.append(" ");
				}
				for (int k = 1; k <= i*2-1; k++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
		} else if (comboBox.getSelectedIndex() == 5) {
			for (int i = num; i >= 1; i--) {
				for (int j = 1; j <= num-i; j++) {
					textArea.append(" ");
				}
				for (int k = 1; k <= i*2-1; k++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
			for (int i = 2; i <= num; i++) {
				for (int j = 1; j <= num-i; j++) {
					textArea.append(" ");
				}
				for (int k = 1; k <= i*2-1; k++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
		}
		textField.setText("");
	}
	
	private void showFrame() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Special_swing_star();
	}
}
