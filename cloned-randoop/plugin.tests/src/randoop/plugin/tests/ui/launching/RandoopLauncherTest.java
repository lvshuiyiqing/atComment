package randoop.plugin.tests.ui.launching;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import randoop.plugin.tests.WorkspaceManager;


@SuppressWarnings("nls")
@RunWith(SWTBotJunit4ClassRunner.class)
public class RandoopLauncherTest {
  private static SWTWorkbenchBot bot;

  @BeforeClass
  public static void beforeClass() throws Exception {
    WorkspaceManager.setupDemoWorkspace();
    
    bot = new SWTWorkbenchBot();
    bot.viewByTitle("Welcome").close();

    // Change the perspective via the Open Perspective dialog
    bot.menu("Window").menu("Open Perspective").menu("Other...").click();
    SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
    openPerspectiveShell.activate();

    // select the dialog
    bot.table().select("Java");
    bot.button("OK").click();
  }

  @Test
  public void canCreateANewJavaProject() throws Exception {
    bot.menu("Run").menu("Run Configurations...").click();

    SWTBotShell shell = bot.shell("Run Configurations");
    shell.activate();
    bot.tree().getTreeItem("Randoop Launcher").contextMenu("New").click();
    
    // Set the name of the Randoop launch configurations
    bot.text(1).setText("All Tests");
    
    bot.tabItemInGroup("randoop.plugin.ui.launching.gentestsTabGroup", 1).setFocus();
  }

  @AfterClass
  public static void sleep() {
    bot.sleep(2500);
  }
}
