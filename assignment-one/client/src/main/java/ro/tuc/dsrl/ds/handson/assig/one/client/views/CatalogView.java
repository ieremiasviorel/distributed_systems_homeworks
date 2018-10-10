package ro.tuc.dsrl.ds.handson.assig.one.client.views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ro.tuc.dsrl.ds.handson.assig.one.client.entities.Student;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description: CatalogView is a JFrame which contains the UI elements of the
 *               Client application.
 */
public class CatalogView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFirstname;
	private JTextField textLastname;
	private JTextField textMail;
	private JTextField textId;
	private JTextField textDeleteId;
	private JButton btnGet;
	private JButton btnPost;
	private JButton btnDelete;
	private JTextArea textArea;

	public CatalogView() {
		setTitle("HTTP Protocol simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 430, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInsertNewStudent = new JLabel("Insert new student");
		lblInsertNewStudent.setBounds(10, 10, 120, 20);
		contentPane.add(lblInsertNewStudent);

		JLabel lblFirstname = new JLabel("First name");
		lblFirstname.setBounds(10, 40, 60, 20);
		contentPane.add(lblFirstname);

		JLabel lblLastname = new JLabel("Last name");
		lblLastname.setBounds(10, 70, 60, 20);
		contentPane.add(lblLastname);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 100, 60, 20);
		contentPane.add(lblMail);

		textFirstname = new JTextField();
		textFirstname.setBounds(80, 40, 90, 20);
		contentPane.add(textFirstname);
		textFirstname.setColumns(10);

		textLastname = new JTextField();
		textLastname.setBounds(80, 70, 90, 20);
		contentPane.add(textLastname);
		textLastname.setColumns(10);

		textMail = new JTextField();
		textMail.setBounds(80, 100, 90, 20);
		contentPane.add(textMail);
		textMail.setColumns(10);

		btnPost = new JButton("POST");
		btnPost.setBounds(10, 130, 90, 20);
		contentPane.add(btnPost);

		JLabel lblDeleteStudentBy = new JLabel("Delete student by id");
		lblDeleteStudentBy.setBounds(10, 170, 120, 20);
		contentPane.add(lblDeleteStudentBy);
		
		JLabel lblDeleteId = new JLabel("Id");
		lblDeleteId.setBounds(10, 200, 60, 20);
		contentPane.add(lblDeleteId);
		
		textDeleteId = new JTextField();
		textDeleteId.setBounds(80, 200, 90, 20);
		contentPane.add(textDeleteId);
		textDeleteId.setColumns(10);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(10, 230, 90, 20);
		contentPane.add(btnDelete);
		
		JLabel lblFindStudentBy = new JLabel("Find student by id");
		lblFindStudentBy.setBounds(230, 10, 120, 20);
		contentPane.add(lblFindStudentBy);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(230, 40, 60, 20);
		contentPane.add(lblId);

		textId = new JTextField();
		textId.setBounds(300, 40, 90, 20);
		contentPane.add(textId);
		textId.setColumns(10);

		btnGet = new JButton("GET");
		btnGet.setBounds(230, 70, 90, 20);
		contentPane.add(btnGet);

		textArea = new JTextArea();
		textArea.setBounds(230, 130, 160, 120);
		contentPane.add(textArea);
	}

	public void addBtnGetActionListener(ActionListener e) {
		btnGet.addActionListener(e);
	}

	public void addBtnPostActionListener(ActionListener e) {
		btnPost.addActionListener(e);
	}
	
	public void addBtnDeleteActionListener(ActionListener e) {
		btnDelete.addActionListener(e);
	}

	public String getStudentId() {
		return textId.getText();
	}

	public String getFirstname() {
		return textFirstname.getText();
	}

	public String getLastname() {
		return textLastname.getText();
	}

	public String getMail() {
		return textMail.getText();
	}
	
	public String getStudentToDeleteId() {
		return textDeleteId.getText();
	}

	public void printStudent(Student student) {
		textArea.setText(student.toString());
	}

	public void clear() {
		textId.setText("");
		textFirstname.setText("");
		textLastname.setText("");
		textMail.setText("");
		textArea.setText("");
		textDeleteId.setText("");
	}
}
