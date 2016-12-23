package com.revature.collections;

import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedBag<E> implements Iterable<Pair<E,Integer>> {
	final private SortedMap<E, Integer> inner;

	public SortedBag() {
		inner = new TreeMap<E, Integer>();
	}

	public SortedBag(List<E> list) {
		this();
		for (E e : list) {
			add(e);
		}
	}

	public int size() {
		int RetVal = 0;
		for (E key : inner.keySet()) {
			RetVal += inner.get(key);
		}
		return RetVal;
	}

	public boolean isEmpty() {
		return inner.isEmpty();
	}

	public boolean contains(E o) {
		return inner.containsKey(o);
	}

	public boolean add(E e) {
		Integer count = inner.get(e);
		if (count == null) {
			count = 0;
		}
		inner.put(e, count + 1);
		return true;
	}

	public boolean remove(E e) {
		Integer count = inner.get(e);
		if (count == null) {
			count = 0;
		}
		inner.put(e, count - 1);
		return count > 0;
	}

	public void clear() {
		inner.clear();
	}

	@Override
	public Iterator<Pair<E, Integer>> iterator() {
		return new Iterator<Pair<E, Integer>>(){
			
			final Iterator<E> keyIter=inner.keySet().iterator();
			final Iterator<Integer> valueIter=inner.values().iterator();
			
			@Override
			public boolean hasNext() {
				return keyIter.hasNext();
			}

			@Override
			public Pair<E,Integer> next() {
				return new Pair<E,Integer>(keyIter.next(),valueIter.next());
			}
		};
	}
	
	@Override
	public String toString()
	{
		StringBuilder RetVal=new StringBuilder();
		for(Pair<E,Integer> pair:this)
		{
			RetVal.append(pair.first);
			RetVal.append("(");
			RetVal.append(pair.second);
			RetVal.append("),");
		}
		return RetVal.toString();
	}
}
