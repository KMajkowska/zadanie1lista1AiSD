import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Wpisaæ studentów czy inty? [s/i]");
		char odp  = scan.next().charAt(0);
		if(odp == 's')
		{
			Unbalanced2DArray<Student> tab = new Unbalanced2DArray<Student>(0);
			String tab_class = "Student";
			choice(tab, tab_class);
		}
		else
		{
			Unbalanced2DArray<Integer> tab = new Unbalanced2DArray<Integer>(0);
			String tab_class = "Integer";
			choice(tab, tab_class);
		}
	}
	public static void choice(Unbalanced2DArray tab, String tab_class)
	{
		Scanner scan = new Scanner(System.in);
		int n;
		do
		{
			showMenu();
			n = scan.nextInt();
			switch(n)
			{
			case 1:
			{
				int row_ind;
				System.out.println("Ile ma byæ wierszy");
				row_ind = scan.nextInt();
				if(tab_class == "Student")
				{
					tab = new Unbalanced2DArray<Student>(row_ind);
				}
				else
				{
					tab = new Unbalanced2DArray<Integer>(row_ind);
				}
				break;
			}
			case 2:
			{
				for(int i=0; i<tab.Row_length(); i++)
				{
					System.out.println("Ile ma byæ kolumn?");
					int col_ind;
					col_ind = scan.nextInt();
					tab.newRow(col_ind, i);
				}
				break;
				
			}
			case 3:
			{
				if(tab_class == "Integer")
				{
					for(int i=0; i<tab.Row_length(); i++)
					{
						for(int j=0; j<tab.Row_length_i(i); j++)
						{
							System.out.println("Podaj liczbe");
							int nr = scan.nextInt();
							tab.setAt(i, j, nr);
						}
					}
				}
				else
				{
					for(int i=0; i<tab.Row_length(); i++)
					{
						for(int j=0; j<tab.Row_length_i(i); j++)
						{
							System.out.println("Podaj nr indeksu i stypendium");
							int nr_index = scan.nextInt();
							int scholarship = scan.nextInt();
							tab.setAt(i, j, new Student(nr_index, scholarship));
						}
					}
				}
				break;
			}
			case 4:
			{
				System.out.println("Na jakiej pozycji ma byæ nowy wiersz?");
				int i;
				i = scan.nextInt();
				tab.insertRow(i);
				System.out.println("Ile ma byæ kolumn?");
				int col_ind;
				col_ind = scan.nextInt();
				tab.newRow(col_ind, i);                                                                                                                                                                                                                                     
				if(tab_class == "Integer")
				{
					for(int j=0; j<tab.Row_length_i(i); j++)
					{
						System.out.println("Podaj liczbe");
						int nr = scan.nextInt();
						tab.setAt(i, j, nr);					
					}
				}
				else
				{
					for(int j=0; j<tab.Row_length_i(i); j++)
					{
						System.out.println("Podaj nr indeksu i stypendium");
						int nr_index = scan.nextInt();
						int scholarship = scan.nextInt();
						tab.setAt(i, j, new Student(nr_index, scholarship));
					}
				}
				break;
			}
			case 5:
			{
				System.out.println("Z jakiej pozycji ma byæ usuniêty wiersz?");
				int i;
				i = scan.nextInt();
				tab.deleteRow(i);
				break;
			}
			case 6:
			{
				System.out.println("Który wiersz zmieniæ i na jak¹ d³ugoœæ?");
				int row_ind, new_size;
				row_ind = scan.nextInt();
				new_size= scan.nextInt();
				tab.setRowSize(row_ind, new_size);
				break;
			}
			case 7:
			{
				Iterator iter=tab.iterator();
				while(iter.hasNext())
				{
					if(tab_class == "Integer")
						System.out.println(iter.next());
					else
					{
						Student s = new Student();
						s = (Student)(iter.next());
						System.out.println(s.ShowData());
					}
				}
				break;
			}
			case 8:
			{
				Iterator iter=tab.iterator();
				while(iter.hasNext())
				{
					if(tab_class == "Integer")
						System.out.println(iter.next());
					else
					{
						Student s = new Student();
						s = (Student)(iter.next());
						System.out.println(s.ShowData());
					}
				}
				break;
			}
			case 9:
			{
				System.out.println("Który element zmieniæ");
				int row_ind, col_ind;
				row_ind = scan.nextInt();
				col_ind = scan.nextInt();
				if(tab_class == "Integer")
				{
					System.out.println("Wpisz inta");
					int number = scan.nextInt();
					tab.setAt(row_ind, col_ind, number);
				}
				else
				{
					System.out.println("Wpisz dane studenta");
					int nr = scan.nextInt();
					int scholarship = scan.nextInt();
					Student s = new Student(nr, scholarship);
					tab.setAt(row_ind, col_ind, s);
				}
				break;
			}
			case 10:
			{
				System.out.println("Który element wyœwietliæ");
				int row_ind, col_ind;
				row_ind = scan.nextInt();
				col_ind = scan.nextInt();
				if(tab_class == "Integer")
					System.out.println((Integer)(tab.getAt(row_ind, col_ind)));
				else
				{
					Student s = new Student();
					s = (Student)(tab.getAt(row_ind, col_ind));
					System.out.println(s.ShowData());
				}
				break;
			}
			}
		}while(n!=0);
	}


	public static void showMenu()
	{
		System.out.println("Menu:");
		System.out.println("0: Zakoñcz dzia³anie programu");
		System.out.println("1: Stworz tablie o n wierszach");
		System.out.println("2. Wype³nij wiersze kolumnami");
		System.out.println("3. Wype³nij ca³¹ tablicê wartoœciami");
		System.out.println("4. Dodaj wiersz");
		System.out.println("5. Usuñ wiersz");
		System.out.println("6. Zmieñ rozmiar wiersza");
		System.out.println("7. Wyœwietl tablicê ");
		System.out.println("8. Wyœwietl tablicê od koñca");
		System.out.println("9. Zmieñ element w tablicy");
		System.out.println("10. Wyœwietl konkretny element w tablicy");
		System.out.println("11. Zmieñ ka¿dy element w tablicy");
	}

}
