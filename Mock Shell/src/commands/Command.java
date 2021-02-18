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

import java.util.ArrayList;
import error.StandardError;
import helpers.Output;
import interfaces.IFileSystem;

/**
 * Superclass for all commands, and provides the ability to redirect output
 */
public class Command {
  /**
   * Stores user-provided arguments
   */
  private ArrayList<String> args;
  /**
   * Stores the current command being executed
   */
  private String currentCommand;

  /**
   * Stores the filesystem instance, allows dependencey injection
   */
  private IFileSystem fs;
 
  /**
   * Stores raw user input
   */
  private String rawUserInput;

  /**
   * Getter for rawUserinput
   * @return String - rawUserInput
   */
  public String getRawUserInput() {
    return rawUserInput;
  }

  /**
   * Setter for rawUserInput
   * 
   * @param rawUserInput
   */
  public void setRawUserInput(String rawUserInput) {
    this.rawUserInput = rawUserInput;
  }

  /**
   * Get the instance of file system
   * 
   * @return IFileSystem - the instance of the file system
   */
  public IFileSystem getFileSystem() {
    return fs;
  }

  /**
   * Provides functionality to update the fs field
   * 
   * @param fileSystem - the new file system to be updated to
   */
  public void setFileSystem(IFileSystem fileSystem) {
    this.fs = fileSystem;
  }

  /**
   * Getter for currentCommand
   * 
   * @return String current value of currentCommand field member
   */
  public String getCurrentCommand() {
    return currentCommand;
  }

  /**
   * Setter for currentCommand
   * 
   * @param currentCommand new value for currentCommand field
   */
  public void setCurrentCommand(String currentCommand) {
    this.currentCommand = currentCommand;
  }

  /**
   * Getter for args arraylist
   * 
   * @return ArrayList<String> Reference to current args from user
   */
  public ArrayList<String> getArgs() {
    return args;
  }

  /**
   * Setter for args arraylist
   * 
   * @param args contains new args for command
   */
  public void setArgs(ArrayList<String> args) {
    this.args = args;
  }

  /**
   * Default run, simply prints new line. This is called when the user gives no input and presses
   * enter
   */
  public String run() {
    Output.nullCommandPrint();
    return null;
  }

  /**
   * Provides commands the ability to output to the user through the terminal
   * 
   * @param s represents the string to be outputted to the user
   */
  public void output(String s) {
    Output.print(s);
  }


  /**
   * Add new error to Standard Error
   * 
   * @param err represents new error to be Standard Error
   */
  public void addNewError(String err) {
    StandardError.allErrors.add(err);
  }

}
