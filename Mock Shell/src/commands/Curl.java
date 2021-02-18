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

import java.net.*;
import helpers.Output;
import interfaces.IRedirection;
import java.io.*;

/**
 * Provides the ability to perform the "curl" command.
 */
public class Curl extends Command {
  /**
   * Runs the "curl" command.
   * 
   * @return String - any valid user output
   */
  public String run() {
    try {
      URL urlToFetch = new URL(this.getArgs().get(0));
      URLConnection connection = urlToFetch.openConnection();
      BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String latestRead;
      StringBuilder out = new StringBuilder("");

      while ((latestRead = input.readLine()) != null) {
        out.append(latestRead);
        out.append("\n");
      }

      String path[] = this.getArgs().get(0).split("/");
      String file = path[path.length - 1];
      file = file.replace(".", "");
      Output.redirect(super.getFileSystem(), out.toString(), file,
          IRedirection.RedirectionType.OVERWRITE);
    } catch (Exception e) {
      super.addNewError("Err: curl: check URL");
    }

    return null;
  }
}
