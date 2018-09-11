//********************************************************************
//  SolveTowers.java       Java Foundations
//
//  Demonstrates recursion by solving the classic Towers of Hanoi
//  puzzle.
//********************************************************************

public class SolveTowers
{
   //------------------------------------------------------------------
   //  Creates a TowersOfHanoi puzzle and solves it.
   //------------------------------------------------------------------
   public static void main (String[] args)
   {
      TowersOfHanoi towers = new TowersOfHanoi (4);
      towers.solve();
   }
}
