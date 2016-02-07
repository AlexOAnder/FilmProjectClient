import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;

import Entities.Order;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmFilmprojectMain;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmFilmprojectMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		GetRmiConnect();
	}

	
	public void GetRmiConnect()	{
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("127.0.0.1");
			IConnectService stub = (IConnectService) Naming.lookup("ConnectService");
	        String[] response = stub.GetFilmsList();
	        System.out.println("response:");
	        for (String item :response){
	        	System.out.println(item);
	        }
	        
	        List<Order> o = stub.GetOrders();
	        
	        System.out.println(o.get(0).getFilmId());
	        
		} catch (RemoteException | NotBoundException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFilmprojectMain = new JFrame();
		frmFilmprojectMain.setTitle("FilmProject - Main Form");
		frmFilmprojectMain.setBounds(100, 100, 708, 424);
		frmFilmprojectMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmFilmprojectMain.getContentPane().setLayout(null);
		
		JButton btnAssortment = new JButton("Assortment");
		btnAssortment.setBounds(10, 336, 140, 39);
		frmFilmprojectMain.getContentPane().add(btnAssortment);
		
		JButton btnNewOrder = new JButton("Add new order");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateOrderDialog dialog = new CreateOrderDialog();
				dialog.setVisible(true);
			}
		});
		btnNewOrder.setBounds(524, 336, 158, 39);
		frmFilmprojectMain.getContentPane().add(btnNewOrder);
		
		table = new JTable();
		table.setBounds(10, 11, 672, 247);
		frmFilmprojectMain.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setBounds(229, 348, 46, 14);
		frmFilmprojectMain.getContentPane().add(lblNewLabel);
	}
}
