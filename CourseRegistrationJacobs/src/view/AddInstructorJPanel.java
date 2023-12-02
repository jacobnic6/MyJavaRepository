package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.InstructorFileHelper;
import model.Instructor;

public class AddInstructorJPanel extends JPanel {
	private JTextField txtInstructorFirstName;
	private JTextField txtInstructorLastName;
	private JTextField txtEmail;
	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnBackToMain = new JButton("Back to Main Menu");
	InstructorFileHelper fileHelper = new InstructorFileHelper();
	ArrayList<Instructor> allInstructors;

	/**
	 * Create the panel.
	 */
	public AddInstructorJPanel() {

		allInstructors = (ArrayList<Instructor>)fileHelper.readFile();

		setLayout(new BorderLayout());

		JPanel form = new JPanel();

		form.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblEnterANew = new JLabel("Enter A New Instructor");
		add(lblEnterANew, BorderLayout.NORTH);

		JLabel lblInstructorFirstName = new JLabel("First Name:");
		form.add(lblInstructorFirstName, "4, 6, right, default");

		txtInstructorFirstName = new JTextField();
		form.add(txtInstructorFirstName, "6, 6, fill, default");
		txtInstructorFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		form.add(lblLastName, "4, 8, right, default");

		txtInstructorLastName = new JTextField();
		form.add(txtInstructorLastName, "6, 8, fill, default");
		txtInstructorLastName.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		form.add(lblEmail, "4, 10, right, default");

		txtEmail = new JTextField();
		form.add(txtEmail, "6, 10, fill, default");
		txtEmail.setColumns(10);

		buttonListener bl = new buttonListener();
		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnBackToMain.addActionListener(bl);

		form.add(btnSubmit, "6, 12");
		form.add(btnClear, "6, 14");

		add(form, BorderLayout.CENTER);

		form.add(btnBackToMain, "6, 16");

	}

	class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmit) {
				Instructor instructorToAdd;
				if (txtEmail.getText().equals("")) {
					instructorToAdd = new Instructor(txtInstructorFirstName.getText(), txtInstructorLastName.getText());
				} else {
					instructorToAdd = new Instructor(txtInstructorFirstName.getText(), txtInstructorLastName.getText(),
							txtEmail.getText());
				}

				allInstructors.add(instructorToAdd);
				
				//here is where you're going to tell the fileHelper to write to the file
				//uncomment this line below for it to work
				
				fileHelper.writeFile(allInstructors);

				clearAllFields();

			} else if (e.getSource() == btnClear) {
				clearAllFields();

			} else if (e.getSource() == btnBackToMain) {

				removeAll();
				MainMenuJPanel newPanel = new MainMenuJPanel();
				add(newPanel);
				validate();
				setVisible(true);
			}

		}

		private void clearAllFields() {
			// TODO Auto-generated method stub
			txtInstructorFirstName.setText("");
			txtInstructorLastName.setText("");
			txtEmail.setText("");
		}

	}

}
