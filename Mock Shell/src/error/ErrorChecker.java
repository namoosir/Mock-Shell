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
package error;

/**
 * Does generic error checking
 */
public class ErrorChecker {

  /**
   * Checks if the number of arguments for a given command is valid
   * 
   * @param inputArr the command along with a list of arguments the user inputs
   * @return boolean true if the number of arguments for a given command is valid and return false
   *         otherwise
   */
  public static boolean checkNumberOfArgs(String[] inputArr) {
    String command = inputArr[0];

    if (command.equals("ls") || command.equals("echo")) {
      return true;
    }
    if (command.equals("")) {
      return true;
    }

    if ((command.equals("tree") || command.equals("exit") || command.equals("pwd")
        || command.equals("history") || command.equals("popd")) && inputArr.length == 1) {
      return true;
    }

    if ((command.equals("cd") || command.equals("history") || command.equals("pushd")
        || command.equals("cat") || command.equals("curl") || command.equals("man")
        || command.equals("rm") || command.equals("echo") || command.equals("saveJShell")
        || command.equals("loadJShell")) && inputArr.length == 2) {
      return true;
    }

    if ((command.equals("mv") || command.equals("cp")) && inputArr.length == 3) {
      return true;
    }

    if ((command.equals("cat") || command.equals("mkdir")) && inputArr.length > 1) {
      return true;
    }

    if (command.equals("search") && inputArr.length >= 6) {
      return true;
    }

    StandardError.allErrors.add("Err: " + command + ": Invalid argument(s)");

    return false;
  }

  /**
   * Checks whether input is a valid Directory/File name
   * 
   * @param input String to be validated
   * @return boolean true if input is a valid Directory/File name, and false otherwise
   */
  public static boolean checkValidDirFileName(String input) {
    String[] check = {"/", ".", " ", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "{", "}",
        "~", "|", "<", ">", "?"};
    StringBuilder all = new StringBuilder("");

    for (String s : check) {
      if (input.contains(s)) {
        all.append(s + ", ");
      }
    }

    if ((all.toString()).isEmpty()) {
      return true;
    }

    StandardError.allErrors.add("Err: Invalid character(s): File/Directory name cannot contain "
        + all.substring(0, all.length() - 2));
    return false;
  }

  /**
   * Checks whether input is a valid string
   * 
   * @param input string to be verified
   * @return boolean true if input is a valid string and false otherwise
   */
  public static boolean checkValidString(String input) {
    if ((input.charAt(0) != '"') || (input.charAt(input.length() - 1) != '"')
        || (input.length() == 1)) {
      StandardError.allErrors.add("Err: String missing wrapping: \"\"");
      return false;
    }
    if (input.substring(1, input.length() - 1).contains("\"")) {
      StandardError.allErrors.add("Err: String cannot contain \"");
      return false;
    }
    return true;
  }

  /**
   * Checks whether path has consecutive slashes
   * 
   * @param path string to be verified
   * @return boolean true if path has consecutive slashes and false otherwise
   */
  public static boolean hasConsecutiveSlash(String path) {
    for (int i = 0; i < path.length() - 1; i++) {
      if (path.charAt(i) == '/' && path.charAt(i + 1) == '/') {
        StandardError.allErrors.add("Err: invalid path: path cannot contain //");
        return true;
      }
    }
    return false;
  }
}
