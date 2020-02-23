package vista;


import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenu extends JPopupMenu{
    
    private JMenuItem Copiar = new JMenuItem("Copiar");
    private JMenuItem Cortar = new JMenuItem("Cortar");
    private JMenuItem Pegar = new JMenuItem("Pegar");
    private JMenuItem Negrita = new JMenuItem("Negrita");
    private JMenuItem Subrayar = new JMenuItem("Subrayar");
    private JMenuItem Cursiva = new JMenuItem("Cursiva");
    
	public PopupMenu() {
		add(Copiar);
		add(Cortar);
		add(Pegar);
		add(new Separator());
		add(Negrita);
		add(Subrayar);
		add(Cursiva);
	}

	public JMenuItem getCopiar() {
		return Copiar;
	}

	public void setCopiar(JMenuItem copiar) {
		Copiar = copiar;
	}

	public JMenuItem getCortar() {
		return Cortar;
	}

	public void setCortar(JMenuItem cortar) {
		Cortar = cortar;
	}

	public JMenuItem getPegar() {
		return Pegar;
	}

	public void setPegar(JMenuItem pegar) {
		Pegar = pegar;
	}

	public JMenuItem getNegrita() {
		return Negrita;
	}

	public void setNegrita(JMenuItem negrita) {
		Negrita = negrita;
	}

	public JMenuItem getSubrayar() {
		return Subrayar;
	}

	public void setSubrayar(JMenuItem subrayar) {
		Subrayar = subrayar;
	}

	public JMenuItem getCursiva() {
		return Cursiva;
	}

	public void setCursiva(JMenuItem cursiva) {
		Cursiva = cursiva;
	}


	
	
	
}
