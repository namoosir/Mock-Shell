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
package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import commands.History;
import commands.SaveJShell;
import error.StandardError;
import java.io.File;

public class SaveJShellTest {
  History history;
  ArrayList<String> args;
  SaveJShell save;

  @Before
  public void setUp() throws Exception {
    history = new History();
    args = new ArrayList<String>();
    save = new SaveJShell(history);
    StandardError.allErrors = new ArrayList<String>();
  }

  @Test
  public void testValidCase() {
    File f = new File("testfile");
    args.add("testfile");
    save.setArgs(args);
    save.run();

    assertEquals(0, StandardError.allErrors.size());
    assertTrue(f.exists() && !f.isDirectory());
  }

}
