package views;
/*Gustavo Pietro de Assis Silva 2ds,o projeto esta imcompleto, fiz os arquivos e o banco de dados, mas no final
o projeto acabou não compilando. Video do codigo, do visual da janelinha e banco de dados na outra pasta.
 */
import models.Musicss;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* radio = cor
comboBox = modelo
cehck box = Placa nova e velha*/

/*
nome = text field **
idade = text field **
nacionalidade = combo **
musicas do cantor = text field **
ainda existe = radio **
genero = checks **
grammys = text field **

 */

public class Music extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel labelNome, labelIdade, labelNacional, labelMusics, labelVivo,labelGrammys;
    private JTextField tFNome, tfIdade, tfMusics, tfGrammys;
    private JButton btAdicionar, btCancel;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, JPanelCampos;
    private boolean isEditMode;
   /*  private JLabel labelGenero; */

    
    private JCheckBox JCheckBox1, JCheckBox2;
    private JPanel  JCheckPanel, JFieldPanel;

    private JComboBox Nacio;
   /*  private JPanel JPanelNacio; */

    private JRadioButton radio1,radio2;
    private ButtonGroup radio;
    private JPanel JPanelRadios;

    private Musicss musicss;

    public Music(MusicssTableView tableView, String string, Musicss music) {
        super("Cadastro Cantor e músicas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

             //check box = genero  Masculino ou Feminino
        JCheckBox1 = new JCheckBox("Masculino");
        JCheckBox2 = new JCheckBox("Feminino");
        JCheckPanel = new JPanel ();
        JCheckPanel.setLayout ( new GridLayout (2,1));
        JCheckPanel.add (JCheckBox1);
        JCheckPanel.add (JCheckBox2);

             //construindo layout para por o check box
             JFieldPanel = new JPanel();
             JFieldPanel.setLayout (new BorderLayout());


             //Construindo o layout para por o combo box
             Nacio = new JComboBox();
             Nacio.addItem ("USA");
             Nacio.addItem ("Inglaterra");
             Nacio.addItem ("Brasil");
             Nacio.addItem ("França");
             Nacio.addItem ("Espanha");
             Nacio.addItem ("México");
             Nacio.addItem ("Portugal");
             Nacio.addItem ("China");
             Nacio.addItem ("Russia");
             Nacio.addItem ("Colombia");
             Nacio.addItem ("Canadá");
             Nacio.addItem ("África do Sul");
             Nacio.addItem ("Jamaica");
             Nacio.addItem ("Argentina");
             Nacio.addItem ("Outro");


        
             JPanelRadios = new JPanel();

             JPanelRadios.add (radio1 =  new JRadioButton("Sim"),false);
             JPanelRadios.add (radio2 =  new JRadioButton("Não"),false);
            /*  JPanelRadios.add (radio3 =  new JRadioButton("cinza"),true); */

        labelNome = new JLabel("cantor(a)/banda:");
        tFNome = new JTextField(15);
        labelIdade = new JLabel("Idade:");
        tfIdade = new JTextField(20);
        labelMusics = new JLabel("Músicas:");
        tfMusics = new JTextField(20);
        labelGrammys = new JLabel("N° grammys:");
        tfGrammys = new JTextField(20);

        labelNacional = new JLabel("Nacionalidade:");
        labelVivo = new JLabel("Ainda Existe:");
    
        btAdicionar = new JButton("Adicionar");
        btCancel = new JButton("Cancelar");

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        JPanelCampos = new JPanel();

        Container janela;
        janela = getContentPane();
        janela.setLayout(new BorderLayout());

        jPanel1.setLayout(new GridLayout(4, 1));
        jPanel2.setLayout(new GridLayout(4, 1));
        jPanel3.setLayout(new FlowLayout());
        jPanel4.setLayout(new GridLayout(2, 3));
    

        jPanel1.add(labelNome);
        jPanel1.add(labelIdade);
        jPanel1.add(labelMusics);
        jPanel1.add(labelGrammys);
    
        jPanel2.add(tFNome);
        jPanel2.add(tfIdade);
        jPanel2.add(tfMusics);
        jPanel2.add(tfGrammys);


        jPanel3.add(btAdicionar);
        jPanel3.add(btCancel);

        jPanel4.add(labelVivo);
        jPanel4.add(radio1);
        jPanel4.add(radio2);
        jPanel4.add(labelNacional);
        jPanel4.add(Nacio);

        JPanelCampos.add (jPanel1);
        JPanelCampos.add (jPanel2);
        JPanelCampos.add (jPanel3);
    

        janela.add(JPanelCampos, BorderLayout.WEST);
        janela.add(JCheckPanel, BorderLayout.SOUTH);
        janela.add(jPanel4,BorderLayout.EAST);
        janela.add(JPanelRadios, BorderLayout.CENTER);

        //setSize(500, 500);
        pack();

        btAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarCampos()) {
					if (isEditMode) {
						atualizarmusicss();
					} else {
						adicionarmusicss();
					}
					dispose();
				}
			}
		});

		btCancel.addActionListener(e -> dispose());

		this.add(jPanel3);
		this.pack();
		this.setLocationRelativeTo(getParent());
	}

private void preencherCampos() {
		if (musicss !=null) {
			tFNome.setText(musicss.getNome());
			tfIdade.setText(String.valueOf(musicss.getidade()));
			tfMusics.setText(musicss.getMusicas());
            tfGrammys.setText(String.valueOf(musicss.getGrammys()));
             radio1.setEnabled(false);
            radio2.setEnabled(false);
		}
	}

	private boolean validarCampos() {
		if (tFNome.getText().trim().isEmpty() ||
				tfMusics.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(
				this,
				"Nome e Musicas são obrigadores.",
				"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
        return true;
	}

	private void adicionarmusicss() {
        String vivo;
        if(radio1.isSelected())
        vivo="Sim";
        else{
            vivo = "não";
        }

      
        String Genero;
        if(JCheckBox1.isSelected())
        Genero="Masculino";
        else{
            Genero = "Feminino";
        }

          String Nacio;

		musicss = new Musicss(
			tFNome.getText(),
		Integer.parseInt(tfIdade.getText()),
            tfMusics.getText().trim(),
			Integer.parseInt(tfGrammys.getText().trim()),
            vivo,
            Genero,
            Nacio.getSelectedItem().toString()
		);
	}

	private void atualizarmusicss() {
		if (musicss != null) {
			musicss.setNome(tFNome.getText().trim());
			musicss.setidade(Integer.parseInt(tfIdade.getText().trim()));
			musicss.setMusicas(tfMusics.getText().trim());
            musicss.setGrammys(Integer.parseInt(tfGrammys.getText().trim()));
		}
	}
	public Musicss getmusicss() {
		return musicss;
	}
    
	
    public static void main(String[] args) {
     Music exBorderLayout = new Music();
        exBorderLayout.setVisible(true);
    }
}