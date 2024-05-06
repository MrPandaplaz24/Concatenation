package files;

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
import java.io.File;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class DriverMain {
    /**
     * Creates an instance of the entry point of the program
     * 
     * @param args Command-Line arguments
     **/
    public static void main(String[] args) {
        GUI gui = new GUI();
        while (true) {
            boolean concatenated = false;
            while (!gui.isFormatTrue() || gui.getFileFromGUI() == null || gui.getSavePath() == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!concatenated) {
                File inputFile = gui.getFileFromGUI();
                String savePath = gui.getSavePath();
                try {
                    FileConcatenator.concatenateFile(inputFile.getAbsolutePath(), savePath);
                    System.out.println("File concatenation completed!");
                    concatenated = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gui.resetFlags();
            }
        }
    }
}
