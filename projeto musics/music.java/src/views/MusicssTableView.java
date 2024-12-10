
package views;

import models.Musicss;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MusicssTableView extends JFrame {
	private JTable table;
	private DefaultTableModel tableModel;

	public MusicssTableView() {
		super ("Gerenciamento de musicss");
		initializeComponents();
	}

private void initializeComponents() {
		String[] columnNames = {"ID", "Nome", "Email", "Telefone"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBorder(
			BorderFactory.createEmptyBorder(10, 10, 10, 10));

		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);

		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

public void atualizarTabela(List<Musicss> musicss) {
		tableModel.setRowCount(0); //limpa a tabela
		for (Musicss musicss1: musicss) {
			Object[] row = {
				musicss1.getId(),
				musicss1.getNome(),
				musicss1.getidade(),
				musicss1.getMusicas(),
				musicss1.getGrammys(),
				musicss1.getVivo(),
				musicss1.getGenero(),
				musicss1.getNacionalidade()
			};
			tableModel.addRow(row);
		}
	}

public int getSelectedmusicssId() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			return (int) tableModel.getValueAt(selectedRow, 0);
		}
        return -1;
	}
}