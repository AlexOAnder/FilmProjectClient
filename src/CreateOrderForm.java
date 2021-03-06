import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.CustomOrderView;
import Entities.Film;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import javax.swing.DefaultComboBoxModel;

public class CreateOrderForm {

	private JFrame frmCreateOrder;
	private final JPanel contentPanel = new JPanel();
	private JTextField tf_rentDays;
	public JComboBox<String> filmComboBox;
	public JComboBox<String> cb_PassportRegionCode;
	private JTextField tf_firstName;
	private JTextField tf_lastName;
	private JTextField tf_passportNumber;
	private JTextField tf_phoneNumber;

	/**
	 * Create the form
	 * @param window 
	 */
	public CreateOrderForm(List<Film> data, MainWindow window) {
		frmCreateOrder = new JFrame();
		frmCreateOrder.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				window.createOrderOpened = false;
			}
		});
		frmCreateOrder.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frmCreateOrder.setVisible(true);
		frmCreateOrder.setTitle("Create order");
		frmCreateOrder.setBounds(100, 100, 477, 354);
		frmCreateOrder.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmCreateOrder.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// frmCreateOrder.setModal(true);
		frmCreateOrder.setResizable(false);

		JLabel label = new JLabel("Choose the film");
		label.setBounds(43, 14, 122, 14);
		contentPanel.add(label);

		filmComboBox = new JComboBox<String>();
		filmComboBox.setBounds(175, 11, 192, 20);
		contentPanel.add(filmComboBox);

		JLabel lbl_Payment = new JLabel("0");
		lbl_Payment.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Payment.setBounds(203, 257, 192, 23);
		contentPanel.add(lbl_Payment);
		
		tf_rentDays = new JTextField();
		tf_rentDays.setColumns(20);
		tf_rentDays.setBounds(174, 208, 193, 20);
		tf_rentDays.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                // ignore all no digit
                if (!Character.isDigit(key)) 
                	e.consume();
                
            }
            public void keyReleased(KeyEvent e){
            	if (tf_rentDays.getText().length()>0)
                {
                	int i = filmComboBox.getSelectedIndex();
                	double newValue = data.get(i).getRentCost() * 
                		Integer.parseInt(tf_rentDays.getText());
                	lbl_Payment.setText(Double.toString(newValue)); 
                }
                else{
                	lbl_Payment.setText("0");
                }
            }
        });
		
		contentPanel.add(tf_rentDays);

		

		JLabel lblNewLabel = new JLabel("Rent for (days)");
		lblNewLabel.setBounds(43, 211, 96, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("To pay");
		lblNewLabel_2.setBounds(99, 264, 81, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(43, 47, 75, 14);
		contentPanel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(43, 79, 75, 14);
		contentPanel.add(lblLastName);

		JLabel lblPassportnumber = new JLabel("Passport Number");
		lblPassportnumber.setBounds(43, 114, 122, 14);
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
		tf_passportNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                // ignore all no digit
                if (!Character.isDigit(key)) 
                	e.consume();
                // only 7 chars
                if(tf_passportNumber.getText().length()>6)
                	e.consume();
            }
		});
		tf_passportNumber.setBounds(245, 111, 122, 20);
		contentPanel.add(tf_passportNumber);
		tf_passportNumber.setColumns(10);
		

		tf_phoneNumber = new JTextField();
		tf_phoneNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                // ignore all no digit
                if (!Character.isDigit(key)) 
                	e.consume();
            }
		});
		tf_phoneNumber.setBounds(175, 149, 192, 20);
		contentPanel.add(tf_phoneNumber);
		tf_phoneNumber.setColumns(10);
		
		cb_PassportRegionCode = new JComboBox<String>();
		cb_PassportRegionCode.setModel(
				new DefaultComboBoxModel<String>(new String[] 
						{"MP", "KH", "AB", "BM", "HB", "KH", "MC", "KB"}));
		cb_PassportRegionCode.setBounds(175, 111, 60, 20);
		contentPanel.add(cb_PassportRegionCode);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		frmCreateOrder.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Validate())
						{
							CreateOrder(window);
							JOptionPane.showMessageDialog(null, "Create order succeed");
							frmCreateOrder.dispose();
							window.createOrderOpened = false;
						}
					}
				 catch (RemoteException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something wrong with create order's"
							+ " method.Contact with administrator","Critical Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		frmCreateOrder.getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreateOrder.dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		// **//
		if (data.size() == 0) {
			LoadDefaultList();
		} else {
			for (Film item : data) {
				filmComboBox.addItem(item.getName());
			}
		}
	}

	private void LoadDefaultList() {
		filmComboBox.addItem("s2");
		filmComboBox.addItem("s3");
		filmComboBox.addItem("ppooll4");
		filmComboBox.addItem("papwe");
		filmComboBox.addItem("peeper");
	}

	private boolean Validate(){
		boolean isValid = true;
		
		if (filmComboBox.getSelectedIndex()<0)
			 isValid = false;
		if (tf_firstName.getText().length()<=0)
			 isValid = false;
		if (tf_lastName.getText().length()<=0)
			isValid = false;
		if (tf_passportNumber.getText().length()<=0)
			isValid = false;
		if (tf_phoneNumber.getText().length()<=0)
			isValid = false;
		try{
			int i = Integer.parseInt(tf_rentDays.getText());
			if (i<0 || i >100)
				isValid = false;
		}catch(Exception ex){
			isValid = false;
		}
		if (!isValid){
			JOptionPane.showMessageDialog(null, "Check yours fields - something wrong!","Validation Error",JOptionPane.WARNING_MESSAGE);
		}
		return isValid;
	}
	
	public void CreateOrder(MainWindow window) throws RemoteException {
		CustomOrderView vs = new CustomOrderView();
		// thats a weak point - there can be wrong filmId(if film list will be start from 1)
		vs.FilmId = filmComboBox.getSelectedIndex() + 1; 
		vs.CustomerFirstName = tf_firstName.getText();
		vs.CustomerLastName = tf_lastName.getText();
		vs.FilmName = filmComboBox.getSelectedItem().toString();
		vs.PassportNumber = cb_PassportRegionCode.getSelectedItem().toString() 
				+ tf_passportNumber.getText();
		vs.PhoneNumber = tf_phoneNumber.getText();
		vs.CustomerId = 0;
		int days = Integer.parseInt(tf_rentDays.getText());
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DATE, days);
		now = c.getTime();
		vs.RentExpires = now;
		window.ConfirmCreate(vs);
	}
	
	public void CalculateAmount()
	{
		
	}
}
