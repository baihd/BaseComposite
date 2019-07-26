package com.composite.mybatis.executor;

public interface Excutor {
    <T> T query(String statement, Object parameter);
}
