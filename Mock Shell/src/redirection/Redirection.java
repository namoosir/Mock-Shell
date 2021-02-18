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
package redirection;

import interfaces.IRedirection;
import commands.Command;
import helpers.Pair;

/**
 * Implements the Redirection Interface, hence, it allows a user to redirect output to any valid
 * file. Redirection can be either appended to text files, or overwritten.
 */
public class Redirection implements IRedirection {

  /**
   * Returns the required data for redirection: file name, and redirection type. Additionally, this
   * returns a new cleansed inputArr, that does not include any of the redirection information.
   * 
   * @param input - pure user input
   * @param inputArr - User input splitted on whitespace
   * @return Pair<Pair<RedirectionType, String>> - Redirection Data
   */
  public static Pair<Pair<RedirectionType, String>, String[]> getRedirectionData(String input,
      String[] inputArr, Command command) {
    String inputWithoutRedirection = "";
    String redirectionData[] = null;
    RedirectionType type = RedirectionType.NONE;

    if (input.matches(".*(>|>>).*")) {

      if (input.matches(".*(>>).*"))
        input = input.substring(0, input.indexOf(">")) + " >> "
            + input.substring(input.indexOf(">") + 2);
      else
        input = input.substring(0, input.indexOf(">")) + " > "
            + input.substring(input.indexOf(">") + 1);


      inputWithoutRedirection = input.trim().substring(0, input.trim().indexOf(">")).trim();
      redirectionData = input.trim().substring(input.trim().indexOf(">")).split("\\s+");

      if (redirectionData.length > 2)
        return null;
      if (redirectionSupportedCommands.contains(inputArr[0]))
        type = redirectionData[0].equals(">") ? RedirectionType.OVERWRITE : RedirectionType.APPEND;
      else
        type = RedirectionType.NONE;

      inputArr = inputWithoutRedirection.split("\\s+");
      command.setRawUserInput(inputWithoutRedirection);
      return new Pair<>(new Pair<>(type, redirectionData[1]), inputArr);
    } else
      command.setRawUserInput(input);
    return new Pair<>(new Pair<>(RedirectionType.NONE, null), inputArr);
  }
}
