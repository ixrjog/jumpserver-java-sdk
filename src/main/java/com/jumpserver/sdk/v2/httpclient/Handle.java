//package com.jumpserver.sdk.v2.httpclient;
//
//
//
//public class Handle<T> {
//
//	private final HttpResponse response;
//	private final Class<T> returnType;
//	private final ExecutionOptions<T> options;
//	private final boolean requiresVoidBodyHandling;
//	private T returnObject;
//
//	private boolean complete;
//
//	private Handle(HttpResponse response, Class<T> returnType, ExecutionOptions<T> options, boolean requiresVoidBodyHandling) {
//		this.response = response;
//		this.returnType = returnType;
//		this.options = options;
//		this.requiresVoidBodyHandling = requiresVoidBodyHandling;
//	}
//
//	static <T> Handle<T> create(HttpResponse response, Class<T> returnType, ExecutionOptions<T> options, boolean requiresVoidBodyHandling) {
//		return new Handle<T>(response, returnType, options, requiresVoidBodyHandling);
//	}
//
//	Handle<T> complete(T returnObject) {
//		this.complete = true;
//		this.returnObject = returnObject;
//		return this;
//	}
//
//	Handle<T> continueHandling() {
//		this.complete = false;
//		return this;
//	}
//
//	public T getReturnObject() {
//		return returnObject;
//	}
//
//	public boolean isComplete() {
//		return complete;
//	}
//
//	public HttpResponse getResponse() {
//		return response;
//	}
//
//	public Class<T> getReturnType() {
//		return returnType;
//	}
//
//	public ExecutionOptions<T> getOptions() {
//		return options;
//	}
//
//	public boolean isRequiresVoidBodyHandling() {
//		return requiresVoidBodyHandling;
//	}
//}
