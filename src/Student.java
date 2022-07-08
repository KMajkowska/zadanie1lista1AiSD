
public class Student {
	
		int Index_nr; 
		double scholarship; 
		public Student()
		{
			Index_nr=0; 
			scholarship=0; 
		}
		public Student(int nr, double amount){
			Index_nr=nr; 
			scholarship=amount; 
		} 
		public void increaseScholarship(double amount){
			scholarship+=amount; 
		} 
		public String ShowData(){ 
			return "Indeks: " + Index_nr + " stypendium: " + scholarship; 
		}
	}
