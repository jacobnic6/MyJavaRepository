package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.ClassroomFileHelper;
import controller.CourseFileHelper;
import controller.InstructorFileHelper;
import model.Classroom;
import model.Course;
import model.Instructor;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;

public class AddCourseJPanel extends JPanel {
	private JTextField textFieldCrn;
	private JTextField textFieldCourseName;
	private TimePicker startTimePicker;
	private TimePicker endTimePicker;
	private JComboBox<?> instructorTextField;
	private JComboBox<?> classroomTextField;
	private JButton btnSubmitNewCourse;
	private JButton btnClear;

	InstructorFileHelper instructorFileHelper = new InstructorFileHelper();
	ClassroomFileHelper classroomFileHelper = new ClassroomFileHelper();
	CourseFileHelper courseFileHelper = new CourseFileHelper();

	ArrayList<Instructor> allInstructors;
	ArrayList<Classroom> allClassrooms;
	ArrayList<Course> allCourses;
	private JButton btnBackToMain;

	/**
	 * Create the panel.
	 */
	public AddCourseJPanel() {

		if (!(instructorFileHelper.doesAFileExist())) {
			String message = "No Instructors to Use.  Please add an instructor first";
			popUpErrorMessage(message);

		} else if (!(classroomFileHelper.doesAFileExist())) {
			String message = "No Classrooms to Use.  Please add a classroom first";
			popUpErrorMessage(message);
		} else {

			setLayout(new BorderLayout());
			JLabel title = new JLabel("ENTER A NEW COURSE:");
			add(title, BorderLayout.NORTH);

			allInstructors = (ArrayList<Instructor>) instructorFileHelper.readFile();
			allClassrooms = (ArrayList<Classroom>) classroomFileHelper.readFile();
			allCourses = (ArrayList<Course>) courseFileHelper.readFile();

			JPanel form = new JPanel();

			form.setLayout(new FormLayout(
					new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
							FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
							FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
					new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
							FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
							FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
							FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
							FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
							FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

			JLabel lblCrn = new JLabel("CRN:");
			form.add(lblCrn, "2, 6, right, default");

			textFieldCrn = new JTextField();
			form.add(textFieldCrn, "4, 6, left, default");
			textFieldCrn.setColumns(5);

			JLabel lblCourseName = new JLabel("Course Name:");
			form.add(lblCourseName, "2, 8, right, default");

			textFieldCourseName = new JTextField();
			form.add(textFieldCourseName, "4, 8, 3, 1, left, default");
			textFieldCourseName.setColumns(25);

			TimePickerSettings timeSettings = new TimePickerSettings();
			timeSettings.use24HourClockFormat();
			timeSettings.initialTime = LocalTime.of(15, 30);
			timeSettings.generatePotentialMenuTimes(TimeIncrement.FifteenMinutes, null, null);

			JLabel lblStartTime = new JLabel("Start Time:");
			form.add(lblStartTime, "2, 10, right, default");
			startTimePicker = new TimePicker(timeSettings);
			form.add(startTimePicker, "4, 10, left, default");

			JLabel lblEndTime = new JLabel("End Time:");
			form.add(lblEndTime, "6, 10, left, default");

			endTimePicker = new TimePicker(timeSettings);
			form.add(endTimePicker, "8, 10, left, default");

			ArrayList<String> allInstructorsFormattedNice = formatInstructorListToString(allInstructors);

			JLabel lblInstructor = new JLabel("Instructor:");
			form.add(lblInstructor, "2, 12, right, default");
			instructorTextField = new JComboBox(allInstructorsFormattedNice.toArray());
			form.add(instructorTextField, "4, 12, 5, 1, fill, default");

			ArrayList<String> allClassroomsFormattedNice = formatClassroomListToString(allClassrooms);

			JLabel lblClassroom = new JLabel("Classroom:");
			form.add(lblClassroom, "2, 14, right, default");

			classroomTextField = new JComboBox(allClassroomsFormattedNice.toArray());
			form.add(classroomTextField, "4, 14, 5, 1, fill, default");

			btnSubmitNewCourse = new JButton("Add New Course");
			buttonListener bl = new buttonListener();
			btnSubmitNewCourse.addActionListener(bl);
			form.add(btnSubmitNewCourse, "4, 16");

			btnClear = new JButton("Clear");
			btnClear.addActionListener(bl);
			form.add(btnClear, "6, 16");

			btnBackToMain = new JButton("Back to Main");
			btnBackToMain.addActionListener(bl);
			form.add(btnBackToMain, "8, 16");

			add(form, BorderLayout.CENTER);
		}
	}

	private ArrayList<String> formatClassroomListToString(ArrayList<Classroom> allClassrooms2) {
		// TODO Auto-generated method stub
		ArrayList<String> allClassroomsFormattedNice = new ArrayList<String>();
		for (Classroom a : allClassrooms2) {
			allClassroomsFormattedNice.add(a.getCampus() + " Building " + a.getBuilding() + " Room #"
					+ a.getRoomNumber() + " | " + a.getType() + " | Max Cap:" + a.getCapacity());
		}
		return allClassroomsFormattedNice;
	}

	private ArrayList<String> formatInstructorListToString(ArrayList<Instructor> list) {
		ArrayList<String> allInstructorsFormattedNice = new ArrayList<String>();
		for (Instructor a : list) {
			allInstructorsFormattedNice.add(a.getFirstName() + " " + a.getLastName() + " | " + a.getEmail());
		}
		return allInstructorsFormattedNice;
	}

	class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmitNewCourse) {

				String tempCRN = textFieldCrn.getText();
				String tempCourseName = textFieldCourseName.getText();

				LocalTime tempStartTime = startTimePicker.getTime();
				LocalTime tempEndTime = endTimePicker.getTime();

				Instructor tempInstructor = allInstructors.get(instructorTextField.getSelectedIndex());
				Classroom tempClassroom = allClassrooms.get(classroomTextField.getSelectedIndex());

				Course courseToAdd = new Course(tempCRN, tempCourseName, tempStartTime, tempEndTime, tempInstructor,
						tempClassroom);
				System.out.println(courseToAdd.toString());
				allCourses.add(courseToAdd);

				courseFileHelper.writeFile(allCourses);

			} else if (e.getSource() == btnClear) {

				clearAllFields();

			} else if (e.getSource() == btnBackToMain) {
				sendBackToMainMenuJPanel();
			}

		}

		private void clearAllFields() {
			textFieldCrn.setText("");
			textFieldCourseName.setText("");
			startTimePicker.clear();
			endTimePicker.clear();
		}

	}

	private void popUpErrorMessage(String message) {

		final JOptionPane pane = new JOptionPane(message);
		final JDialog d = pane.createDialog((JFrame) null, "Oops");
		d.setLocation(10, 10);
		d.setVisible(true);
		sendBackToMainMenuJPanel();

	}

	private void sendBackToMainMenuJPanel() {
		removeAll();
		setVisible(false);
		MainMenuJPanel newPanel = new MainMenuJPanel();
		add(newPanel);
		System.out.println("switching to MainMenu JPanel");// for debugging
															// purposes
		validate();
		setVisible(true);
		repaint();

	}

}
