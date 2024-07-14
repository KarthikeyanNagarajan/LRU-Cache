package com.karthik.LRUcache.node;

public class DLLQueue<T>
{
	DLLNode<T> head;
	DLLNode<T> tail;

	public DLLQueue()
	{
		head = new DLLNode<>(null);
		tail = new DLLNode<>(null);

		// head -> tail
		// head <- tail
		head.next = tail;
		tail.prev = head;
	}

	// add node at the end of DLL
	public void insertNodeAtLast(DLLNode<T> node)
	{
		// tailprev -> node -> tail
		// tailprev <- node <- tail

		DLLNode<T> tailprev = tail.prev;
		tailprev.next = node;
		node.prev = tailprev;
		node.next = tail;
		tail.prev = node;
	}

	// detach node from DLL
	public void detachNode(DLLNode<T> node)
	{
		if (node != null)
		{
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	public DLLNode<T> getFirstNode()
	{
		if (head.next != tail)
			return head.next;
		return null;
	}

	public DLLNode<T> getLastNode()
	{
		if (head.next != tail)
			return tail.prev;
		return null;
	}
}
