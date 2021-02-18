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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import error.ErrorChecker;
import filesystem.FileSystem;
import stack.DirStack;

/**
 * Load state of shell from previously saved data
 */
public class LoadJShell extends Command {
  /**
   * Holds the instance of the current state of history in parser
   */
  private History historyToUpdate;

  /**
   * Getter for historyToUpdate
   * 
   * @return historyToUpdate
   */
  public History getHistoryToUpdate() {
    return historyToUpdate;
  }

  /**
   * Setter for historyToUpdate
   * 
   * @param historyToUpdate - new state of historyToUpdate
   */
  public void setHistoryToUpdate(History historyToUpdate) {
    this.historyToUpdate = historyToUpdate;
  }

  /**
   * Constructor for LoadJShell, initalizes history
   * 
   * @param history - state of history at the time of calling
   */
  public LoadJShell(History history) {
    this.setHistoryToUpdate(history);
  }

  /**
   * Initiate the dir stack based on the saved data file
   * @param objin - Object Input Stream
   * @throws ClassNotFoundException 
   * @throws IOException
   */
  private void initDirStack(ObjectInputStream objin) throws ClassNotFoundException, IOException {
    DirStack currDirStack = DirStack.getInstance();
    DirStack newStack = (DirStack) objin.readObject();

    try {
      Field field = (currDirStack.getClass()).getDeclaredField("stackInstance");
      field.setAccessible(true);
      field.set(null, newStack);

      field = (currDirStack.getClass()).getDeclaredField("dirStack");
      field.setAccessible(true);
      field.set(currDirStack, newStack.dirStack);
    } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {

    }
  }

  /**
   * Provides the ability to run the "loadJShell" command
   * 
   * @return String null
   */
  public String run() {
    String fileToGet = this.getArgs().get(0);

    if (!ErrorChecker.checkValidDirFileName(fileToGet))
      return null;

    try {
      FileInputStream fin = new FileInputStream(fileToGet);
      ObjectInputStream objin = new ObjectInputStream(fin);
      @SuppressWarnings("unused")
      FileSystem fs = FileSystem.getInstance();

      fs = (FileSystem) objin.readObject();
      initDirStack(objin);
      History newHistory = (History) objin.readObject();

      this.getHistoryToUpdate().setHistory(newHistory.getHistory());
      this.getHistoryToUpdate().setNumOfCommands(newHistory.getNumOfCommands());
      objin.close();
      fin.close();
    } catch (FileNotFoundException f) {
      super.addNewError("Err: loadJShell: save file does not exist");
    } catch (IOException i) {
      super.addNewError("Err: loadJShell: internal error: IOException");
    } catch (ClassNotFoundException c) {
      super.addNewError("Err: loadJShell: internal error: ClassNotFound");
    }
    return null;
  }
}
