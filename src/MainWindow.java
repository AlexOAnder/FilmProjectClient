import java.awt.EventQueue;
import java.awt.JobAttributes.DialogType;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Entities.CustomOrderView;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MainWindow {

	public boolean createOrderOpened = false;
	public int SelectedOrder = 0; // need for the 'returned' button
	private static MainWindow window;
	private JFrame frmFilmprojectMain;
	private JTable table;
	private FilmListForm filmListForm = new FilmListForm(); // static form - add
															// data when it will
															// needed
	private List<Film> filmList = new ArrayList<Film>();
	private List<CustomOrderView> tableDataList = new ArrayList<CustomOrderView>();

	private IConnectService stub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					window = new MainWindow();
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
		GetRmiConnect();
		initialize();

	}

	public void LoadData() throws RemoteException {
		// load main customOrderView for main frame
		List<CustomOrderView> mainList = stub.GetCustomOrderViewList();
		if (mainList == null) {
			JOptionPane.showMessageDialog(null, "RMI предал нас! Нет данных для главной формы");
			frmFilmprojectMain.dispose();
		}
		tableDataList = new ArrayList<CustomOrderView>(mainList);

		// load film's list for the create order and assortiment
		List<Film> filmListTmp = stub.GetFilmsList();
		if (filmListTmp == null) {
			JOptionPane.showMessageDialog(null, "RMI предал нас! Фильмы не прогрузились");
			frmFilmprojectMain.dispose();
		} else {
			filmList = new ArrayList<Film>(filmListTmp);
		}
	}

	public void GetRmiConnect() {
		try {
			stub = (IConnectService) Naming.lookup("ConnectService");
			boolean response = stub.GetStatusConnect();
			if (response)
				System.out.println("Connect with interface was successfull!");
			LoadData();

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, "Все плохо!RMI отказался дружить с нами");
			e.printStackTrace();
			frmFilmprojectMain.dispose();
			System.exit(0);
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFilmprojectMain = new JFrame();
		frmFilmprojectMain.setTitle("FilmProject - Main Form");
		frmFilmprojectMain.setBounds(100, 100, 927, 389);
		frmFilmprojectMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFilmprojectMain.setResizable(false);
		frmFilmprojectMain.getContentPane().setLayout(null);

		JButton btnAssortment = new JButton("Assortment");
		btnAssortment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!filmListForm.frmFilmsList.isShowing())
					filmListForm.frmFilmsList.setVisible(true);
			}
		});
		btnAssortment.setBounds(10, 299, 140, 39);
		frmFilmprojectMain.getContentPane().add(btnAssortment);

		JButton btnNewOrder = new JButton("Add new order");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!createOrderOpened) {
					CreateOrderForm form = new CreateOrderForm(filmList, window); // that
																					// not
																					// right,
																					// but
																					// i
																					// think
																					// it
																					// ok
					createOrderOpened = true;
				}
			}
		});
		btnNewOrder.setBounds(753, 299, 158, 39);
		frmFilmprojectMain.getContentPane().add(btnNewOrder);

		TableModel model = new MyTableModel(tableDataList);

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		ListSelectionModel selModel = table.getSelectionModel();

		selModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String result = "";
				int[] selectedRows = table.getSelectedRows();
				for (int i = 0; i < selectedRows.length; i++) {
					int selIndex = selectedRows[i];
					TableModel model = table.getModel();
					Object value = model.getValueAt(selIndex, 0); // we are search orderId
					SelectedOrder = (int)value;
					System.out.println(SelectedOrder);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 901, 247);
		frmFilmprojectMain.getContentPane().add(scrollPane);

		JButton btnReturned = new JButton("Returned");
		btnReturned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetReturnedStatus();
			}
		});
		btnReturned.setBounds(357, 299, 140, 39);
		frmFilmprojectMain.getContentPane().add(btnReturned);
	}

	public class MyTableModel extends AbstractTableModel {

		private List<CustomOrderView> rows;

		@Override
		public int getRowCount() {
			return rows.size();
		}

		@Override
		public int getColumnCount() {
			return 9;
		}

		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int colIndex) {
			CustomOrderView row = rows.get(rowIndex);
			switch (colIndex) {
			case 0:
				return row.OrderId;
			case 1:
				return row.CustomerFirstName;
			case 2:
				return row.CustomerLastName;
			case 3:
				return row.PassportNumber;
			case 4:
				return row.PhoneNumber;
			case 5:
				return row.Created;
			case 6:
				return row.RentExpires;
			case 7:
				return row.Returned;
			case 8: {
				DecimalFormat myFormatter = new DecimalFormat("###,###.###");
				return myFormatter.format(row.TotalAmount);
			}

			}
			return "";
		}

		public MyTableModel(List<CustomOrderView> data) {
			this.rows = data;
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0:
				return "Id";
			case 1:
				return "FirstName";
			case 2:
				return "LastName";
			case 3:
				return "PassportNumber";
			case 4:
				return "PhoneNumber";
			case 5:
				return "Created";
			case 6:
				return "RentExpires";
			case 7:
				return "Returned";
			case 8:
				return "TotalAmount";
			}
			return "";
		}
	}

	// method for the adding new Order
	public void ConfirmCreate(CustomOrderView model) throws RemoteException {
		if (stub.GetStatusConnect()) {
			stub.AddNewCustomOrderView(model);
		}
		UpdateData();
	}

	public void UpdateData() throws RemoteException
	{
		LoadData();
		// update table
		TableModel tmp = new MyTableModel(tableDataList);
		table.setModel(tmp);
	}
	
	public void SetReturnedStatus() {
		try {
			if (SelectedOrder == 0)
				return;
			else
			{
				int response = JOptionPane.showConfirmDialog(null,
						"Are you sure? That operation cannot be canceled!",
					    "Warning",JOptionPane.YES_NO_OPTION,
					    JOptionPane.WARNING_MESSAGE);
			    if (response == JOptionPane.YES_OPTION) {
			    	stub.UpdateOrderStatus(SelectedOrder);
					UpdateData();
			    }
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "RMI предал нас! Статус не обновлен");
		}

	}
}
