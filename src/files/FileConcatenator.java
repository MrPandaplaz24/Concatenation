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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileConcatenator is a utility class that concatenates Java
 * source files while preserving the functionality of the program.
 * 
 * @author 25
 * @version 1.0.0
 */
public class FileConcatenator {

    /**
     * Concatenates the contents of a .java file into one line.
     * 
     * @param filePath path of the Java source file to be concatenated
     * @param savePath path of the directory where the concatenated file will be
     *                 saved
     */
    public static void concatenateFile(String filePath, String savePath) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            File concatenatedFile = new File(savePath, "ConcatenatedFile.java"); // Comment2
            writer = new BufferedWriter(new FileWriter(concatenatedFile));

            String line;
            boolean inBlockComment = false;
            boolean inJavadocComment = false;
            boolean inQuotes = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Comment3
                boolean isSpecial = false;
                StringBuilder modifiedLine = new StringBuilder();
                boolean multipleQuotes = line.indexOf('"') != line.lastIndexOf('"');

                for (int i = 0; i < line.length(); ++i) {
                    char currentChar = line.charAt(i);
                    if (currentChar == '"' && multipleQuotes == true) {
                        if ((i == 0 || (line.charAt(i - 1) != '\\' || (i > 1 && line.charAt(i - 2) == '\\')))) {
                            inQuotes = !inQuotes;
                            isSpecial = !isSpecial;

                        }
                    }
                    // Check for single line comments
                    if (!inQuotes && !inBlockComment && !inJavadocComment && currentChar == '/' && i < line.length() - 1
                            && line.charAt(i + 1) == '/') {
                        modifiedLine.append(line, 0, i);
                        modifiedLine.append("/*" + line.substring(i + 2) + "*/");
                        writer.write(modifiedLine.toString());
                        isSpecial = !isSpecial;
                        break;
                    }
                }

                if (line.startsWith("@")) {
                    writer.write(line + " ");
                    continue;
                }
                // Check for Javadoc comments
                if (line.startsWith("/**")) {
                    inJavadocComment = true;
                    isSpecial = true;
                }
                if (inJavadocComment) {
                    writer.write(line);
                    if (line.contains("*/")) {
                        inJavadocComment = false;
                    }
                    continue;
                }

                // Check for block comments
                if (line.contains("/*")) {
                    inBlockComment = true;
                    isSpecial = true;
                }
                if (inBlockComment) {
                    writer.write(line);
                    isSpecial = true;
                    if (line.contains("*/")) {
                        inBlockComment = false;
                    }
                }
                if (!isSpecial) {
                    writer.write(line);
                }
            }
        } catch (IOException e) {
            System.err.println("In FileConcatenator: Reader or Writer issue! " + e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
