package Match_Barcodes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Match_Mutations extends JFrame {

	public static String str_Input_File_Name_1 ="NA";
	public static String str_Input_File_Name_2 ="NA";

	private JPanel contentPane;
	private JLabel lbl_VCF_File_Path_Name_1;
	private JButton btn_StartAnalysis;
	private JButton btn_Open_VCF_File_2;
	private JLabel lbl_VCF_File_Path_Name_2;
	private JTable JTable_File1;
	private JScrollPane scrollPane_1;
	private JTable JTable_File2;
	
	DefaultTableModel Obj_DTM_Adapter_Unique_File_1;
	DefaultTableModel Obj_DTM_Adapter_Unique_File_2;
	DefaultTableModel Obj_DTM_Adapter_Common_File1_File2;

	
	String str_ColumnName_Adapter_File_1[] = new String[] { 			//13
												"Uploaded Variation",
												"Location",
												"Allele",
												"Gene",
												"Feature",
												"Feature type",
												"Consequence",
												"Position in cDNA",
												"Position in CDS",
												"Position in protein",
												"Amino acid change",
												"Codon change",
												"Co-located Variation",
												"Extra"
											};

	String str_ColumnName_Adapter_File_2[] = new String[] { 	
												"Uploaded Variation",
												"Location",
												"Allele",
												"Gene",
												"Feature",
												"Feature type",
												"Consequence",
												"Position in cDNA",
												"Position in CDS",
												"Position in protein",
												"Amino acid change",
												"Codon change",
												"Co-located Variation",
												"Extra"
											};

	String str_ColumnName_Adapter_Common_File_1_File2[] = new String[] { 	
													"Uploaded Variation",
													"Location",
													"Allele",
													"Gene",
													"Feature",
													"Feature type",
													"Consequence",
													"Position in cDNA",
													"Position in CDS",
													"Position in protein",
													"Amino acid change",
													"Codon change",
													"Co-located Variation",
													"Extra"
												};
	
	private JScrollPane scrollPane_2;
	private JTable JTable_Unique_File_1;
	private JButton btn_Export_Unique_File1;
	private JScrollPane scrollPane_4;
	private JButton btn_Export_Common_File1_File2;
	private JTable JTable_Common_File1_File2;
	private JLabel lblNewLabel;
	private JLabel lbl_Count_File_1;
	private JLabel lblNewLabel_1;
	private JLabel lbl_Count_File_2;
	private JLabel lblNewLabel_2;
	private JLabel lbl_Count_Unique_File_1;
	private JLabel lblNewLabel_3;
	private JLabel lbl_Count_Unique_File_2;
	private JLabel lblNewLabel_4;
	private JLabel lbl_Count_Common_File1_File2;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane_3;
	private JTable JTable_Unique_File_2;
	private JButton btn_Export_Unique_File2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Match_Mutations frame = new Match_Mutations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Perform_Aanysis()
	{
		try
		{
		    if(JTable_File1.getRowCount()>0 && JTable_File2.getRowCount() >0)
		    {
		    	int JTable_1_Rows = JTable_File1.getRowCount();
		    	int JTable_2_Rows = JTable_File2.getRowCount();
		    	
		    	Obj_DTM_Adapter_Unique_File_1 = new DefaultTableModel(str_ColumnName_Adapter_File_1, 0);
			    JTable_Unique_File_1.setModel(Obj_DTM_Adapter_Unique_File_1);

		    	Obj_DTM_Adapter_Unique_File_2 = new DefaultTableModel(str_ColumnName_Adapter_File_2, 0);
			    JTable_Unique_File_2.setModel(Obj_DTM_Adapter_Unique_File_2);

		    	Obj_DTM_Adapter_Common_File1_File2 = new DefaultTableModel(str_ColumnName_Adapter_Common_File_1_File2, 0);
			    JTable_Common_File1_File2.setModel(Obj_DTM_Adapter_Common_File1_File2);
			    
			    //Compare File 1 with File 2
		    	for(int count_JTable_1=0 ; count_JTable_1 < JTable_1_Rows; count_JTable_1++)
				{
		    		String Uploaded_Variation_JTable_1 		= JTable_File1.getModel().getValueAt(count_JTable_1, 0).toString();
		    		String Location_JTable_1 				= JTable_File1.getModel().getValueAt(count_JTable_1, 1).toString();
		    		String Allele_JTable_1				 	= JTable_File1.getModel().getValueAt(count_JTable_1, 2).toString();
		    		String Gene_JTable_1 					= JTable_File1.getModel().getValueAt(count_JTable_1, 3).toString();
		    		String Feature_JTable_1 				= JTable_File1.getModel().getValueAt(count_JTable_1, 4).toString();
		    		String Feature_type_JTable_1 			= JTable_File1.getModel().getValueAt(count_JTable_1, 5).toString();
		    		String Consequence_JTable_1 			= JTable_File1.getModel().getValueAt(count_JTable_1, 6).toString();
		    		String Position_in_cDNA_JTable_1 		= JTable_File1.getModel().getValueAt(count_JTable_1, 7).toString();
		    		String Position_in_CDS_JTable_1 		= JTable_File1.getModel().getValueAt(count_JTable_1, 8).toString();
		    		String Position_in_protein_JTable_1 	= JTable_File1.getModel().getValueAt(count_JTable_1, 9).toString();
		    		String Amino_acid_change_JTable_1 		= JTable_File1.getModel().getValueAt(count_JTable_1, 10).toString();
		    		String Codon_change_JTable_1 			= JTable_File1.getModel().getValueAt(count_JTable_1, 11).toString();
		    		String Co_located_Variation_JTable_1 	= JTable_File1.getModel().getValueAt(count_JTable_1, 12).toString();
		    		String Extra_JTable_1 					= JTable_File1.getModel().getValueAt(count_JTable_1, 13).toString();

		    		boolean bl_matched_File1 = false;
		    		
		    		for(int count_JTable_2=0 ; count_JTable_2 < JTable_2_Rows; count_JTable_2++)
					{
		    			String Uploaded_Variation_JTable_2 		= JTable_File2.getModel().getValueAt(count_JTable_2, 0).toString();
		    			String Feature_JTable_2 				= JTable_File2.getModel().getValueAt(count_JTable_2, 4).toString();
		    			
		    			if(Uploaded_Variation_JTable_1.equals(Uploaded_Variation_JTable_2) && Feature_JTable_1.equals(Feature_JTable_2))
		    			{
		    				Obj_DTM_Adapter_Common_File1_File2.addRow(new Object[] {Uploaded_Variation_JTable_2,
														    						Location_JTable_1,
														    						Allele_JTable_1,
														    						Gene_JTable_1,
														    						Feature_JTable_1,
														    						Feature_type_JTable_1,
														    						Consequence_JTable_1,
														    						Position_in_cDNA_JTable_1,
														    						Position_in_CDS_JTable_1,
														    						Position_in_protein_JTable_1,
														    						Amino_acid_change_JTable_1,
														    						Codon_change_JTable_1,
														    						Co_located_Variation_JTable_1,
														    						Extra_JTable_1
														    				});
		    				
		    				bl_matched_File1 = true;
		    			}
					}
		    		if(bl_matched_File1==false)
		    		{
		    			Obj_DTM_Adapter_Unique_File_1.addRow(new Object[] {Uploaded_Variation_JTable_1,
														    						Location_JTable_1,
														    						Allele_JTable_1,
														    						Gene_JTable_1,
														    						Feature_JTable_1,
														    						Feature_type_JTable_1,
														    						Consequence_JTable_1,
														    						Position_in_cDNA_JTable_1,
														    						Position_in_CDS_JTable_1,
														    						Position_in_protein_JTable_1,
														    						Amino_acid_change_JTable_1,
														    						Codon_change_JTable_1,
														    						Co_located_Variation_JTable_1,
														    						Extra_JTable_1		
															    			});
		    		}
				}

		    	
		    	////Compare File 2 with File 1
		    	for(int count_JTable_2=0 ; count_JTable_2 < JTable_2_Rows; count_JTable_2++)
				{
		    		String Uploaded_Variation_JTable_2 		= JTable_File2.getModel().getValueAt(count_JTable_2, 0).toString();
		    		String Location_JTable_2 				= JTable_File2.getModel().getValueAt(count_JTable_2, 1).toString();
		    		String Allele_JTable_2				 	= JTable_File2.getModel().getValueAt(count_JTable_2, 2).toString();
		    		String Gene_JTable_2 					= JTable_File2.getModel().getValueAt(count_JTable_2, 3).toString();
		    		String Feature_JTable_2 				= JTable_File2.getModel().getValueAt(count_JTable_2, 4).toString();
		    		String Feature_type_JTable_2 			= JTable_File2.getModel().getValueAt(count_JTable_2, 5).toString();
		    		String Consequence_JTable_2 			= JTable_File2.getModel().getValueAt(count_JTable_2, 6).toString();
		    		String Position_in_cDNA_JTable_2 		= JTable_File2.getModel().getValueAt(count_JTable_2, 7).toString();
		    		String Position_in_CDS_JTable_2 		= JTable_File2.getModel().getValueAt(count_JTable_2, 8).toString();
		    		String Position_in_protein_JTable_2 	= JTable_File2.getModel().getValueAt(count_JTable_2, 9).toString();
		    		String Amino_acid_change_JTable_2 		= JTable_File2.getModel().getValueAt(count_JTable_2, 10).toString();
		    		String Codon_change_JTable_2 			= JTable_File2.getModel().getValueAt(count_JTable_2, 11).toString();
		    		String Co_located_Variation_JTable_2 	= JTable_File2.getModel().getValueAt(count_JTable_2, 12).toString();
		    		String Extra_JTable_2 					= JTable_File2.getModel().getValueAt(count_JTable_2, 13).toString();
		    		
		    		boolean bl_matched_File2 = false;
		    		
		    		for(int count_JTable_1=0 ; count_JTable_1 < JTable_1_Rows; count_JTable_1++)
					{
		    			String Uploaded_Variation_JTable_1 		= JTable_File1.getModel().getValueAt(count_JTable_1, 0).toString();
			    		String Feature_JTable_1 				= JTable_File1.getModel().getValueAt(count_JTable_1, 4).toString();

		    			if(Uploaded_Variation_JTable_2.equals(Uploaded_Variation_JTable_1) && Feature_JTable_1.equals(Feature_JTable_1))
		    			{
		    				bl_matched_File2 = true;
		    			}
					}
		    		if(bl_matched_File2==false)
		    		{
		    			Obj_DTM_Adapter_Unique_File_2.addRow(new Object[] {Uploaded_Variation_JTable_2,
													    					Location_JTable_2,
												    						Allele_JTable_2,
												    						Gene_JTable_2,
												    						Feature_JTable_2,
												    						Feature_type_JTable_2,
												    						Consequence_JTable_2,
												    						Position_in_cDNA_JTable_2,
												    						Position_in_CDS_JTable_2,
												    						Position_in_protein_JTable_2,
												    						Amino_acid_change_JTable_2,
												    						Codon_change_JTable_2,
												    						Co_located_Variation_JTable_2,
												    						Extra_JTable_2			
													    			});
		    		}
				}

		    	
		    	lbl_Count_Unique_File_1.setText(Integer.toString(JTable_Unique_File_1.getRowCount()));
		    	lbl_Count_Unique_File_2.setText(Integer.toString(JTable_Unique_File_2.getRowCount()));
		    	lbl_Count_Common_File1_File2.setText(Integer.toString(JTable_Common_File1_File2.getRowCount()));
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(null, "Data Missing" , "Message", JOptionPane.PLAIN_MESSAGE);
		    }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	

	/**
	 * Open_and_Load_ExcelFile
	 */
	public void Open_and_Load_ExcelFile(String str_Input_File_Name_1, String str_TableName )
	{
		try 
		{
			FileInputStream inputStream = new FileInputStream(new File(str_Input_File_Name_1));
	         
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        
	        int int_Total_ECL_ExcelSheet_Row_Count = firstSheet.getLastRowNum();	// row count
        	int int_Total_ECL_ExcelSheet_Column_Count =firstSheet.getRow(0).getLastCellNum(); // or = firstSheet.getRow(0).getPhysicalNumberOfCells();	// col count
	        
        	String [][] arr_2D_JTable_ECL_ExcelSheet_Imported_Data = new String[int_Total_ECL_ExcelSheet_Row_Count][int_Total_ECL_ExcelSheet_Column_Count];	// Create 2D Array
        	String [] arr_JTable_ECL_ExcelSheet_Columns_Name = new String [int_Total_ECL_ExcelSheet_Column_Count]; 
	        
	        System.out.println("Total Rows # " + int_Total_ECL_ExcelSheet_Row_Count +" Total Columns" + int_Total_ECL_ExcelSheet_Column_Count);
	
	        //lbl_ECL_Number_of_Samples.setText(Integer.toString(int_Total_ECL_ExcelSheet_Row_Count -1));
	        //lbl_ECL_Number_of_Fields.setText(Integer.toString(int_Total_ECL_ExcelSheet_Column_Count));

	        if(int_Total_ECL_ExcelSheet_Row_Count > 0)
	        {
		        //Rows
		        for(int loopCount_row = 0 ; loopCount_row < int_Total_ECL_ExcelSheet_Row_Count; loopCount_row++)
		        {
		        	Row obj_Row = firstSheet.getRow(loopCount_row);
		        	
		            // Coloums
		            for(int loopCount_col = 0 ; loopCount_col < int_Total_ECL_ExcelSheet_Column_Count; loopCount_col++)
		            {
		            	String str_Cell_Value = "NA";
		            	Cell obj_Cell = obj_Row.getCell(loopCount_col, Row.RETURN_BLANK_AS_NULL);
		            	if (obj_Cell == null)
		            	{
		            		str_Cell_Value = "NA";
		            	}
		            	else
		            	{
		            		str_Cell_Value = obj_Cell.toString();;
		            	}
		            	
		            	arr_2D_JTable_ECL_ExcelSheet_Imported_Data[loopCount_row][loopCount_col] = str_Cell_Value;	// Loading extracted data in to 2D Array			            		 	
            		 	//System.out.print(arr_2D_JTable_ECL_ExcelSheet_Imported_Data[loopCount_row][loopCount_col] + "\t");
		            }			            	
	            	System.out.print("\n");
		        }
		        
	            for(int loopCount_col = 0 ; loopCount_col < int_Total_ECL_ExcelSheet_Column_Count; loopCount_col++)
		        {
	            	arr_JTable_ECL_ExcelSheet_Columns_Name[loopCount_col] = arr_2D_JTable_ECL_ExcelSheet_Imported_Data[0][loopCount_col]; 	// Getting cols form first row
		        }
		
	           DefaultTableModel obj_DTM_Excel_Data = new DefaultTableModel(arr_2D_JTable_ECL_ExcelSheet_Imported_Data, arr_JTable_ECL_ExcelSheet_Columns_Name);
	           obj_DTM_Excel_Data.removeRow(0);

	           if(str_TableName.equals("JTable_File1"))
	           {
	        	   JTable_File1.setModel(obj_DTM_Excel_Data);   
	        	   lbl_Count_File_1.setText(Integer.toString(JTable_File1.getRowCount()+1));
	           }
	           else
	           {
	        	   JTable_File2.setModel(obj_DTM_Excel_Data);
	        	   lbl_Count_File_2.setText(Integer.toString(JTable_File2.getRowCount()+1));
	           }
		       
	        }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Match_Mutations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1355, 930);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btn_Open_VCF_File_1 = new JButton("Open File# 1");
		btn_Open_VCF_File_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
  		 		{
					JFileChooser fileChooser = new JFileChooser();
					int returnValue = fileChooser.showOpenDialog(null);
					if (returnValue == JFileChooser.APPROVE_OPTION) 
					{
						str_Input_File_Name_1 = fileChooser.getSelectedFile().toString();
						lbl_VCF_File_Path_Name_1.setText(str_Input_File_Name_1);
						
						Open_and_Load_ExcelFile(str_Input_File_Name_1, "JTable_File1");
			        }

  		 		}
  		 		catch(Exception ex)
  		 		{
  		 			System.out.print(ex);
  		 		}
			}
		});
		
		lbl_VCF_File_Path_Name_1 = new JLabel("...");
		
		btn_StartAnalysis = new JButton("Start Analysis");
		btn_StartAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Perform_Aanysis();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		btn_Open_VCF_File_2 = new JButton("Open File# 2");
		btn_Open_VCF_File_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
  		 		{
					try
	  		 		{
						JFileChooser fileChooser = new JFileChooser();
						int returnValue = fileChooser.showOpenDialog(null);
						if (returnValue == JFileChooser.APPROVE_OPTION) 
						{
							str_Input_File_Name_2 = fileChooser.getSelectedFile().toString();
							lbl_VCF_File_Path_Name_2.setText(str_Input_File_Name_2);
							
							Open_and_Load_ExcelFile(str_Input_File_Name_2, "JTable_File2");
				        }

	  		 		}
	  		 		catch(Exception ex)
	  		 		{
	  		 			System.out.print(ex);
	  		 		}
					
  		 		}
  		 		catch(Exception ex)
  		 		{
  		 			System.out.print(ex);
  		 		}
			}
		});
		
		lbl_VCF_File_Path_Name_2 = new JLabel("...");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		lblNewLabel = new JLabel("Total File 1: ");
		
		lbl_Count_File_1 = new JLabel("...");
		
		lblNewLabel_1 = new JLabel("Total File 2: ");
		
		lbl_Count_File_2 = new JLabel("...");
		
		lblNewLabel_2 = new JLabel("Unique File 1: ");
		
		lbl_Count_Unique_File_1 = new JLabel("...");
		
		lblNewLabel_3 = new JLabel("Unique File 2: ");
		
		lbl_Count_Unique_File_2 = new JLabel("...");
		
		lblNewLabel_4 = new JLabel("Matches between File 1 & FIle 2: ");
		
		lbl_Count_Common_File1_File2 = new JLabel("...");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Count_File_1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Count_File_2)))
							.addGap(167)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Count_Unique_File_2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Count_Unique_File_1)
									.addGap(220)
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Count_Common_File1_File2))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btn_StartAnalysis, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(btn_Open_VCF_File_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_Open_VCF_File_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_VCF_File_Path_Name_1)
								.addComponent(lbl_VCF_File_Path_Name_2)))
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1330, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(9, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Open_VCF_File_1)
						.addComponent(lbl_VCF_File_Path_Name_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Open_VCF_File_2)
						.addComponent(lbl_VCF_File_Path_Name_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_StartAnalysis)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lbl_Count_File_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lbl_Count_Unique_File_1)
						.addComponent(lblNewLabel_4)
						.addComponent(lbl_Count_Common_File1_File2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3)
						.addComponent(lbl_Count_Unique_File_2)
						.addComponent(lbl_Count_File_2))
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel_File1 = new JPanel();
		tabbedPane.addTab("File 1", null, panel_File1, null);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_File1 = new GroupLayout(panel_File1);
		gl_panel_File1.setHorizontalGroup(
			gl_panel_File1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_File1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1460, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_File1.setVerticalGroup(
			gl_panel_File1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_File1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTable_File1 = new JTable();
		scrollPane.setViewportView(JTable_File1);
		panel_File1.setLayout(gl_panel_File1);
		
		JPanel panel_File2 = new JPanel();
		tabbedPane.addTab("File 2", null, panel_File2, null);
		
		scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_File2 = new GroupLayout(panel_File2);
		gl_panel_File2.setHorizontalGroup(
			gl_panel_File2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_File2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 1460, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_File2.setVerticalGroup(
			gl_panel_File2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_File2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTable_File2 = new JTable();
		scrollPane_1.setViewportView(JTable_File2);
		panel_File2.setLayout(gl_panel_File2);
		
		JPanel panel_Analysis_File1_Control = new JPanel();
		tabbedPane.addTab("Analysis File 1 Control", null, panel_Analysis_File1_Control, null);
		
		scrollPane_2 = new JScrollPane();
		
		btn_Export_Unique_File1 = new JButton("Export");
		btn_Export_Unique_File1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(JTable_Unique_File_1.getRowCount() > 0)
					{
						CLA_Write_To_Excel_CSV obj_CSV = new CLA_Write_To_Excel_CSV();
						obj_CSV.WriteToExcel(JTable_Unique_File_1, str_ColumnName_Adapter_File_1);
						
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		scrollPane_4 = new JScrollPane();
		
		btn_Export_Common_File1_File2 = new JButton("Export");
		btn_Export_Common_File1_File2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(JTable_Unique_File_1.getRowCount() > 0)
					{
						CLA_Write_To_Excel_CSV obj_CSV = new CLA_Write_To_Excel_CSV();
						obj_CSV.WriteToExcel(JTable_Common_File1_File2, str_ColumnName_Adapter_Common_File_1_File2);
						
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		lblNewLabel_6 = new JLabel("Unique in File 1");
		
		lblNewLabel_7 = new JLabel("Common between File 1 & File 2");
		
		lblNewLabel_8 = new JLabel("Unique File 2");
		
		scrollPane_3 = new JScrollPane();
		
		btn_Export_Unique_File2 = new JButton("Export");
		btn_Export_Unique_File2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(JTable_Unique_File_1.getRowCount() > 0)
					{
						CLA_Write_To_Excel_CSV obj_CSV = new CLA_Write_To_Excel_CSV();
						obj_CSV.WriteToExcel(JTable_Unique_File_2, str_ColumnName_Adapter_File_2);
						
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel_Analysis_File1_Control = new GroupLayout(panel_Analysis_File1_Control);
		gl_panel_Analysis_File1_Control.setHorizontalGroup(
			gl_panel_Analysis_File1_Control.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Analysis_File1_Control.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Analysis_File1_Control.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Analysis_File1_Control.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_Analysis_File1_Control.createSequentialGroup()
								.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 1297, Short.MAX_VALUE)
								.addContainerGap())
							.addComponent(btn_Export_Common_File1_File2, Alignment.TRAILING)
							.addGroup(Alignment.TRAILING, gl_panel_Analysis_File1_Control.createSequentialGroup()
								.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 1297, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_panel_Analysis_File1_Control.createSequentialGroup()
								.addComponent(lblNewLabel_6)
								.addContainerGap(1205, Short.MAX_VALUE))
							.addGroup(gl_panel_Analysis_File1_Control.createSequentialGroup()
								.addComponent(lblNewLabel_7)
								.addContainerGap(1101, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_panel_Analysis_File1_Control.createSequentialGroup()
								.addComponent(lblNewLabel_8)
								.addPreferredGap(ComponentPlacement.RELATED, 1098, Short.MAX_VALUE)
								.addComponent(btn_Export_Unique_File1)
								.addContainerGap())
							.addGroup(gl_panel_Analysis_File1_Control.createSequentialGroup()
								.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 1297, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(Alignment.TRAILING, gl_panel_Analysis_File1_Control.createSequentialGroup()
							.addComponent(btn_Export_Unique_File2)
							.addContainerGap())))
		);
		gl_panel_Analysis_File1_Control.setVerticalGroup(
			gl_panel_Analysis_File1_Control.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Analysis_File1_Control.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_Analysis_File1_Control.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn_Export_Unique_File1)
						.addComponent(lblNewLabel_8))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGroup(gl_panel_Analysis_File1_Control.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Analysis_File1_Control.createSequentialGroup()
							.addGap(38)
							.addComponent(lblNewLabel_7))
						.addGroup(gl_panel_Analysis_File1_Control.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Export_Unique_File2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_Export_Common_File1_File2)
					.addContainerGap())
		);
		
		JTable_Unique_File_2 = new JTable();
		scrollPane_3.setViewportView(JTable_Unique_File_2);
		
		JTable_Common_File1_File2 = new JTable();
		scrollPane_4.setViewportView(JTable_Common_File1_File2);
		
		JTable_Unique_File_1 = new JTable();
		scrollPane_2.setViewportView(JTable_Unique_File_1);
		panel_Analysis_File1_Control.setLayout(gl_panel_Analysis_File1_Control);
		contentPane.setLayout(gl_contentPane);
	}
}
