package ex3g;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PayrollForm extends JFrame {
	private final JLabel lblNewLabel = new JLabel("Select employee:");
	private JList employeeList;
	private JLabel lblEmployeeId;
	private JLabel lblEmployeeName;
	private JLabel lblPayRate;
	private JLabel lblEnterHours;
	private JTextField hoursTextField;
	private JLabel totalHoursLabel;
	private JLabel grossPayLabel;
	private DefaultListModel employeeListModel;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField payRateTextField;
	private PayrollObjMapper payrollObjMapper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollForm frame = new PayrollForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PayrollForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				do_this_windowClosing(arg0);
			}
		});
		setTitle("CAnderson 2740 Ex 2E Payroll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 372);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(21, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 36, 325, 103);
		contentPane.add(scrollPane);
		
//		employeeList = new JList();
//		employeeListModel = new DefaultListModel();
//		employeeListModel.addElement(new Payroll (101, "Robert Rathman", 10.0));
//		employeeListModel.addElement(new Payroll (102, "Isabel Torres", 20.0));
//		employeeListModel.addElement(new Payroll (103, "Kyle Kastensmidt", 30.0));
//		employeeListModel.addElement(new Payroll (104, "Erik Bennick", 40.0));
//		employeeListModel.addElement(new Payroll (105, "Josh Cowell", 50.0));
		
		payrollObjMapper = new PayrollObjMapper("PayrollData.txt");
		employeeListModel = payrollObjMapper.getAllPayroll();
		
		employeeList = new JList(employeeListModel);
		employeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_employeeList_mouseClicked(arg0);
			}
		});
		employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(employeeList);
		
		lblEmployeeId = new JLabel("Employee ID:(>100)");
		lblEmployeeId.setBounds(21, 159, 99, 14);
		contentPane.add(lblEmployeeId);
		
		lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(21, 179, 99, 14);
		contentPane.add(lblEmployeeName);
		
		lblPayRate = new JLabel("Pay rate:(7.25 - 100)");
		lblPayRate.setBounds(21, 199, 125, 14);
		contentPane.add(lblPayRate);
		
		lblEnterHours = new JLabel("Enter hours:(0.1 - 20.0)");
		lblEnterHours.setBounds(21, 219, 135, 14);
		contentPane.add(lblEnterHours);
		
		hoursTextField = new JTextField();
		hoursTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_hoursTextField_focusGained(arg0);
			}
		});
		hoursTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		hoursTextField.setText("0.00");
		hoursTextField.setBounds(196, 219, 69, 20);
		contentPane.add(hoursTextField);
		hoursTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total hours:");
		lblNewLabel_1.setBounds(21, 239, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		totalHoursLabel = new JLabel("0.00");
		totalHoursLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalHoursLabel.setBounds(196, 236, 69, 20);
		contentPane.add(totalHoursLabel);
		
		JLabel lblGrossPay = new JLabel("Gross pay:");
		lblGrossPay.setBounds(21, 259, 75, 14);
		contentPane.add(lblGrossPay);
		
		grossPayLabel = new JLabel("$0.00");
		grossPayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		grossPayLabel.setBounds(146, 259, 69, 20);
		contentPane.add(grossPayLabel);
		
		JButton addHoursButton = new JButton("+");
		addHoursButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_addHoursButton_actionPerformed(arg0);
			}
		});
		addHoursButton.setBounds(289, 215, 41, 23);
		contentPane.add(addHoursButton);
		
		JButton clearHoursButton = new JButton("Clear");
		clearHoursButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_clearHoursButton_actionPerformed(e);
			}
		});
		clearHoursButton.setBounds(352, 215, 69, 23);
		contentPane.add(clearHoursButton);
		
		JButton btnClearForm = new JButton("Clear Form");
		btnClearForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClearForm_actionPerformed(e);
			}
		});
		btnClearForm.setBounds(315, 299, 106, 23);
		contentPane.add(btnClearForm);
		
		empIdTextField = new JTextField();
		empIdTextField.setText("000");
		empIdTextField.setBounds(176, 159, 89, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		empNameTextField = new JTextField();
		empNameTextField.setBounds(130, 179, 135, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		payRateTextField = new JTextField();
		payRateTextField.setText("7.25");
		payRateTextField.setBounds(179, 199, 86, 20);
		contentPane.add(payRateTextField);
		payRateTextField.setColumns(10);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_updateButton_actionPerformed(arg0);
			}
		});
		updateButton.setBounds(176, 299, 89, 23);
		contentPane.add(updateButton);
	}
	protected void do_employeeList_mouseClicked(MouseEvent arg0) {
		
		Payroll payroll =(Payroll) employeeList.getSelectedValue(); 
		this.empIdTextField.setText(Integer.toString(payroll.getId())); 
		this.empNameTextField.setText(payroll.getName()); 
		DecimalFormat dollarFmt = new DecimalFormat ("###0.00");
		this.payRateTextField.setText(dollarFmt.format(payroll.getPayRate()));
		this.totalHoursLabel.setText(Double.toString(payroll.getHours()));
		DecimalFormat dollarPayFmt = new DecimalFormat ("###0.00");
		this.grossPayLabel.setText(dollarPayFmt.format(payroll.calcGrossPay())); 
		this.hoursTextField.requestFocus(); 


		
	}
	
	protected void do_addHoursButton_actionPerformed(ActionEvent arg0) {
	
		Payroll item = (Payroll) employeeList.getSelectedValue(); 
		 if (item.addHours(Double.parseDouble(hoursTextField.getText()))){ 
		    DecimalFormat hoursFmt = new DecimalFormat("####.00"); 
		    totalHoursLabel.setText(hoursFmt.format(item.getHours())); 
		    DecimalFormat dollarFmt = new DecimalFormat("$#,###.00"); 
		    grossPayLabel.setText(dollarFmt.format(item.calcGrossPay())); 
		    hoursTextField.setText("0.00"); 
		    this.hoursTextField.requestFocus(); 
		 } 
		 else { 
			 JOptionPane.showMessageDialog(null,"Invalid hours, \nMust be between 0.1 and 20.0"); 
			 hoursTextField.requestFocus(); 
		 		 
		 } 
		 		 
		 		 
		 DecimalFormat hoursFmt = new DecimalFormat("####.00"); 
		 totalHoursLabel.setText(hoursFmt.format(item.getHours())); 
		 DecimalFormat dollarFmt = new DecimalFormat("$#,###.00"); 
		 grossPayLabel.setText(dollarFmt.format(item.calcGrossPay())); 
		 hoursTextField.setText("0.00"); 
		 this.hoursTextField.requestFocus(); 


	}
	
	protected void do_clearHoursButton_actionPerformed(ActionEvent e) {
		
		Payroll payroll = (Payroll) employeeList.getSelectedValue(); 
		 payroll.setHours(0); 
		 this.totalHoursLabel.setText("0.00"); 
		 this.grossPayLabel.setText("0.00"); 
		 this.hoursTextField.setText("0.00"); 
		 this.hoursTextField.requestFocus(); 

	
	}
	
	protected void do_btnClearForm_actionPerformed(ActionEvent e) {
		
		 this.empIdTextField.setText("0"); 
		 this.empNameTextField.setText(""); 
		 this.payRateTextField.setText("$0.00"); 
		 this.hoursTextField.setText("0.00"); 
		 this.totalHoursLabel.setText("0.00"); 
		 this.grossPayLabel.setText("$0.00"); 
		 this.hoursTextField.requestFocus(); 
		 this.employeeList.clearSelection(); 

			
	}
	
	protected void do_hoursTextField_focusGained(FocusEvent arg0) {
		
		hoursTextField.selectAll();
		
	}
	protected void do_updateButton_actionPerformed(ActionEvent arg0) {
		
		 
		 int id = Integer.parseInt(empIdTextField.getText()); 
		 double payRate = Double.parseDouble(payRateTextField.getText()); 
		 Payroll payroll = (Payroll) employeeList.getSelectedValue(); 
		  
		 if (!payroll.setId(id)) { 
			 JOptionPane.showMessageDialog(null,"Invalid emplyee ID, \nMust be > 100"); 
			 empIdTextField.setText(Integer.toString((payroll.getId()))); 
			 empIdTextField.requestFocus(); 
		 } 
		 else { 
		 if (!payroll.setName(empNameTextField.getText())){ 
			 JOptionPane.showMessageDialog(null,"Invalid name"); 
			 empNameTextField.setText(payroll.getName()); 
			 empNameTextField.requestFocus(); 
		 } 
		 	else { 
		 		if (!payroll.setPayRate(payRate)) { 
		 			JOptionPane.showMessageDialog(null,"Invalid pay rate, \nMust be between 7.25 and 100.00"); 
		 			payRateTextField.setText(Double.toString(payroll.getPayRate())); 
		 			payRateTextField.requestFocus(); 
		 		} 
		 	} 
		 } 
		 
		 employeeList.repaint(); 
	}
	
	

		
	protected void do_this_windowClosing(WindowEvent arg0) {
		if (payrollObjMapper != null) 
			payrollObjMapper.writeAllPayroll(employeeListModel);
	}
}

