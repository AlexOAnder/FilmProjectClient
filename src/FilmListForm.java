import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTable;

import Entities.Film;

import java.awt.GridBagLayout;
import java.util.List;
import java.awt.GridBagConstraints;

public class FilmListForm {

	public JFrame frmFilmsList;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilmListForm window = new FilmListForm();
					window.frmFilmsList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public FilmListForm() {
		initialize();
	}

	public FilmListForm(List<Film> filmList){
		initialize();
	}	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFilmsList = new JFrame();
		frmFilmsList.setTitle("Films List");
		frmFilmsList.setBounds(100, 100, 503, 479);
		frmFilmsList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frmFilmsList.getContentPane().setLayout(gridBagLayout);
		//frmFilmsList.setVisible(true);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		frmFilmsList.getContentPane().add(table, gbc_table);
	}
}
