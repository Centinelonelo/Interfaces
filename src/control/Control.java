package control;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.function.BiConsumer;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public class Control implements ActionListener, DocumentListener, MouseListener{
	
	
	private JTextPane texto;
	private String nombre, ruta;
	private JComboBox cbT, cbF;
	private JTextField jf;
	
	private DocumentEvent de;
	
	//Manager para deshacer
	UndoManager manager = new UndoManager();
	
	
	
	//Constructores
	public Control(String nombre) {
		this.nombre = nombre;
	}
	
	public Control(String nombre, JTextPane texto, JTextField field) {
		this.nombre = nombre;
		this.texto = texto;
		this.jf = field;
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
	
	public Control(String nombre, JTextPane texto, JComboBox comboBoxT, JComboBox comboBoxF) {
		this.nombre = nombre;
		this.texto=texto;
		this.cbT = comboBoxT;
		this.cbF = comboBoxF;
		
	}	

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
			if (!texto.getText().equals("")) {

                String cosas[] = {"Guardar", "No guardar","Cancelar"};
                int eleccion = JOptionPane.showOptionDialog(null, "¿Desea guardar los cambios?", "Editor de Texto",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cosas, cosas[0]);

                if (eleccion == 0) {guardarArchivo();texto.setText("");ruta="";}
                if (eleccion == 1) {texto.setText("");ruta="";}
            }
            else texto.setText("");
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
		
			texto.setFont(new Font((String)cbF.getSelectedItem(),Font.PLAIN, Integer.parseInt(cbT.getSelectedItem().toString())));
			break;
		case "TamanyoFuente":
			texto.setFont(new Font((String)cbF.getSelectedItem(), Font.PLAIN, Integer.parseInt(cbT.getSelectedItem().toString())));
			
			break;
		case "NLineas":
			changedUpdate(de);
			break;
		case "Informacion":
			JOptionPane.showMessageDialog(null, "Mi Editor personalizado","Información",1);
			break;
		case "NPalabras":
			changedUpdate(de);
		}		
		


	}
	
	public void guardarArchivo() {
		
			JFileChooser filecho = new JFileChooser();
			filecho.setDialogTitle("Especifica un archivo para guardarlo");
			int seleccionUsuario = filecho.showSaveDialog(texto);
			if(seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File archivoAGuardar = filecho.getSelectedFile();
			
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
	
	private static String countWords(JTextPane texto) {
		String miVariable = String.valueOf(texto.getText().length());
        return miVariable;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		jf.setText(""+countLines(texto));
		//jf.setText(countWords(texto));
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		jf.setText(""+countLines(texto));
		//jf.setText(countWords(texto));
	}

	@Override
	public void changedUpdate(DocumentEvent de) {
		// TODO Auto-generated method stub
		
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

