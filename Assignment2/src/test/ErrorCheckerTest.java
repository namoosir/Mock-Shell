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
import org.junit.Test;
import error.ErrorChecker;

public class ErrorCheckerTest {

  @Test
  public void testSingleWordCommandNumberOfArgs() {
    String[] inputArr = {"exit"};

    assertEquals(ErrorChecker.checkNumberOfArgs(inputArr), true);
  }

  @Test
  public void testDoubleWordCommandNumberOfArgs() {
    String[] inputArr = {"history", "10"};

    assertEquals(ErrorChecker.checkNumberOfArgs(inputArr), true);
  }

  @Test
  public void testTripleWordCommandNumberOfArgs() {
    String[] inputArr = {"mv", "a", "b"};

    assertEquals(ErrorChecker.checkNumberOfArgs(inputArr), true);
  }

  @Test
  public void testMoreWordCommandNumberOfArgs() {
    String[] inputArr = {"mkdir", "a", "b", "v", "c"};

    assertEquals(ErrorChecker.checkNumberOfArgs(inputArr), true);
  }

  @Test
  public void testValidCheckValidDirFileName() {
    String input = "sdfadfadfadfadf";

    assertEquals(ErrorChecker.checkValidDirFileName(input), true);
  }

  @Test
  public void testInvalidCheckValidDirFileName() {
    String input = "sdfadfadfa@dfadf";

    assertEquals(ErrorChecker.checkValidDirFileName(input), false);
  }

  @Test
  public void testInvalidCheckValidDirFileName2() {
    String input = "sdfadfadf{a#df}adf";

    assertEquals(ErrorChecker.checkValidDirFileName(input), false);
  }

  @Test
  public void testValidCheckValidString() {
    String input = "\"sdfadfadfadfadf\"";

    assertEquals(ErrorChecker.checkValidString(input), true);
  }

  @Test
  public void testInvalidCheckValidString() {
    String input = "sdfadfadfadfadf\"";

    assertEquals(ErrorChecker.checkValidString(input), false);
  }

  @Test
  public void testHasHasConsecutiveSlash() {
    String input = "asdf//asdf";

    assertEquals(ErrorChecker.hasConsecutiveSlash(input), true);
  }

  @Test
  public void testNotHasConsecutiveSlash() {
    String input = "asdf/asdf";

    assertEquals(ErrorChecker.hasConsecutiveSlash(input), false);
  }
}
