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
package interfaces;

import java.util.HashSet;

/**
 * Interface for redirection, any class that implements shoiuld provide the ability to redirect
 * output
 */
public interface IRedirection {
  /**
   * Set that contains set of all commands that support redirection, can be used for error checking
   * for invalid redirection
   */
  @SuppressWarnings("serial")
  public HashSet<String> redirectionSupportedCommands = new HashSet<String>() {
    {
      add("echo");
      add("man");
      add("ls");
      add("cat");
      add("history");
      add("pwd");
      add("tree");
      add("search");
    }
  };

  /**
   * This defines the various types of redirections this fileSystem allows
   */
  enum RedirectionType {
    APPEND, OVERWRITE, NONE
  }
}

