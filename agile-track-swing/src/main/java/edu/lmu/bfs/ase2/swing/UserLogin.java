package edu.lmu.bfs.ase2.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.lmu.bfs.ase2.model.Project;

class Login extends JFrame implements ActionListener {
	JButton submit;
	JPanel panel;
	JLabel label1, label2;
	final JTextField text1, text2;

	Login() {
		label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
		text2 = new JPasswordField(15);
		// this.setLayout(new BorderLayout());

		submit = new JButton("SUBMIT");

		panel = new JPanel(new GridLayout(3, 1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(submit);
		add(panel, BorderLayout.CENTER);
		submit.addActionListener(this);
		setTitle("Login Form");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String value1 = text1.getText();
		String value2 = text2.getText();
		if (value1.equals("test") && value2.equals("test")) {
			BacklogList page = new BacklogList(new Project());
			page.setVisible(true);
			JLabel label = new JLabel("Welcome:" + value1);
			page.getContentPane().add(label);
		} else {
			System.out.println("entered a valid username and password");
			JOptionPane.showMessageDialog(this, "Incorrect login or password",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

class UserLogin {
	public static void main(String arg[]) {
		try {
			Login frame = new Login();
			frame.setSize(300, 100);
			frame.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}