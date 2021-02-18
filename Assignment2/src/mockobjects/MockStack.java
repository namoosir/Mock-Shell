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
package mockobjects;

import interfaces.IDirStack;
import java.util.Stack;

/**
 * Mock Dir Stack to be used for testing purposes
 */
public class MockStack implements IDirStack {
  /**
   * Stack of directories
   */
  private Stack<String> dirStack = new Stack<String>();
  String path1 = "/dir2/dir4";
  String path2 = "/";
  String path3 = "/dir2";

  /**
   * Defines the types of environments
   */
  public enum Environment {
    MOCK, EMPTY
  };

  /**
   * Constructor for MockStack
   * @param initType - type of environment, either MOCK or EMPTY
   */
  public MockStack(Environment initType) {
    dirStack.push(path1);
    dirStack.push(path2);
    dirStack.push(path3);
  }

  /**
   * Provides ability to push a new path to the string
   * 
   * @param path - new path to be added
   */
  public void pushOnStack(String path) {
    dirStack.push(path);
  }

  /**
   * Provides ability to pop from directory stack
   * 
   * @return String - top path in directory stack
   */
  public String popStack() {
    return dirStack.pop();

  }
}
