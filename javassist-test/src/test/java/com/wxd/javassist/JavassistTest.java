package com.wxd.javassist;

import com.wxd.bank.dao.AccountDao;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 12:27
 */
public class JavassistTest {
    @Test
    public void testGenerateFirstClass() throws Exception {
        //获取类池，这个类池就是用来生成class的
        ClassPool pool = ClassPool.getDefault();
        //制造类（需要告诉javassist 类名是啥）
        CtClass ctClass = pool.makeClass("com.wxd.bank.dao.Impl.AccountDaoImpl");
        //制造方法
        String methodCode = "public void insert(){System.out.println(123);}";
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        //将方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成class
        ctClass.toClass();

        //类加载到JVM中，返回AccountDaoImpl类的字节码
        Class<?> clazz = Class.forName("com.wxd.bank.dao.Impl.AccountDaoImpl");
        //创建对象
        Object obj = clazz.newInstance();
        //获取AccountDaoImpl中的insert方法
        Method insertMethod = clazz.getDeclaredMethod("insert");
        //调用insert方法
        insertMethod.invoke(obj);
    }

    @Test
    public void testGenerateImpl() throws Exception{
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass("com.wxd.bank.dao.Impl.AccountDaoImpl");
        //制造接口
        CtClass ctInterface = pool.makeInterface("com.wxd.bank.dao.AccountDao");
        //添加接口到类中
        ctClass.addInterface(ctInterface);
        //实现接口中的方法
        //制造方法
        CtMethod ctMethod = CtMethod.make("public void delete(){System.out.println(\"hello\");}", ctClass);
        //将方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成类，同时将生成的类加载到JVM中
        Class<?> clazz = ctClass.toClass();
        AccountDao accountDao = (AccountDao) clazz.newInstance();
        accountDao.delete();
    }

    @Test
    public void testGenerateAccountDaoImpl() throws Exception{
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass("com.wxd.bank.dao.Impl.AccountDaoImpl");
        //制造接口
        CtClass ctInterface = pool.makeInterface("com.wxd.bank.dao.AccountDao");
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口中所有的方法
        Method[] methods = AccountDao.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            //method是接口中的抽象方法
            //实现method中的抽象方法
            try {
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg" + i);
                    if (i != parameterTypes.length - 1){
                        methodCode.append(",");
                    }
                }
                methodCode.append("){System.out.println(111);");
                //动态添加return语句
                String returnTypeSimpleName = method.getReturnType().getSimpleName();
                if ("void".equals(returnTypeSimpleName)){

                }else if ("int".equals(returnTypeSimpleName)){
                    methodCode.append("return 1;");
                }else if ("String".equals(returnTypeSimpleName)){
                    methodCode.append("return\"hello\";");
                }
                methodCode.append("}");
                System.out.println(methodCode);
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        Class<?> clazz = ctClass.toClass();
        AccountDao accountDao = (AccountDao) clazz.newInstance();
        accountDao.insert("ada");
        accountDao.delete();
        accountDao.update("daf",10.0);
        accountDao.selectByActno("aaa");
    }
}
