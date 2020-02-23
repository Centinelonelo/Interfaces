package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JComboBox;

import control.Control;

public class BarraIconos extends JToolBar{
	
	public BarraIconos() {
		//Añadimos a los botones su correspondiente imagen
		AbrirArchivo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/abrir_archivo.png")));
		Copiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/copiar.png")));
		Cortar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/cortar.png")));
		Italica.setIcon(new ImageIcon(getClass().getResource("/Imagenes/italica.png")));
		Deshacer.setIcon(new ImageIcon(getClass().getResource("/Imagenes/deshacer.png")));
		Guardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/guardar.png")));
		Negrita.setIcon(new ImageIcon(getClass().getResource("/Imagenes/negrita.png")));
		Nuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/nuevo.png")));
		Pegar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/pegar.png")));
		Subrayar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/subrayar.png")));
		TextoCentrado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/texto_centrado.png")));
		TextoJustificado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/texto_alineado.png")));
		TextoIzquierda.setIcon(new ImageIcon(getClass().getResource("/Imagenes/texto_centrado_izquierda.png")));
		TextoDerecha.setIcon(new ImageIcon(getClass().getResource("/Imagenes/texto_centrado_derecha.png")));
		
		
		//Le damos un tamaño maximo a los combobox
		Fuente.setMaximumSize(d);
		tamanyoFuente.setMaximumSize(d=new Dimension(50,27));
		
		//Añadimos los combobox
		add(Fuente);
		Fuente.addItem("Serif");
		Fuente.addItem("Courier");
		Fuente.addItem("Calibri");
		Fuente.addItem("Dialog");
		
		add(tamanyoFuente);
		for(int i = 8;i<44;i=i+2) {
			String s = i+"";
			tamanyoFuente.addItem(s);
		}
		add(new Separator());
		//Añanimos al menu los botones
		add(Nuevo);
		add(AbrirArchivo);
		add(Guardar);
		add(Deshacer);
		//Separador para comodidad visual
		add(new Separator());
		add(Cortar);
		add(Copiar);
		add(Pegar);
		add(Subrayar);
		add(Negrita);
		add(Italica);
		add(new Separator());
		add(TextoCentrado);
		add(TextoIzquierda);
		add(TextoDerecha);
		add(TextoJustificado);
		
		
	}
	
	
	//Creamos los botones 
	JButton AbrirArchivo = new JButton();
	JButton Copiar = new JButton();
	JButton Cortar = new JButton();
	JButton Italica = new JButton();
	JButton Deshacer = new JButton();
	JButton Guardar = new JButton();
	JButton Negrita = new JButton();
	JButton Nuevo = new JButton();
	JButton Pegar = new JButton();
	JButton Subrayar = new JButton();
	JButton TextoCentrado = new JButton();
	JButton TextoJustificado = new JButton();
	JButton TextoIzquierda = new JButton();
	JButton TextoDerecha = new JButton();
	
	//Combobox para la fuente y su tamaño
	JComboBox Fuente = new JComboBox();
	Dimension d = new Dimension(200,27);	
	JComboBox tamanyoFuente = new JComboBox();
	
	
	
	public JButton getAbrirArchivo() {
		return AbrirArchivo;
	}
	public void setAbrirArchivo(JButton abrirArchivo) {
		AbrirArchivo = abrirArchivo;
	}
	public JButton getCopiar() {
		return Copiar;
	}
	public void setCopiar(JButton copiar) {
		Copiar = copiar;
	}
	public JButton getCortar() {
		return Cortar;
	}
	public void setCortar(JButton cortar) {
		Cortar = cortar;
	}
	public JButton getItalica() {
		return Italica;
	}
	public void setItalica(JButton italica) {
		Italica = italica;
	}
	public JButton getDeshacer() {
		return Deshacer;
	}
	public void setDeshacer(JButton deshacer) {
		Deshacer = deshacer;
	}
	public JButton getGuardar() {
		return Guardar;
	}
	public void setGuardar(JButton guardar) {
		Guardar = guardar;
	}
	public JButton getNegrita() {
		return Negrita;
	}
	public void setNegrita(JButton negrita) {
		Negrita = negrita;
	}
	public JButton getNuevo() {
		return Nuevo;
	}
	public void setNuevo(JButton nuevo) {
		Nuevo = nuevo;
	}
	public JButton getPegar() {
		return Pegar;
	}
	public void setPegar(JButton pegar) {
		Pegar = pegar;
	}
	public JButton getSubrayar() {
		return Subrayar;
	}
	public void setSubrayar(JButton subrayar) {
		Subrayar = subrayar;
	}
	public JButton getTextoCentrado() {
		return TextoCentrado;
	}
	public void setTextoCentrado(JButton textoCentrado) {
		TextoCentrado = textoCentrado;
	}
	public JButton getTextoJustificado() {
		return TextoJustificado;
	}
	public void setTextoJustificado(JButton textoJustificado) {
		TextoJustificado = textoJustificado;
	}
	public JButton getTextoIzquierda() {
		return TextoIzquierda;
	}
	public void setTextoIzquierda(JButton textoIzquierda) {
		TextoIzquierda = textoIzquierda;
	}
	public JButton getTextoDerecha() {
		return TextoDerecha;
	}
	public void setTextoDerecha(JButton textoDerecha) {
		TextoDerecha = textoDerecha;
	}
	public JComboBox getFuente() {
		return Fuente;
	}
	public void setFuente(JComboBox fuente) {
		Fuente = fuente;
	}
	public JComboBox getTamanyoFuente() {
		return tamanyoFuente;
	}
	public void setTamanyoFuente(JComboBox tamanyoFuente) {
		this.tamanyoFuente = tamanyoFuente;
	}
	
	
	
	
}
