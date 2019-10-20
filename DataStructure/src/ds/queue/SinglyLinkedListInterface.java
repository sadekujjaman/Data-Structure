package ds.queue;

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

public interface SinglyLinkedListInterface {

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
	 *  }
	 */
	void insertAtPos(int val, int pos);
	
	/**
	 * {@code
	 *  find the index of the @param val from the list 
	 *  } 
	 */
	int findIndex(int val);
	
	/**
	 * {@code
	 *  find the value of the @param pos from the list
	 *  }
	 */
	int findValAtPos(int pos);
	
	/**
	 * {@code
	 *  print all the element from the list form first to last
	 *  }
	 */
	void traverse();
	
	/**
	 * {@code
	 *  delete all occurrence from the list of a specified @param val value
	 *  }
	 */
	void deleteAllOccur(int val);
	
	/**
	 * {@code
	 *  delete first occurrence from the list of a specified @param val value
	 *  from first
	 *  }
	 */
	void deleteFirstOccur(int val);
	
	/**
	 * {@code
	 *  Delete the value at position @param pos
	 * }
	 * @param pos
	 */
	void deletePos(int pos);
	
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
