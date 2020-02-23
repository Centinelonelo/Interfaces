package vista;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class BarraInferior extends JToolBar{

	public BarraInferior(){
		add(Palabras);
		add(jPalabras);
		jPalabras.setEditable(false);
		add(new Separator());
		add(new Separator());
		add(new Separator());
		add(Estilo);
		add(jLineas);
		jLineas.setEditable(false);
		add(new Separator());
		add(new Separator());
		add(new Separator());
		add(Idioma);
		add(jIdioma);
		jIdioma.addItem("Español");
		jIdioma.addItem("English");
		
	}
	
	JLabel Palabras = new JLabel("Nº palabras: ");
	JTextField jPalabras = new JTextField();
	JLabel Estilo = new JLabel("Nº lineas: ");
	JTextField jLineas = new JTextField();
	JLabel Idioma = new JLabel("Idioma: ");
	JComboBox jIdioma = new JComboBox();
	
	public JLabel getPalabras() {
		return Palabras;
	}
	public void setPalabras(JLabel palabras) {
		Palabras = palabras;
	}
	public JTextField getjPalabras() {
		return jPalabras;
	}
	public void setjPalabras(JTextField jPalabras) {
		this.jPalabras = jPalabras;
	}
	public JLabel getEstilo() {
		return Estilo;
	}
	public void setEstilo(JLabel estilo) {
		Estilo = estilo;
	}
	public JTextField getjLineas() {
		return jLineas;
	}
	public void setjLineas(JTextField jLineas) {
		this.jLineas = jLineas;
	}
	public JLabel getIdioma() {
		return Idioma;
	}
	public void setIdioma(JLabel idioma) {
		Idioma = idioma;
	}
	public JComboBox getjIdioma() {
		return jIdioma;
	}
	public void setjIdioma(JComboBox jIdioma) {
		this.jIdioma = jIdioma;
	}

	
	
}


