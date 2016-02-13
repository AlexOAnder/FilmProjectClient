import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Entities.Film;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.nio.channels.ShutdownChannelGroupException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class MainWindow {

	private JFrame frmFilmprojectMain;
	private JTable table;
	FilmListForm filmList = new FilmListForm();
	
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
		//GetRmiConnect();
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
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Все плохо!RMI отказался дружить с нами");
			e.printStackTrace();
			System.exit(0);
			//frmFilmprojectMain = null;
			
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFilmprojectMain = new JFrame();
		frmFilmprojectMain.setTitle("FilmProject - Main Form");
		frmFilmprojectMain.setBounds(100, 100, 696, 389);
		frmFilmprojectMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFilmprojectMain.setResizable(false);
		frmFilmprojectMain.getContentPane().setLayout(null);
		
		JButton btnAssortment = new JButton("Assortment");
		btnAssortment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!filmList.frmFilmsList.isShowing())
					filmList.frmFilmsList.setVisible(true);
			}
		});
		btnAssortment.setBounds(10, 299, 140, 39);
		frmFilmprojectMain.getContentPane().add(btnAssortment);
		
		JButton btnNewOrder = new JButton("Add new order");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateOrderDialog dialog = new CreateOrderDialog();
				dialog.setVisible(true);
			}
		});
		btnNewOrder.setBounds(524, 299, 158, 39);
		frmFilmprojectMain.getContentPane().add(btnNewOrder);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(10, 11, 672, 247);
		frmFilmprojectMain.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setBounds(222, 311, 46, 14);
		frmFilmprojectMain.getContentPane().add(lblNewLabel);
	}
}
