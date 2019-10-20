

package ds.doublyLinked;

/**
 * 
 * 
 * @author Saju
 *
 *  
 */

/**
 * 
 * {@code
 * This class contains the all methods for a Linked List
 * }
 *
 */

public interface DoublyLinkedListInterface {

	/**
	 *  {@code
	 *   insert @param val as the last element of the list
	 * }
	 */
	void insertVal(int val);
	
	/**
	 * {@code  
	 *   insert @param val as the second element of the list from last
	 *   }
	 */
	void insertValBeforeTail(int val);
	
	/**
	 * {@code
	 *   insert @param val as first element of the list
	 *   }
	 */
	void insertAtHead(int val);
	
	/**
	 * {@code
	 *  insert @param val as the second element of the list from first
	 *  }
	 */
	void insertAfterHead(int val);
	
	/**
	 * {@code
	 *  insert @param val at specified @param pos position
	 *  from first
	 *  }
	 */
	void insertAtPos(int val, int pos);
	
	/**
	 * {@code
	 *  insert @param val at specified @param pos position
	 *  from last
	 *  }
	 */
	void insertAtRevPos(int val, int pos);
	
	
	/**
	 * {@code
	 *  find the index of the @param val from the list 
	 *  from first (First Occurrence)
	 *  } 
	 */
	int findIndexFromFirst(int val);
	
	/**
	 * {@code
	 *  find the index of the @param val from the list 
	 *  from last (first Occurrence)
	 *  } 
	 */
	int findIndexFromLast(int val);
	
	/**
	 * {@code
	 *  find the value of the @param pos from the list
	 *  from first(first Occurrence)
	 *  }
	 */
	int findValAtPosFromFirst(int pos);
	
	/**
	 * {@code
	 *  find the value of the @param pos from the list
	 *  from Last(first Occurrence)
	 *  }
	 */
	int findValAtPosFromLast(int pos);
	
	/**
	 * {@code
	 *  print all the element from the list from first to last
	 *  }
	 */
	void traverse();
	
	/**
	 * {@code
	 * print all the element from the list from last to first
	 */
	void traverseBack();
	
	/**
	 * {@code
	 *  delete all occurrence from the list of a specified @param val value
	 *  }
	 */
	void deleteAllOccur(int val);
	
	/**
	 * {@code
	 *  delete first occurrence from the list of a specified @param val value
	 *  from first (First Occurrence)
	 *  }
	 */
	void deleteFirstOccurFromFirst(int val);
	
	/**
	 * {@code
	 *  delete first occurrence from the list of a specified @param val value
	 *  from last(First Occurrence)
	 *  }
	 */
	void deleteFirstOccurFromLast(int val);
	
	/**
	 * {@code
	 *  delete the first element from the list
	 *  }
	 */
	void deleteHead();
	
	/**
	 * {@code
	 *  delete the last element from the list
	 *  }
	 */
	void deleteTail();
	
	/**
	 * {@code
	 *  delete All the element from the list
	 *  }
	 */
	void deleteAll();
}
