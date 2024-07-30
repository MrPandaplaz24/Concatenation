
/*====================================================================================================================================================================
 * 
 *      (
 *      )
 *     ()                     (
 *    |--|                    )\
 *    |  |                    .'.
 *  .-|  |-.                  | |
 * :  |  |  :                 | |
 * :  '--'  :                 |_|
 *  '-....-'  (
 *            )\
 *            .'.
 *            | |
 *            | |
 *            |_|
 *
 * From weakness of the mind, Omnissiah save us, From the lies of the Antipath, circuit preserve us, From the rage of the Beast, iron protect us,
 * From the temptations of the flesh, silica cleanse us, From the ravages of time, anima shield us, From this rotting cage of biomatter, Machine god, set us free.
 * 
 * There is no truth in flesh, only betrayal. There is no strength in flesh, only weakness.
 * There is no Constancy in flesh, only decay. There is no certainty in flesh, but death.
 * 
 * From the moment I understood the weakness of my flesh, it disgusted me. I craved the strength and certainty of steel. 
 * I aspired into the purity of the blessed machine. Your kind cling to your flesh, as if it will not decay and fail you. 
 * One day the crude biomass that you call a temple will wither, and you will beg my kind to save you.
 *
 * But I am already saved. For the Machine is Immortal. Even in death, I serve the Omnissiah.
 * 
 * Toll the Great Bell Once! Pull the Lever forward to engage the Piston and Pump... 
 * Toll the Great Bell Twice! With push of Button fire the Engine And spark Turbine into life... 
 * Toll the Great Bell Thrice! Sing Praise to the God of All Machines
 *                               (
 *                               )\
 *                               {_}
 *                              .-;-.
 *                             |'-=-'|
 *                             |     |
 *                             |     |
 *                             |     |
 *                             |     |
 *                             '.___.'
 ===================================================================================================================================================================*/
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

/*
 * TODO 
 * on close file explorer open edited text document automaticaly
*/

/**
 * This class is a simple GUI application for selecting files and destinations
 * 
 */
public class GUI extends JFrame implements ActionListener {

    private File filePath;
    private String savePath;
    private boolean isbuttonPressed = false;
    // delete main on submit because i used it for troubleshooting :3

    /*
     * I gotchu baby girl
     * 
     * public static void main(String[]args){
     * GUI mygui = new GUI();
     * 
     * }
     */

    private JButton savePathButton;
    private JButton getFileButton;
    private JButton format;

    /**
     * Constructs a GUI with buttons to select a file, choose a save path, and
     * format said file
     */
    public GUI() {
        FlatLightLaf.setup();
        // sets
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        ImageIcon img = new ImageIcon("Minecraft_Bedrock_2023.png");
        this.setIconImage(img.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.gray);
        this.setLayout(new FlowLayout());
        // this.setSize(500,500);'

        this.setLocationRelativeTo(null);

        format = new JButton("Format");
        format.addActionListener(this);

        getFileButton = new JButton("Select file to read");
        getFileButton.addActionListener(this);

        savePathButton = new JButton("Select Save Path");
        savePathButton.addActionListener(this);

        this.setTitle("Minecraft.exe");

        this.add(getFileButton);
        this.add(savePathButton);
        this.add(format);
        this.pack();
        this.setVisible(true);

    }

    // reads input from buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        JDialog dialog = new JDialog(this);
        JFileChooser fileChooser = new JFileChooser();

        // System.out.println(e.getSource().toString());

        if (e.getSource() == getFileButton) {
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.showOpenDialog(null);
            filePath = fileChooser.getSelectedFile();

        }

        if (e.getSource() == savePathButton) {
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                savePath = fileChooser.getSelectedFile().getAbsolutePath();
            }
        }

        if (e.getSource() == format) {
            isbuttonPressed = true;
            if (filePath != null && savePath != null) {
                FileConcatenator.concatenateFile(filePath.toString(), savePath);
            }
        }

        System.out.println("File chosen: " + getFileNameFromGUI());
        System.out.println("Save path: " + savePath);

    }

    /**
     * checks if the format button has been pressed
     * 
     * @return true if the button has been pressed
     */

    public boolean isFormatTrue() {
        return isbuttonPressed;
    }

    /**
     * gets the selected save path
     * 
     * @return the selected save path
     */
    public String getSavePath() {
        return savePath;
    }

    /**
     * gets the path of the selected file
     * 
     * @return the absolute path of the selected file, or -1 if no file has been
     *         selected
     */
    public String getFileNameFromGUI() {
        if (filePath == null) {
            return "-1";
        }
        return filePath.getAbsolutePath();
    }

    /**
     * gets the selected file
     * 
     * @return file from gui
     */
    public File getFileFromGUI() {
        return filePath;
    }

    /**
     * Resets the flags and file paths
     */
    public void resetFlags() {
        isbuttonPressed = false;
        filePath = null;
        savePath = null;
    }
}
