/*
 * Tests the ProfessorMap class
 */
public class ProfessorMapTester
{
	public static void main(String[] args)
	{
		ProfessorMap map = new ProfessorMap();
		
		String[] professors = {"Eric", "Tim", "Isaac", "Cherie", "Jake", "Jake", "Isaac", "Jake"};
		String[] students = {"S.Mart", "S.Harp", "B.Right", "C.Reative", "Q.Uick", "A.Stute", "P.Erceptive", "C.Lever"};
		
		for (int i = 0; i < professors.length; i++)
		{
			map.add(professors[i], students[i]);
		}
		map.printStudentsOfProfessor();
		System.out.println("Expected:\nCherie: 1 - C.Reative\nEric: 1 - S.Mart\nIsaac: 2 - B.Right, P.Erceptive\n"
				+ "Jake: 3 - Q.Uick, A.Stute, C.Lever\nTim: 1 - S.Harp");
	}
}