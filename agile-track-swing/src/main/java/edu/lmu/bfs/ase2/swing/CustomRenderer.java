package edu.lmu.bfs.ase2.swing;

 

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

    /**
     * renders and aligns cell values in the table
     * 
     */
    class CustomRenderer extends DefaultTableCellRenderer{

        private Number numberValue;
        private NumberFormat nf;
        private JLabel label = null;
        
        /**
         * override method to render the cell and hear of the table.
         * @param table //the table to be customized
         * @param value // the value of the cell
         * @param isSelected // is a row selected
         * @param hasFocus //is a row has focus
         * @param row // row number
         * @param column // column number
         * @return // return table component
         */
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                        boolean isSelected, boolean hasFocus, int row, int column){
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            super.setHorizontalAlignment(SwingConstants.LEFT); // align all values in cells to the left
            final JTableHeader header = table.getTableHeader(); // instantiate java JtableHeader
             //TableColumnModel colModel = header.getColumnModel();
            header.setBackground(new Color(126,192,238)); // setting background colour of the header
            header.setForeground(Color.WHITE); // setting foreground colour of the header
            header.setReorderingAllowed(false); // reordering of columns is not allowed
            header.setFont(new Font("VERDANA",1,12)); // setting the font of the header]
        
            // if selection mode is set then if(isselected) doesnt work !!!
            // i need to find out why it is.
            //table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // set selection to single selection
            // check to be if a row is selected
            if(isSelected){
                table.setSelectionBackground(Color.black); // change the background
                table.setSelectionForeground(Color.white); // change the forground
            } 
            
            // if no row is selected set the following colour to background and foreground 
            else if(!isSelected){
                if(row%2==1){
                    c.setBackground(new Color(202, 225, 255));
                }else{
                    c.setBackground(new Color(240, 255, 255));
                }
            }
            // if the value of a cell is float then set the fraction point to 2 decimal point
            if ((value != null) && (value instanceof Float)) {
                numberValue = (Float) value;
                nf = NumberFormat.getNumberInstance();
                nf.setMinimumFractionDigits(2);
                nf.setMaximumFractionDigits(2);
                nf.setRoundingMode(RoundingMode.HALF_UP);                
                value = nf.format(numberValue.doubleValue());
            }                                    
            super.setValue(value);                        
            return c;
        }
   
    }