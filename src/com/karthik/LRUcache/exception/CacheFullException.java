package com.karthik.LRUcache.exception;

public class CacheFullException extends RuntimeException
{
	public CacheFullException(String message)
	{
		super(message);
	}
}