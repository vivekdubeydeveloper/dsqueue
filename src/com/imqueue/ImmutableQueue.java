package com.imqueue;

import java.util.Stack;

public final class ImmutableQueue<T> implements Queue<T> {

	private final Stack<T> backwards;
	private final Stack<T> forwards;

	public ImmutableQueue() {
		this.forwards = new Stack<T>();
		this.backwards = new Stack<T>();
	}
	
	private ImmutableQueue(Stack<T> forwards,Stack<T> backwards) {
		this.forwards =forwards;
		this.backwards=backwards;
	}

	@Override
	public Queue<T> enQueue(T t) {
		addInQueue(t);
		return new ImmutableQueue<T>(forwards, backwards);
	}

	private void addInQueue(T t) {
		while (!forwards.isEmpty()) {
			backwards.push(forwards.pop());
		}

		forwards.push(t);

		while (!backwards.isEmpty()) {
			forwards.push(backwards.pop());
		}
	}

	@Override
	public Queue<T> deQueue() {
		forwards.pop();
		return new ImmutableQueue<T>(forwards, backwards);
	}

	@Override
	public T head() {
		return forwards.pop();
	}

	@Override
	public boolean isEmpty() {
		return forwards.size() == 0;
	}

}
