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
import commands.PopDirectory;
import error.StandardError;
import mockobjects.MockFileSystem;
import mockobjects.MockStack;
import mockobjects.MockStack.Environment;

public class PopDirectoryTest {
  public MockFileSystem fs;
  public MockStack stack;
  private PopDirectory pop;

  @Before
  public void setUp() throws Exception {
    fs = new MockFileSystem(MockFileSystem.Environment.MOCK);
    stack = new MockStack(Environment.MOCK);
    // stack = ["/dir2", "/", "/dir2/dir4"]
    pop = new PopDirectory(stack);
    StandardError.allErrors = new ArrayList<String>();
  }

  @Test
  public void validPath() {

    pop.setFileSystem(fs);
    pop.run();

    assertEquals(fs.dir2, fs.getCurrentDir());
  }

  @Test
  public void emptyStack() {
    pop.setFileSystem(fs);
    pop.run();
    pop.run();
    pop.run();
    pop.run();
    pop.run();

    assertEquals(fs.dir4, fs.getCurrentDir());
  }

}
