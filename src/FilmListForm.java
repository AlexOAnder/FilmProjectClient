import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import Entities.Film;

import java.awt.GridBagLayout;
import java.util.List;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

public class FilmListForm {

	public JFrame frmFilmsList;
	private List<Film> filmList =null;
	private JTable table;

	/**
	 * Create the application.
	 */
	public FilmListForm(List<Film> list){
		filmList = list;
		initialize();
	}	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFilmsList = new JFrame();
		frmFilmsList.setTitle("Films List");
		frmFilmsList.setBounds(100, 100, 503, 479);
		frmFilmsList.setResizable(false);
		frmFilmsList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frmFilmsList.setVisible(true);
		
		
		frmFilmsList.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 467, 419);
		frmFilmsList.getContentPane().add(scrollPane);
		
		TableModel model = new MyFilmTableModel(filmList);
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
	}
	
	public class MyFilmTableModel extends AbstractTableModel {

		private List<Film> rows;

		@Override
		public int getRowCount() {
			return rows.size();
		}

		@Override
		public int getColumnCount() {
			return 7;
		}

		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int colIndex) {
			Film row = rows.get(rowIndex);
			switch (colIndex) {
			case 0:
				return row.getFilmId();
			case 1:
				return row.getName();
			case 2:
				return row.getYear();
			case 3:
				return row.getType();
			case 4:
				return row.getRating();
			case 5:
				return row.getAvailableCount();
			case 6:
				return row.getRentCost();
			}
			return "";
		}

		public MyFilmTableModel(List<Film> data) {
			this.rows = data;
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0:
				return "Id";
			case 1:
				return "Name";
			case 2:
				return "Year";
			case 3:
				return "Genre";
			case 4:
				return "Rating";
			case 5:
				return "AvailableCount";
			case 6:
				return "RentCost";
			}
			return "";
		}
	}
}
