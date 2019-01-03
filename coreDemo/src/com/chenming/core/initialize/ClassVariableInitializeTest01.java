package com.chenming.core.initialize;

/**
 * 测试 类变量(静态变量) 初始化
 * @author Lenovo
 *
 */
class Cup{  
    Cup(int marker){  
        System.out.println("Cup("+marker+")");  
    }  
    void f(int marker){  
        System.out.println("f("+marker+")");  
    }  
}  
class Cups{  
    static Cup c1;  
    static Cup c2;  
    static{  
        c1 = new Cup(1);  
        c2 = new Cup(2);  
    }  
    Cups(){  
        System.out.println("Cups()");  
    }  
} 
public class ClassVariableInitializeTest01
{
	public static void main(String[] args)
	{
		
	}
	static Cups x;
	static Cups y;
}
