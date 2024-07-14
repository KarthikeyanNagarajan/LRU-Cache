package com.karthik.LRUcache.policy;

import java.util.HashMap;
import java.util.Map;

import com.karthik.LRUcache.node.DLLNode;
import com.karthik.LRUcache.node.DLLQueue;

public class LRUEvictPolicy<Key> implements EvictPolicy<Key>
{
	private DLLQueue<Key> dll;
	private Map<Key, DLLNode<Key>> mapper;

	public LRUEvictPolicy()
	{
		this.dll = new DLLQueue<>();
		this.mapper = new HashMap<>();
	}

	@Override
	public void keyAccessed(Key key)
	{
		if (mapper.containsKey(key))
		{
			dll.detachNode(mapper.get(key));
			dll.insertNodeAtLast(mapper.get(key));
		}
		else
		{
			DLLNode<Key> newNode = new DLLNode<>(key);
			dll.insertNodeAtLast(newNode);
			mapper.put(key, newNode);
		}
	}

	@Override
	public Key evictKey()
	{
		DLLNode<Key> first = dll.getFirstNode();
		if (first == null)
			return null;

		dll.detachNode(first);
		return first.getData();
	}

}
