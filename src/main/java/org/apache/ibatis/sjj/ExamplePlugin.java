package org.apache.ibatis.sjj;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author unjiajie
 * @date 2021/3/8
 */
@Intercepts(
  {
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
  }
)

public class ExamplePlugin implements Interceptor {

  private int testProp;

  public int getTestProp() {
    return testProp;
  }

  public void setTestProp(int testProp) {
    this.testProp = testProp;
  }

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    Object[] args = invocation.getArgs();
    Method method = invocation.getMethod();
    Object target = invocation.getTarget();
    System.out.println("target: " + target + ", method: " + method.getName() + ", args" + Arrays.toString(args));
    return invocation.proceed();
  }

}
