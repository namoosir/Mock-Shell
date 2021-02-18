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

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class outputs is for history command which displays the command history to the user
 */

public class History extends Command implements Serializable {


  /**
   * Required for serialization
   */
  private static final long serialVersionUID = -1414589622986430444L;

  /*
   * The array list used to store all commands
   */
  private ArrayList<String> history = new ArrayList<String>();

  public void setHistory(ArrayList<String> history) {
    this.history = history;
  }

  /*
   * The number of commands that user wants to displayed
   */
  private int numOfCommands;

  /**
   * @return the array list with all the commands that can be displayed
   */
  public ArrayList<String> getHistory() {
    return history;
  }

  /**
   * @param command the user inputed command to be added to history list
   */
  public void addCommandToHistory(String command) {
    this.getHistory().add(command);

  }

  /**
   * @return the number of commands in history as an integer
   */
  public int getNumOfCommands() {
    return numOfCommands;
  }

  /**
   * @param numOfCommands is the number of commands from history that the user wants displayed
   */
  public void setNumOfCommands(int numOfCommands) {
    this.numOfCommands = numOfCommands;
  }

  /**
   * Executes the history command to display a list of recent commands
   * 
   * @return
   */
  public String run() {
    String output = "";
    if (!this.getArgs().isEmpty()) {
      try {
        this.setNumOfCommands(Integer.parseInt(this.getArgs().get(0)));
      } catch (NumberFormatException e) {
        super.addNewError("Err: history: requires numeric argument ");
        return null;
      }
    }

    if (this.getArgs().isEmpty()) {
      this.setNumOfCommands(this.getHistory().size());
    }
    int i = Math.max(this.getHistory().size() - numOfCommands, 0);

    for (; i < this.getHistory().size(); i++) {
      int outputInt = i + 1;
      output += (outputInt + ". " + this.getHistory().get(i)) + "\n";
    }
    return output.trim();
  }

}
