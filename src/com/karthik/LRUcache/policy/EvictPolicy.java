package com.karthik.LRUcache.policy;

public interface EvictPolicy<Key>
{
	void keyAccessed(Key key);

	Key evictKey();
}
