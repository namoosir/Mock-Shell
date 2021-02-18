// **********************************************************
// Assignment2:
// Student1: Mutasem Kharsa
// UTORID user_name: Kharsamu
// UT Student #: 1006211083
// Author: Mutasem Kharsa
//
// Student2: Nazmus Saqeeb
// UTORID user_name: saqeebna
// UT Student #: 1006306007
// Author: Nazmus Saqeeb
//
// Student3: Salik Chodhary
// UTORID user_name: chodhary
// UT Student #: 1006115892
// Author: Salik Chodhary
//
// Student4: Andy Yuen
// UTORID user_name: yuenand4
// UT Student #: 1006399247
// Author: Andy Yuen
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package commands;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import error.ErrorChecker;
import filesystem.FileSystem;
import stack.DirStack;

/**
 * Save state of shell command
 */
public class SaveJShell extends Command {
  /**
   * Holds the instance of the current state of history in parser
   */
  private History historyToSave;

  /**
   * Getter for historyToSave
   * 
   * @return historyToSave
   */
  public History getHistoryToSave() {
    return historyToSave;
  }

  /**
   * Setter for historyToSave
   * 
   * @param historyToSave - new state of historyToSave
   */
  public void setHistoryToSave(History historyToSave) {
    this.historyToSave = historyToSave;
  }

  /**
   * Constructor for SaveJShell, initalizes history
   * 
   * @param history - state of history at the time of calling
   */
  public SaveJShell(History history) {
    this.setHistoryToSave(history);
  }

  /**
   * Provides the ability to run the "saveJShell" command
   * 
   * @return String null
   */
  public String run() {
    String fileName = super.getArgs().get(0);

    if (!ErrorChecker.checkValidDirFileName(fileName))
      return null;

    try {

      FileOutputStream fout = new FileOutputStream(fileName);
      ObjectOutputStream objout = new ObjectOutputStream(fout);

      FileSystem fs = FileSystem.getInstance();
      DirStack dirStack = DirStack.getInstance();
      objout.writeObject(fs);
      objout.writeObject(dirStack);
      objout.writeObject(this.getHistoryToSave());

      objout.close();
      fout.close();
    } catch (FileNotFoundException f) {
      super.addNewError("Err: loadJShell: save file does not exist");
    } catch (IOException i) {
      super.addNewError("Err: saveJShell: internal error: IOException");
    }
    return null;
  }
}
