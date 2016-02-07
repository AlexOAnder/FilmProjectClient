import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;

import Entities.Film;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmFilmprojectMain;
	private JTable table;

	private IConnectService stub;
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
		
		try {
			stub = (IConnectService) Naming.lookup("ConnectService");
	        boolean response = stub.GetStatusConnect();
	        if (response)
	        	System.out.println("Connect with interface was successfull!");
	        
	        List<Film> filmList = stub.GetFilmsList();
	        if (filmList!=null)
		        for (Film film : filmList){
		        	System.out.println(film.getFilmId());
		        	System.out.println(film.getName());
		        	System.out.println(film.getRating());
		        	System.out.println(film.getRentCost());
		        	System.out.println(film.getYear());
		        }

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
		frmFilmprojectMain.setBounds(100, 100, 696, 424);
		frmFilmprojectMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFilmprojectMain.setResizable(false);
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
