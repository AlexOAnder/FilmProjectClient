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
	private JTextField tf_firstName;
	private JTextField tf_lastName;
	private JTextField tf_passportNumber;
	private JTextField tf_phoneNumber;

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
		setBounds(100, 100, 477, 388);
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
		tb_RentDays.setBounds(174, 208, 193, 20);
		contentPanel.add(tb_RentDays);

		JLabel lbl_ExpiresData = new JLabel("ExpiresData");
		lbl_ExpiresData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_ExpiresData.setBounds(326, 277, 96, 14);
		contentPanel.add(lbl_ExpiresData);

		JLabel lbl_Payment = new JLabel("payment");
		lbl_Payment.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Payment.setBounds(138, 272, 89, 23);
		contentPanel.add(lbl_Payment);
		
		JLabel lblNewLabel = new JLabel("Rent for (days)");
		lblNewLabel.setBounds(43, 211, 96, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expires at");
		lblNewLabel_1.setBounds(237, 279, 96, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To pay");
		lblNewLabel_2.setBounds(47, 279, 81, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(43, 47, 75, 14);
		contentPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(43, 79, 75, 14);
		contentPanel.add(lblLastName);
		
		JLabel lblPassportnumber = new JLabel("PassportNumber");
		lblPassportnumber.setBounds(43, 114, 96, 14);
		contentPanel.add(lblPassportnumber);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(43, 152, 75, 14);
		contentPanel.add(lblPhone);
		
		tf_firstName = new JTextField();
		tf_firstName.setBounds(175, 44, 192, 20);
		contentPanel.add(tf_firstName);
		tf_firstName.setColumns(10);
		
		tf_lastName = new JTextField();
		tf_lastName.setBounds(175, 76, 192, 20);
		contentPanel.add(tf_lastName);
		tf_lastName.setColumns(10);
		
		tf_passportNumber = new JTextField();
		tf_passportNumber.setBounds(175, 111, 115, 20);
		contentPanel.add(tf_passportNumber);
		tf_passportNumber.setColumns(10);
		
		tf_phoneNumber = new JTextField();
		tf_phoneNumber.setBounds(175, 149, 86, 20);
		contentPanel.add(tf_phoneNumber);
		tf_phoneNumber.setColumns(10);

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
