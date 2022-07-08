import java.util.*;

class ArrayRow<E> {
	E [] COL;
	@SuppressWarnings("unchecked")
	ArrayRow( int len )
	{
		COL = (E[])(new Object[len]);
	}
	void resize( int new_len )
	{
		COL = resizeArray(COL, new_len);
	}
	void setAt( int pos, E e ) throws ArrayIndexOutOfBoundsException
	{
		 if(pos < COL.length)
		 {
			 COL[pos] = e;
		 }
		 else
			 throw new ArrayIndexOutOfBoundsException();
	}
	E getAt( int pos ) throws ArrayIndexOutOfBoundsException
	{
		if(pos < COL.length)
		{
			E e = COL[pos];
			return e;
		}
		else
			throw new ArrayIndexOutOfBoundsException();
	}
	
	
	E [] resizeArray(E [] tab, int new_len)
	{
		E [] resized = Arrays.copyOf(tab, new_len);
		return resized;
	}
	
	int Col_length()
	{
		return COL.length;
	}
	
}


class Unbalanced2DArray<E> implements Iterable<E>{
		
	ArrayRow<E>[] ROW;
	@SuppressWarnings("unchecked")
	 Unbalanced2DArray( int row_cnt)
	 {
		 ROW = new ArrayRow[row_cnt];
	 }
	 void insertRow( int pos ) throws ArrayIndexOutOfBoundsException
	 {
		 if(pos < ROW.length)
		 {
			 ROW = insert(ROW, pos);
		 }
		 else
			 throw new ArrayIndexOutOfBoundsException();
	 }
	 void setRowSize( int row_ind, int new_size ) 
	 throws ArrayIndexOutOfBoundsException
	 {
		 if(row_ind < ROW.length)
		 {
			 ROW[row_ind].resize(new_size);
		 }
		 else
			 throw new ArrayIndexOutOfBoundsException();
	 }
	 void deleteRow( int row_ind ) throws ArrayIndexOutOfBoundsException
	 {
		 if(row_ind < ROW.length)
		 {
			 ROW = delete(ROW, row_ind);
		 }
		 else
			 throw new ArrayIndexOutOfBoundsException();
	 }
	 void setAt( int row_ind, int col_ind, E e ) 
	 throws ArrayIndexOutOfBoundsException
	 {
		 if(row_ind < ROW.length)
		 {
			 ROW[row_ind].setAt(col_ind, e);
		 }
		 else
			 throw new ArrayIndexOutOfBoundsException();
	 }
	 E getAt( int row_ind, int col_ind ) throws ArrayIndexOutOfBoundsException
	 {
		 if(row_ind < ROW.length)
		 {
			 E e = (E)ROW[row_ind].getAt(col_ind);
			 return e;
		 }
		 else
			 throw new ArrayIndexOutOfBoundsException();
	 }
	 public Iterator<E> iterator()
	 {
		 Iterator<E> iter = new ArrayIterator<E>(ROW);
		 return iter;
	 }
	 public Iterator<E> rewIterator()
	 {
		 Iterator<E> iter = new ArrayReverseIterator<E>(ROW);
		 return iter;
	 }
	 
	 void newRow(int len, int i)
	 {
		 if(i < Row_length())
		 {
			 ROW[i] = new ArrayRow<E>(len);
		 }
		 else
			 throw new ArrayIndexOutOfBoundsException();
	 }
	 
	 ArrayRow<E> [] insert(ArrayRow<E>[] ROW, int pos)
	 {
		 ArrayRow<E>[] changed = new ArrayRow[ROW.length+1];
		 for (int i = 0; i < pos; i++) {
			 changed[i] = ROW[i];
		    }
		 	changed[pos] = null;
		    for (int i = pos + 1; i < ROW.length; i++) {
		        changed[i] = ROW[i - 1];
		    }
		 return changed;
	 }
	 
	 ArrayRow<E> [] delete(ArrayRow<E>[] ROW, int pos)
	 {
		 ArrayRow<E>[] changed = new ArrayRow[ROW.length-1];
		 if(pos!=0)
		 {
			 for (int i = 0; i < pos; i++) 
			 {
				 changed[i] = ROW[i];
			 }
			 for (int i = pos + 1; i < ROW.length; i++) 
			 {
				 changed[i] = ROW[i];
			 }
			 return changed;
		 }
		 else
		 {
			 for (int i = pos + 1; i < ROW.length; i++) 
			 {
				 changed[i-1] = ROW[i];
			 }
			 return changed;
		 }
		 		
	 }

	int Row_length()
	{
		return ROW.length;
	}
	
	int Row_length_i(int pos)
	{
		return ROW[pos].Col_length();
	}

	
}
	 
	 class ArrayReverseIterator<E> implements Iterator<E> {
		  ArrayRow<E> [] array;
		  int row;
		  int col;

		  ArrayReverseIterator(ArrayRow<E> [] ROW) {
		    array = ROW;
		    row = array.length-1;
		    col = array[row].Col_length()-1;
		  }
		  public boolean hasNext() {
		    return row >= 0;
		  }
		  public E next() throws NoSuchElementException {
		    if (hasNext())
		      {
		    	if(col>0) {
					col--;
					return (E) array[row].getAt(col+1);
				}
				else
				{
					row--;
					col = array[row].Col_length()-1;
					return (E) array[row].getAt(0);
				}
		      }
		    else
		      throw new NoSuchElementException();
		  }
		  public void remove() {
		    throw new UnsupportedOperationException();
		  }
	}
	 
	 class ArrayIterator<E> implements Iterator<E> {
		 ArrayRow<E> [] array;
		 int row;
		 int col;
		 ArrayIterator(ArrayRow<E> [] ROW) {
			 array = ROW;
			 row = 0;
			 col = 0;
		 }
		 public boolean hasNext() {
			 return row < array.length;
		 }
		 @SuppressWarnings("unchecked")
		 public E next() throws NoSuchElementException {
			if(hasNext())
			{
				if(col<array[row].Col_length()) {
					col++;
					return (E) array[row].getAt(col-1);
				}
				else
				{
					row++;
					col = 1;
					return (E) array[row].getAt(col-1);
				}
			}
			else
			{
				throw new NoSuchElementException();
			}
		 }
		 public void remove() {
			 throw new UnsupportedOperationException();
		 }
	 	}