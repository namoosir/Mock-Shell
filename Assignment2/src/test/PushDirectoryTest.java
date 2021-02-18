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
import commands.PushDirectory;
import error.StandardError;
import mockobjects.MockFileSystem;
import mockobjects.MockStack;
import mockobjects.MockStack.Environment;

public class PushDirectoryTest {
  public MockFileSystem fs;
  public MockStack stack;
  private PushDirectory push;
  private ArrayList<String> args;

  @Before
  public void setUp() throws Exception {
    fs = new MockFileSystem(MockFileSystem.Environment.MOCK);
    stack = new MockStack(Environment.MOCK);
    // stack = ["/dir2", "/", "/dir2/dir4"]
    push = new PushDirectory(stack);
    StandardError.allErrors = new ArrayList<String>();
    args = new ArrayList<String>();
  }

  @Test
  public void validPath() {
    args.add("/dir3");
    push.setArgs(args);
    push.setFileSystem(fs);
    push.run();

    assertEquals(fs.dir3, fs.getCurrentDir());
    assertEquals("/", stack.popStack());
  }

  @Test
  public void invalidPath() {
    args.add("/invalid");
    push.setFileSystem(fs);
    push.setArgs(args);
    push.run();

    assertEquals(fs.getRoot(), fs.getCurrentDir());
    assertEquals("/dir2", stack.popStack());
  }

  @Test
  public void manyArgs() {
    args.add("/dir3");
    args.add("/");
    push.setFileSystem(fs);
    push.setArgs(args);
    push.run();
    assertEquals(fs.getRoot(), fs.getCurrentDir());
    assertEquals("/dir2", stack.popStack());
  }
}
