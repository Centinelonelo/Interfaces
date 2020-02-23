package control;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import vista.BarraMenu;
import vista.PopupMenu;


public class Control implements ActionListener, DocumentListener, MouseListener{
	
	
	private JTextPane texto;
	private String nombre, ruta;
	private JComboBox cbT, cbF;
	private JTextField jf1, jf2;
	private BarraMenu menu;
	private PopupMenu pop;
	private DocumentEvent de;
	
	//Manager para deshacer
	UndoManager manager = new UndoManager();
	
	
	
	//Constructores
	public Control(String nombre) {
		this.nombre = nombre;
	}
	
	public Control( JTextPane texto, JTextField jf1, JTextField jf2) {
		this.texto = texto;
		this.jf1 = jf1;
		this.jf2 = jf2;
	}
	
	public Control(String nombre, JTextPane texto) {
		this.nombre = nombre;
		this.texto=texto;
		manager = new UndoManager();
		
		texto.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });
	}
	
	public Control(String nombre, JComboBox cbT, BarraMenu menu, PopupMenu pop) {
		this.nombre = nombre;
		this.cbT = cbT;
		this.menu = menu;
		this.pop = pop;
	}
	
	public Control(String nombre, JTextPane texto, JComboBox cbT, JComboBox cbF) {
		this.nombre = nombre;
		this.texto=texto;
		this.cbT = cbT;
		this.cbF = cbF;
		
	}	

	
	//Aqui recogemos el evento de click y ejecutamos nuestros metodos
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(nombre) {
		case "AbrirArchivo":
			try {
				Desktop.getDesktop().open(new File("C:\\"));
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}break;	
		case "Nuevo":
				nuevo();
			break;
		case "Salir":
			System.exit(0);
			break;
		case "Deshacer":
			try {
				manager.undo();
			} catch (Exception ex) {}
			break;
		case "Rehacer":
			try {
				manager.redo();
			} catch (Exception ex) {}
			break;
		case "Guardar":
			guardarArchivo();
			
			break;
		case "Fuente":
			texto.setFont(new Font((String)cbF.getSelectedItem(),texto.getFont().getStyle(), Integer.parseInt(cbT.getSelectedItem().toString())));
			break;
		case "NLineas":
			changedUpdate(de);
			break;
		case "Informacion":
			JOptionPane.showMessageDialog(null, "Mi Editor personalizado","Información",1);
			break;
		case "NPalabras":
			changedUpdate(de);
			break;
		case "Idioma":
			cambiarIdioma();
			
		}

	}
	
	//Acción abrir nuevo, si tenemos algo nos pregunta para guardar con un JOptionPane
	public void nuevo() {
		if (!texto.getText().equals("")) {

            String cosas[] = {"Guardar", "No guardar","Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "¿Desea guardar los cambios?", "Editor de Texto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cosas, cosas[0]);

            if (eleccion == 0) {guardarArchivo();texto.setText("");ruta="";}
            if (eleccion == 1) {texto.setText("");ruta="";}
        }
        else texto.setText("");
	}
	
	//Este metodo accede a nuestros archivos de recursos para cambiar el idioma de nuestra app
	public void cambiarIdioma() {
		if(cbT.getSelectedItem().toString().equals("Español")) {
			menu.getM1().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("menu_Archivo"));
			menu.getM2().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("menu_Editar"));
			menu.getM3().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("menu_Formato"));
			menu.getM4().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("menu_Ayuda"));	
			menu.getA1().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Nuevo"));
			menu.getA2().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Abrir"));
			menu.getA3().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Guardar"));
			menu.getE1().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Deshacer"));
			menu.getE3().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Cortar"));
			menu.getE4().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Copiar"));
			menu.getE5().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Pegar"));
			menu.getF1().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_AlinearIzquierda"));
			menu.getF2().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_AlinearCentro"));
			menu.getF3().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_AlinearDerecha"));
			menu.getF4().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Justificar"));
			menu.getF5().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Negrita"));
			menu.getF6().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Italica"));
			menu.getF7().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Subrayado"));
			menu.getY2().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Informacion"));
			menu.getY3().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Salir"));
			
			pop.getCopiar().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Copiar"));
			pop.getCortar().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Cortar"));
			pop.getPegar().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Pegar"));
			pop.getNegrita().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Negrita"));
			pop.getCursiva().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Italica"));
			pop.getSubrayar().setText(ResourceBundle.getBundle("Recursos.Etiquetas").getString("item_Subrayado"));
			
			
		}else if(cbT.getSelectedItem().toString().equals("English")) {
			menu.getM1().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("menu_Archivo"));
			menu.getM2().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("menu_Editar"));
			menu.getM3().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("menu_Formato"));
			menu.getM4().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("menu_Ayuda"));	
			menu.getA1().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Nuevo"));
			menu.getA2().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Abrir"));
			menu.getA3().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Guardar"));
			menu.getE1().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Deshacer"));
			menu.getE3().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Cortar"));
			menu.getE4().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Copiar"));
			menu.getE5().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Pegar"));
			menu.getF1().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_AlinearIzquierda"));
			menu.getF2().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_AlinearCentro"));
			menu.getF3().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_AlinearDerecha"));
			menu.getF4().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Justificar"));
			menu.getF5().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Negrita"));
			menu.getF6().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Italica"));
			menu.getF7().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Subrayado"));
			menu.getY2().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Informacion"));
			menu.getY3().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Salir"));
			
			pop.getCopiar().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Copiar"));
			pop.getCortar().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Cortar"));
			pop.getPegar().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Pegar"));
			pop.getNegrita().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Negrita"));
			pop.getCursiva().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Italica"));
			pop.getSubrayar().setText(ResourceBundle.getBundle("Recursos.Etiquetas", Locale.US).getString("item_Subrayado"));
		}
	}
	
	public void guardarArchivo() {
		
		    String sb = texto.getText().toString();
		    JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new File("/home/me/Documents"));
		    int retrival = chooser.showSaveDialog(null);
		    if (retrival == JFileChooser.APPROVE_OPTION) {
		    	try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) {
		    	    fw.write(sb.toString());
		    	} catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		
	}
	
	//Contar lineas
	private static int countLines(JTextPane texto) {
		int nlineas= 1;
		int lineasTotales = texto.getText().toString().length();
		for(int i =0;i<lineasTotales; i++) {
			char letter = texto.getText().charAt(i);
			if(letter == '\n') nlineas++;
		}
			return nlineas;
	}
	

	//Al actualizar el documento realizamos el metodo para contar lineas y contar palabras gracias a StringTokenizer
	@Override
	public void insertUpdate(DocumentEvent e) {	
		StringTokenizer st = new StringTokenizer(texto.getText());
        jf1.setText(String.valueOf(st.countTokens()));
		
		jf2.setText(""+countLines(texto));
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		StringTokenizer st = new StringTokenizer(texto.getText());
        jf1.setText(String.valueOf(st.countTokens()));
		
		jf2.setText(""+countLines(texto));
	
	}

	@Override
	public void changedUpdate(DocumentEvent de) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

