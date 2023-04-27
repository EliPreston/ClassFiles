/*
 * Tests the ManagerMap class
 */
public class ManagerMapTester
{
	public static void main(String[] args)
	{
		ManagerMap map = new ManagerMap();
		
		String[] managers = {"BossMan", "BigBoss", "CEODude", "Director", "Manager", "BossMan", "CEODude", "BigBoss", "Director", "BossMan",
				                     "Director", "BossMan", "BossMan"};
		String[] employees = {"Cate", "Russell", "Hugh", "Heath", "Nicole", "Toni", "Guy", "Rose", "Naomi", "Chris", "Liam","Margot", "Sam"};
		
		for (int i = 0; i < managers.length; i++)
		{
			map.add(managers[i], employees[i]);
		}
		map.printEmployeesOfManager();
		System.out.println("Expected:\nBigBoss: 2 - Russell, Rose\nBossMan: 5 - Cate, Toni, Chris, Margot, Sam\n" 
				+ "CEODude: 2 - Hugh, Guy\nDirector: 3 - Heath, Naomi, Liam\nManager: 1 - Nicole");
	}
}
