package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class MainMenuJPanel extends JPanel {

	JButton btnAddNewInstructor = new JButton("Add New Instructor");
	JButton btnAddNewClassroom = new JButton("Add New Classroom");
	JButton btnAddNewCourse = new JButton("Add New Course");
	private final JButton btnViewAllCourses = new JButton("View All Courses");

	/**
	 * Create the panel.
	 */
	public MainMenuJPanel() {
		
		JLabel instructions = new JLabel(" SELECT AN OPTION TO CONTINUE ");
		
		ButtonListener bl = new ButtonListener();
		btnAddNewCourse.addActionListener(bl);
		btnAddNewClassroom.addActionListener(bl);
		btnAddNewInstructor.addActionListener(bl);
		btnViewAllCourses.addActionListener(bl);
		
		JPanel buttons = new JPanel();
		setLayout(new BorderLayout());
		add(instructions, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(btnAddNewInstructor);
		buttons.add(btnAddNewClassroom);
		buttons.add(btnAddNewCourse);
		buttons.add(btnViewAllCourses);
		
		add(buttons, BorderLayout.CENTER);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();
			if (e.getSource() == btnAddNewInstructor) {
				newPanel = new AddInstructorJPanel();
			} else if (e.getSource() == btnAddNewClassroom) {
				newPanel = new AddClassroomJPanel();
			} else if (e.getSource() == btnAddNewCourse) {
				newPanel = new AddCourseJPanel();
			} else if (e.getSource() == btnViewAllCourses) {
				newPanel = new ViewAllCoursesJPanel();
			
			}
			
			sendToNewPanel(newPanel);

		}

		private void sendToNewPanel(JPanel newPanel) {
			// TODO Auto-generated method stub
			removeAll();
			setVisible(false);
			add(newPanel);
			validate();
			setVisible(true);

		}
		
	}

}

