package TestScript;

import org.testng.annotations.Test;

import Superclass.Baseclass;
import UtilityClass.ActionsMethod;

public class Testwebtable extends Baseclass
{
	@Test
	void openApplication()
	{
		ActionsMethod.Get(driver,"https://qavbox.github.io/demo/webtable/");
	}
}
