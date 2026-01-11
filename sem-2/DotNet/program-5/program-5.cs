using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace studentinfo_inheritance
{
  public class Student {
    public string rollno = "DCN100";
    public string name="saran";
  }
  public class Sport:Student {
    public string sportname="vollyball";
  }
    public class Marks : Sport {
      public string result = "pass";
      public void cal() {
        int m1 = 50;
        int m2 = 80;
        int total = m1 + m2;
        double avg = total / 2;
      Console.WriteLine(" Total :" + total);
      Console.WriteLine(" Average :" + avg);
    }
  }
  internal class Program {
    static void Main(string[] args){
      Marks s = new Marks();
      Console.WriteLine("RollNo :"+s.rollno);
      Console.WriteLine("Student Name :" + s.name);
      Console.WriteLine("Sport Name :" + s.sportname);
      Console.WriteLine("Result :" + s.result);
      s.cal();
    }
  }
}
