import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;

public class CreateOrderDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tb_RentDays;
	private JComboBox<String> filmComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateOrderDialog dialog = new CreateOrderDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateOrderDialog() {
		setTitle("Create order");
		setBounds(100, 100, 413, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setModal(true);
		setResizable(false);
		
		JLabel label = new JLabel("Choose the film");
		label.setBounds(43, 14, 122, 14);
		contentPanel.add(label);

		filmComboBox = new JComboBox<String>();
		filmComboBox.setBounds(175, 11, 192, 20);
		contentPanel.add(filmComboBox);

		tb_RentDays = new JTextField();
		tb_RentDays.setColumns(20);
		tb_RentDays.setBounds(175, 51, 193, 20);
		contentPanel.add(tb_RentDays);

		JLabel lbl_ExpiresData = new JLabel("ExpiresData");
		lbl_ExpiresData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_ExpiresData.setBounds(175, 94, 96, 14);
		contentPanel.add(lbl_ExpiresData);

		JLabel lbl_Payment = new JLabel("payment");
		lbl_Payment.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Payment.setBounds(175, 129, 89, 23);
		contentPanel.add(lbl_Payment);
		
		JLabel lblNewLabel = new JLabel("Rent for (days)");
		lblNewLabel.setBounds(43, 54, 96, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expires at");
		lblNewLabel_1.setBounds(43, 96, 96, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To pay");
		lblNewLabel_2.setBounds(43, 136, 96, 14);
		contentPanel.add(lblNewLabel_2);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		//**//
		LoadList();
	}

	private void LoadList() {
		filmComboBox.addItem("s1");
		filmComboBox.addItem("s2");
		filmComboBox.addItem("s3");
		filmComboBox.addItem("s4");
	}

}
