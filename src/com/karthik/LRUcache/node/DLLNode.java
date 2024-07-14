package com.karthik.LRUcache.node;

public class DLLNode<T>
{
	T data;
	DLLNode<T> prev;
	DLLNode<T> next;

	public DLLNode(T data)
	{
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}
}
