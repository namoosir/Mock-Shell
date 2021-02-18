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
import parser.Parser;
import org.junit.Before;
import org.junit.Test;
import error.StandardError;

public class ParserTest {

  Parser parser;

  @Before
  public void setUp() throws Exception {
    parser = new Parser();
    StandardError.allErrors = new ArrayList<String>();
  }

  @Test
  public void testInvalidCommand() {
    parser.parse("invaldCommand args");

    assertTrue(StandardError.allErrors.get(0).equals("Err: invalid command"));
  }

  @Test
  public void testValidCommand() {
    parser.parse("cd /");

    assertEquals(0, StandardError.allErrors.size());
  }

  @Test
  public void testExtraWhiteSpace() {
    parser.parse("cd          /        ");

    assertEquals(0, StandardError.allErrors.size());
  }

  @Test
  public void testNoSpace() {
    parser.parse("cd/");

    assertTrue(StandardError.allErrors.size() > 0);
  }
}
