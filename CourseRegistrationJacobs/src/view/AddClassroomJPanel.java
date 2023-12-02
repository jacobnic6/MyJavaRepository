package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.ClassroomFileHelper;

import model.Classroom;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class AddClassroomJPanel extends JPanel {
	private JTextField txtBuilding;
	private JTextField txtRoomnumber;
	private JTextField txtCapacity;
	private JTextField txtType;
	private JComboBox comboBoxCampus;
	private JButton btnSubmitNewRoom;
	private JButton btnClearEntry;
	private JButton btnReturnToMain;
	ClassroomFileHelper fileHelper = new ClassroomFileHelper();
	ArrayList<Classroom> allClassrooms;
	private JLabel lblCampus;

	/**
	 * Create the panel.
	 */
	public AddClassroomJPanel() {
		
		allClassrooms = (ArrayList<Classroom>) fileHelper.readFile();
		JPanel form = new JPanel();
		form.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblBuildingNumber = new JLabel("Building Number:");
		form.add(lblBuildingNumber, "4, 4, right, default");
		
		txtBuilding = new JTextField();
		form.add(txtBuilding, "8, 4, fill, default");
		txtBuilding.setColumns(10);
		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		form.add(lblRoomNumber, "4, 6, right, default");
		
		txtRoomnumber = new JTextField();
		form.add(txtRoomnumber, "8, 6, fill, default");
		txtRoomnumber.setColumns(10);
		
		lblCampus = new JLabel("Campus:");
		form.add(lblCampus, "4, 8 ,right, default");
		
		comboBoxCampus = new JComboBox();
		comboBoxCampus.setModel(new DefaultComboBoxModel(new String[] {"Ankeny", "Urban", "Newton", "West", "Boone", "Carroll"}));
		form.add(comboBoxCampus, "8, 8, fill, default");
		
		JLabel lblCapacity = new JLabel("Capacity:");
		form.add(lblCapacity, "4, 10, right, default");
		
		txtCapacity = new JTextField();
		form.add(txtCapacity, "8, 10, fill, default");
		txtCapacity.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		form.add(lblType, "4, 12, right, default");
		
		txtType = new JTextField();
		form.add(txtType, "8, 12, fill, default");
		txtType.setColumns(10);
		
		buttonListener bl = new buttonListener();
		
		btnSubmitNewRoom = new JButton("Submit New Room");
		btnSubmitNewRoom.addActionListener(bl);
		form.add(btnSubmitNewRoom, "8, 14");
		
		btnClearEntry = new JButton("Clear Entry");
		btnClearEntry.addActionListener(bl);
		form.add(btnClearEntry, "8, 16");
		
		btnReturnToMain = new JButton("Return to Main");
		btnReturnToMain.addActionListener(bl);
		form.add(btnReturnToMain, "8, 18");
		
		add(form);

	}
	
	class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnSubmitNewRoom){
				
				Classroom classroomToAdd = new Classroom(txtBuilding.getText(), txtRoomnumber.getText(), (String)comboBoxCampus.getSelectedItem(), txtType.getText(), Integer.parseInt(txtCapacity.getText()));
				allClassrooms.add(classroomToAdd);
				fileHelper.writeFile(allClassrooms);
				
				clearAllFields();

			} else if (e.getSource() == btnClearEntry) {

				clearAllFields();

			} else if (e.getSource() == btnReturnToMain) {

				removeAll();
				setVisible(false);
				MainMenuJPanel newPanel = new MainMenuJPanel();
				add(newPanel);
				validate();
				setVisible(true);
			}

		}

		private void clearAllFields() {
			txtBuilding.setText("");
			txtRoomnumber.setText(""); 
			comboBoxCampus.setSelectedIndex(0);
			txtType.setText(""); 
			txtCapacity.setText("");
			
		}
		
	}

}
