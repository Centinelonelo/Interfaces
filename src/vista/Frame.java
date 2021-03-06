package vista;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;



import control.Control;

public class Frame extends JFrame {	
	
	JTextPane areaTexto = new JTextPane();
	JScrollPane scroll = new JScrollPane(areaTexto);
	
	BarraMenu barraMenu = new BarraMenu();
	BarraIconos barraIconos = new BarraIconos();
	BarraInferior barraInferior = new BarraInferior();	
	PopupMenu pop = new PopupMenu();
	
	public Frame() {
	
		//Las caracteristicas de nuestro Frame
		setVisible(true);
		setSize(1000, 650);
		setTitle("Editor de texto");
		setJMenuBar(barraMenu);
		setLocationRelativeTo(null);
		areaTexto.add(pop);
		add(scroll);
		add(barraIconos, BorderLayout.NORTH);
		add(barraInferior, BorderLayout.SOUTH);
		Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/lapiz.png"));
		setIconImage(im);
		
		
		//Actionlistener
		String s;
		
		//DefaultEditorKit nos permite realizar tareas de portapapeles
		//StyledEditorKit referente al estilo
		barraIconos.getAbrirArchivo().addActionListener(new Control(s="AbrirArchivo"));
		barraIconos.getCopiar().addActionListener(new DefaultEditorKit.CopyAction());
		barraIconos.getCortar().addActionListener(new DefaultEditorKit.CutAction());
		barraIconos.getItalica().addActionListener(new StyledEditorKit.ItalicAction());
		barraIconos.getDeshacer().addActionListener(new Control(s="Deshacer", areaTexto));
		barraIconos.getGuardar().addActionListener(new Control(s="Guardar", areaTexto));
		barraIconos.getNegrita().addActionListener(new StyledEditorKit.BoldAction());
		barraIconos.getNuevo().addActionListener(new Control(s="Nuevo", areaTexto));
		barraIconos.getPegar().addActionListener(new DefaultEditorKit.PasteAction());
		barraIconos.getSubrayar().addActionListener(new StyledEditorKit.UnderlineAction());
		
		//Nos alinea la linea actual o el texto seleccionado
		barraIconos.getTextoCentrado().addActionListener(new StyledEditorKit.AlignmentAction("Centro", StyleConstants.ALIGN_CENTER));
		barraIconos.getTextoJustificado().addActionListener(new StyledEditorKit.AlignmentAction("Justificado", StyleConstants.ALIGN_JUSTIFIED));
		barraIconos.getTextoIzquierda().addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", StyleConstants.ALIGN_LEFT));
		barraIconos.getTextoDerecha().addActionListener(new StyledEditorKit.AlignmentAction("Derecha", StyleConstants.ALIGN_RIGHT));
		
		//Combobox
		barraIconos.getTamanyoFuente().addActionListener(new Control(s="Fuente", areaTexto, barraIconos.getTamanyoFuente(), barraIconos.getFuente()));
		barraIconos.getFuente().addActionListener(new Control(s="Fuente", areaTexto, barraIconos.getTamanyoFuente(), barraIconos.getFuente()));
		
		//A�adimos los atajos de teclado para copiar cortar y pegar
		barraMenu.getE3().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		barraMenu.getE4().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		barraMenu.getE5().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		
		barraMenu.getA1().addActionListener(new Control(s="Nuevo", areaTexto));
		barraMenu.getA2().addActionListener(new Control(s="AbrirArchivo"));
		barraMenu.getA3().addActionListener(new Control(s="Guardar", areaTexto));
		barraMenu.getE1().addActionListener(new Control(s="Deshacer", areaTexto));
		barraMenu.getE3().addActionListener(new DefaultEditorKit.CutAction());
		barraMenu.getE4().addActionListener(new DefaultEditorKit.CopyAction());
		barraMenu.getE5().addActionListener(new DefaultEditorKit.PasteAction());
		barraMenu.getF1().addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", StyleConstants.ALIGN_LEFT));
		barraMenu.getF2().addActionListener(new StyledEditorKit.AlignmentAction("Centro", StyleConstants.ALIGN_CENTER));
		barraMenu.getF3().addActionListener(new StyledEditorKit.AlignmentAction("Derecha", StyleConstants.ALIGN_RIGHT));
		barraMenu.getF4().addActionListener(new StyledEditorKit.AlignmentAction("Justificado", StyleConstants.ALIGN_JUSTIFIED));
		barraMenu.getF5().addActionListener(new StyledEditorKit.BoldAction());
		barraMenu.getF6().addActionListener(new StyledEditorKit.ItalicAction());
		barraMenu.getF7().addActionListener(new StyledEditorKit.UnderlineAction());
		barraMenu.getY2().addActionListener(new Control(s="Informacion"));
		barraMenu.getY3().addActionListener(new Control(s="Salir"));
		
		
		//Idioma
		barraInferior.getjIdioma().addActionListener(new Control(s="Idioma", barraInferior.getjIdioma(), barraMenu,pop));
		
		//Eventos del popupMenu
		pop.getNegrita().addActionListener(new StyledEditorKit.BoldAction());
		pop.getCursiva().addActionListener(new StyledEditorKit.ItalicAction());
		pop.getSubrayar().addActionListener(new StyledEditorKit.UnderlineAction());
		pop.getCopiar().addActionListener(new DefaultEditorKit.CopyAction());
		pop.getCortar().addActionListener(new DefaultEditorKit.CutAction());
		pop.getPegar().addActionListener(new DefaultEditorKit.PasteAction());
		
		areaTexto.getDocument().addDocumentListener(new Control(areaTexto, barraInferior.getjPalabras(),barraInferior.getjLineas()));
		
		//Listener para mostrar el popUp
		areaTexto.addMouseListener(new MouseAdapter() {
	            public void mousePressed(MouseEvent e) {
	                showPopup(e);
	            }
	            public void mouseReleased(MouseEvent e) {
	                showPopup(e);
	            }
	            private void showPopup(MouseEvent e) {
	                if (e.isPopupTrigger()) {
	                    pop.show(e.getComponent(),
	                            e.getX(), e.getY());
	                }
	            }
		});

	}
		
	
	public JTextPane getAreaTexto() {return areaTexto;}
	public void setAreaTexto(JTextPane areaTexto) {this.areaTexto = areaTexto;}
	public JScrollPane getScroll() {return scroll;}
	public void setScroll(JScrollPane scroll) {this.scroll = scroll;}
	public BarraMenu getBarraMenu() {	return barraMenu;}
	public void setBarraMenu(BarraMenu barraMenu) {this.barraMenu = barraMenu;}
	public BarraIconos getBarraIconos() {return barraIconos;}
	public void setBarraIconos(BarraIconos barraIconos) {this.barraIconos = barraIconos;}
	public BarraInferior getBarraInferior() {return barraInferior;}
	public void setBarraInferior(BarraInferior barraInferior) {this.barraInferior = barraInferior;}

}
