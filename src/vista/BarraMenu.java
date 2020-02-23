package vista;

import javax.swing.*;

public class BarraMenu extends JMenuBar{
	
	public BarraMenu() {
		//Añadimos los items a sus respectivos menús
		add(m1);
		add(m2);
		add(m3);
		add(m4);
		
		m1.add(a1);
		m1.add(a2);
		m1.add(a3);
		
		m2.add(e1);
		m2.add(e3);
		m2.add(e4);
		m2.add(e5);
		
		m3.add(f1);
		m3.add(f2);
		m3.add(f3);
		m3.add(f4);
		m3.addSeparator();
		m3.add(f5);
		m3.add(f6);
		m3.add(f6);
		m3.add(f7);
		

		m4.add(y2);
		m4.add(y3);
		
		//setVisible(true);

	}
	
	
	//Creamos los menús
	JMenu m1 = new JMenu("Archivo");
	JMenu m2 = new JMenu("Editar");
	JMenu m3 = new JMenu("Formato");
	JMenu m4 = new JMenu("Ayuda");
	
	
	//Creamos los item que añadiremos a los menús, dependiendo de en el que vayan así son nombrados
	JMenuItem a1 = new JMenuItem("Nuevo");
	JMenuItem a2 = new JMenuItem("Abrir");
	JMenuItem a3 = new JMenuItem("Guardar");
	
	JMenuItem e1 = new JMenuItem("Deshacer");
	JMenuItem e3 = new JMenuItem("Cortar");
	JMenuItem e4 = new JMenuItem("Copiar");
	JMenuItem e5 = new JMenuItem("Pegar");
	
	JMenuItem f1 = new JMenuItem("Alinear izquierda");
	JMenuItem f2 = new JMenuItem("Alinear centro");
	JMenuItem f3 = new JMenuItem("Alinear derecha");
	JMenuItem f4 = new JMenuItem("Justificar");
	JMenuItem f5 = new JMenuItem("Negrita");
	JMenuItem f6 = new JMenuItem("Itálica");
	JMenuItem f7 = new JMenuItem("Subrayado");
	

	JMenuItem y2 = new JMenuItem("Informacion");
	JMenuItem y3 = new JMenuItem("Salir");
	
	
	public JMenuItem getA1() {
		return a1;
	}
	public void setA1(JMenuItem a1) {
		this.a1 = a1;
	}
	public JMenuItem getA2() {
		return a2;
	}
	public void setA2(JMenuItem a2) {
		this.a2 = a2;
	}
	public JMenuItem getA3() {
		return a3;
	}
	public void setA3(JMenuItem a3) {
		this.a3 = a3;
	}

	public JMenuItem getE1() {
		return e1;
	}
	public void setE1(JMenuItem e1) {
		this.e1 = e1;
	}

	public JMenuItem getE3() {
		return e3;
	}
	public void setE3(JMenuItem e3) {
		this.e3 = e3;
	}
	public JMenuItem getE4() {
		return e4;
	}
	public void setE4(JMenuItem e4) {
		this.e4 = e4;
	}
	public JMenuItem getE5() {
		return e5;
	}
	public void setE5(JMenuItem e5) {
		this.e5 = e5;
	}
	public JMenuItem getF1() {
		return f1;
	}
	public void setF1(JMenuItem f1) {
		this.f1 = f1;
	}
	public JMenuItem getF2() {
		return f2;
	}
	public void setF2(JMenuItem f2) {
		this.f2 = f2;
	}
	public JMenuItem getF3() {
		return f3;
	}
	public void setF3(JMenuItem f3) {
		this.f3 = f3;
	}
	public JMenuItem getF4() {
		return f4;
	}
	public void setF4(JMenuItem f4) {
		this.f4 = f4;
	}
	public JMenuItem getF5() {
		return f5;
	}
	public void setF5(JMenuItem f5) {
		this.f5 = f5;
	}
	public JMenuItem getF6() {
		return f6;
	}
	public void setF6(JMenuItem f6) {
		this.f6 = f6;
	}
	public JMenuItem getF7() {
		return f7;
	}
	public void setF7(JMenuItem f7) {
		this.f7 = f7;
	}
	public JMenuItem getY2() {
		return y2;
	}
	public void setY2(JMenuItem y2) {
		this.y2 = y2;
	}
	public JMenuItem getY3() {
		return y3;
	}
	public void setY3(JMenuItem y3) {
		this.y3 = y3;
	}
	public JMenu getM1() {
		return m1;
	}
	public void setM1(JMenu m1) {
		this.m1 = m1;
	}
	public JMenu getM2() {
		return m2;
	}
	public void setM2(JMenu m2) {
		this.m2 = m2;
	}
	public JMenu getM3() {
		return m3;
	}
	public void setM3(JMenu m3) {
		this.m3 = m3;
	}
	public JMenu getM4() {
		return m4;
	}
	public void setM4(JMenu m4) {
		this.m4 = m4;
	}
}
