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
package stack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Stack;
import interfaces.IDirStack;

/*
 * This class keeps track of a stack that holds full path names
 *
 */
public class DirStack implements Serializable, IDirStack {
  /**
   * Required for serialization
   */
  private static final long serialVersionUID = 3317455530083740968L;
  private static DirStack stackInstance;
  public Stack<String> dirStack;

  private DirStack() {
    this.dirStack = new Stack<String>();
  }

  /**
   * @param dirPath
   */
  public void pushOnStack(String dirPath) {
    dirStack.push(dirPath);
  }

  /**
   * @return String
   */
  public String popStack() {
    return dirStack.pop();
  }

  /**
   * @return DirStack
   */
  public static DirStack getInstance() {
    return stackInstance == null ? stackInstance = new DirStack() : stackInstance;
  }

  /**
   * Overrides the readObject method from Serializable, needed to ensure the integrity of the
   * singleton pattern
   */
  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    stackInstance = this; // rather than creating new instance, assign current object to INSTANCE
  }

  /**
   * Overrides the readResolve method from Serializable, needed to ensure the integrity of the
   * singleton pattern
   */
  private Object readResolve() {
    return stackInstance; // return INSTANCE.
  }
}
