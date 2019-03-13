import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI {

	private static final Dimension SIZE = new Dimension(450, 450);
	private JFrame myFrame;

	/**
	 * Is the main constructor for the GUI.
	 */
	public GUI() {

		myFrame = new JFrame("Converter Program");
		
	}

	/**
	 * Starts the GUI.
	 */
	public void start() {
		makePanel();
		myFrame.setPreferredSize(SIZE);


		myFrame.pack();
		myFrame.setMinimumSize(myFrame.getSize());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}

	/**
	 * Makes the panel.
	 */
	private void makePanel() {
		JPanel main = new JPanel(new GridLayout(4, 1));
		JPanel top = new JPanel(new FlowLayout());
		JPanel mid = new JPanel(new FlowLayout());
		JPanel bot = new JPanel(new FlowLayout());
		
		JTextField startUnit = new JTextField(5);
		JTextField endUnit = new JTextField(5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("meters");
		comboBox.addItem("feet");
		
		JButton convertBtn = new JButton("Convert");
		convertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				comboBox.getSelectedItem();
				endUnit.setText( new Converter(Double.parseDouble(startUnit.getText()), 
						(String)comboBox.getSelectedItem()).getResult());
			}

		});
		
		
		top.add(startUnit);
		top.add(endUnit);
		
		mid.add(comboBox);
		
		bot.add(convertBtn);
		
		main.add(new JPanel());
		main.add(top);
		main.add(mid);
		main.add(bot);
		
		myFrame.add(main);
		
	}

	/**
	 * Sets the look and feel.
	 */

	private static void setLookAndFeel() {
		try {

			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

		} catch (final UnsupportedLookAndFeelException e) {
			System.out.println("UnsupportedLookAndFeelException");
		} catch (final ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (final InstantiationException e) {
			System.out.println("InstantiationException");
		} catch (final IllegalAccessException e) {
			System.out.println("IllegalAccessException");
		}
	}

	/**
	 * The main method.
	 * 
	 * @param theArgs
	 *            is the command line arguments.
	 */
	public static void main(final String... theArgs) {
		setLookAndFeel();
		new GUI().start();
	}

}
